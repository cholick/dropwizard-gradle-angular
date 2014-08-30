package com.cholick.todo

import com.cholick.todo.data.TodoDao
import com.cholick.todo.domain.Todo
import com.cholick.todo.resources.TodoResource
import io.dropwizard.testing.junit.ResourceTestRule
import org.junit.Rule
import spock.lang.Specification

import javax.validation.ValidationException

class TodoResourceSpec extends Specification {

    TodoResource resource = new TodoResource(Mock(TodoDao))

    @Rule
    ResourceTestRule resources = ResourceTestRule.builder().addResource(resource).build()

    def 'list with GET'() {
        given:
        resource.todoDao.list() >> [
                new Todo(item: 'Buy milk', completed: false),
                new Todo(item: 'Mow lawn', completed: true),
        ]

        when:
        Map response = resources.client()
                .resource("/todo")
                .get(Map)

        then:
        response
        response.data

        and:
        response.data
        response.data.size() == 2

        and:
        response.data[0].item == 'Buy milk'
        !response.data[0].completed

        and:
        response.data[1].item == 'Mow lawn'
        response.data[1].completed
    }

    def 'create with POST'() {
        given:
        Todo todo = new Todo(item: 'Read GTD', completed: false)

        and:
        1 * resource.todoDao.create(todo) >> new Todo(id: 1, item: 'Read GTD', completed: false)

        when:
        Todo response = resources.client()
                .resource('/todo')
                .type('application/json')
                .post(Todo, todo)

        then:
        response
        response.id == 1
        response.item == 'Read GTD'
    }

    def 'POST with invalid todo throws error'() {
        given:
        Todo todo = new Todo()

        when:
        resources.client()
                .resource('/todo')
                .type('application/json')
                .post(Todo, todo)

        then:
        thrown(ValidationException)
    }

    def 'update with PUT'() {
        given:
        Todo todo = new Todo(item: 'Check email', completed: false, id: 1)

        and:
        1 * resource.todoDao.update(1, todo) >> new Todo(item: 'Check email [server]', completed: false, id: 1)

        when:
        Todo response = resources.client()
                .resource('/todo/1')
                .type('application/json')
                .put(Todo, todo)

        then:
        response
        response.id == 1
        response.item == 'Check email [server]'
    }

    def 'PUT with invalid todo throws error'() {
        given:
        Todo todo = new Todo()

        when:
        resources.client()
                .resource('/todo/1')
                .type('application/json')
                .put(Todo, todo)

        then:
        thrown(ValidationException)
    }

}
