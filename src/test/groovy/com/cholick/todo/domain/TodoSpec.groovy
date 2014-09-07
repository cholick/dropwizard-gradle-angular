package com.cholick.todo.domain

import com.fasterxml.jackson.databind.ObjectMapper
import io.dropwizard.jackson.Jackson
import spock.lang.Specification

class TodoSpec extends Specification {

    ObjectMapper mapper

    String todoJson = '{"id":1,"userId":"a@a.com","item":"Buy the milk","completed":false}'
    Todo todo = new Todo(id: 1, userId: 'a@a.com', item: 'Buy the milk', completed: false)

    def setup() {
        mapper = Jackson.newObjectMapper()
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

}
