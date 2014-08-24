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
        Collection<ConstraintViolation> errors =  validator.validate(invalidTodo)

        then:
        errors
        errors.size() == 1
        errors[0].propertyPath as String == 'item'
    }

    def 'valid todo passes validation'() {
        given:
        Todo validTodo = new Todo(item: 'Get milk')

        when:
        Collection<ConstraintViolation> errors =  validator.validate(validTodo)

        then:
        !errors
    }

}
