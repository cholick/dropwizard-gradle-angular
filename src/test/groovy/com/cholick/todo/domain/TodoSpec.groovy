package com.cholick.todo.domain

import com.fasterxml.jackson.databind.ObjectMapper
import io.dropwizard.jackson.Jackson
import spock.lang.Specification

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator

class TodoSpec extends Specification {

    ObjectMapper mapper
    Validator validator

    String todoJson = '{"id":1,"userId":"a@a.com","item":"Buy the milk","completed":false}'
    Todo todo = new Todo(id: 1, userId: 'a@a.com', item: 'Buy the milk', completed: false)

    def setup() {
        mapper = Jackson.newObjectMapper()
        validator = Validation.buildDefaultValidatorFactory().getValidator()
    }

    def 'serializes correctly to json'() {
        when:
        String serialized = mapper.writeValueAsString(todo)

        then:
        serialized == todoJson
    }

    def 'deserializes correctly from json'() {
        when:
        Todo deserialized = mapper.readValue(todoJson, Todo.class)

        then:
        deserialized == todo
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
