package com.cholick.todo.domain

import spock.lang.Specification

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator

class TodoSpec extends Specification {

    Validator validator

    def setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator()
    }

    def 'invalid todo fails validation'() {
        given:
        Todo invalidTodo = new Todo()

        when:
        Collection<ConstraintViolation> errors = validator.validate(invalidTodo)
        Set<String> invalidProperties = errors*.propertyPath.toString() as Set

        then:
        errors
        errors.size() == 1

        and:
        invalidProperties.contains('item')
    }

    def 'userId is email'() {
        given:
        Todo invalidTodo = new Todo(item: 'Get milk', userId: 'foo')

        when:
        Collection<ConstraintViolation> errors = validator.validate(invalidTodo)
        Set<String> invalidProperties = errors*.propertyPath.toString() as Set

        then:
        errors
        errors.size() == 1

        and:
        invalidProperties.contains('userId')
    }

    def 'valid todo passes validation'() {
        given:
        Todo validTodo = new Todo(item: 'Get milk', userId: 'matt@veryrealemail.com')

        when:
        Collection<ConstraintViolation> errors = validator.validate(validTodo)

        then:
        !errors
    }

}
