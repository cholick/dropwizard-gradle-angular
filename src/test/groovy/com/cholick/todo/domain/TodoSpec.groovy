package com.cholick.todo.domain

import com.fasterxml.jackson.databind.ObjectMapper
import io.dropwizard.jackson.Jackson
import spock.lang.Specification

class TodoSpec extends Specification {

    ObjectMapper mapper

    def setup() {
        mapper = Jackson.newObjectMapper()
    }

    def 'serializes correctly to json'() {
        given:
        String expected = '{"item":"Buy the milk","completed":false}'
        Todo todo = new Todo(item: 'Buy the milk', completed: false)

        when:
        String serialized = mapper.writeValueAsString(todo)

        then:
        serialized == expected
    }

    def 'deserializes correctly from json'() {
        given:
        String serialized = '{"item":"Buy the milk","completed":false}'

        when:
        Todo todo = mapper.readValue(serialized, Todo.class)

        then:
        todo == new Todo(item: 'Buy the milk', completed: false)
    }

}
