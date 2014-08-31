package com.cholick.todo

import com.cholick.todo.data.TodoDao
import com.cholick.todo.domain.Todo
import com.cholick.todo.resources.TodoResource
import io.dropwizard.testing.junit.ResourceTestRule
import org.junit.Rule
import spock.lang.Specification

import javax.validation.ValidationException
import javax.ws.rs.core.Response

class TodoResourceSpec extends Specification {

    TodoResource resource = new TodoResource(Mock(TodoDao))

    @Rule
    ResourceTestRule resources = ResourceTestRule.builder().addResource(resource).build()

    def 'list with GET'() {
        given:
        resource.todoDao.list('matt@veryrealemail.com') >> [
                new Todo(id: 1, userId: 'matt@veryrealemail.com', item: 'Buy milk', completed: false),
                new Todo(id: 2, userId: 'matt@veryrealemail.com', item: 'Mow lawn', completed: true),
        ]

        when:
        Map response = resources.client()
                .resource("/todo/matt@veryrealemail.com")
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
        1 * resource.todoDao.create('matt@veryrealemail.com', todo) >>
                new Todo(id: 1, userId: 'matt@veryrealemail.com', item: 'Read GTD', completed: false)

        when:
        Todo response = resources.client()
                .resource('/todo/matt@veryrealemail.com')
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
                .resource('/todo/matt@veryrealemail.com')
                .type('application/json')
                .post(Todo, todo)

        then:
        thrown(ValidationException)
    }

    def 'update with PUT'() {
        given:
        Todo todo = new Todo(item: 'Check email', completed: false, id: 1)

        and:
        1 * resource.todoDao.update('matt@veryrealemail.com', 1, todo) >>
                new Todo(id: 1, userId: 'matt@veryrealemail.com', item: 'Check email [server]', completed: false)

        when:
        Todo response = resources.client()
                .resource('/todo/matt@veryrealemail.com/1')
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
                .resource('/todo/matt@veryrealemail.com/1')
                .type('application/json')
                .put(Todo, todo)

        then:
        thrown(ValidationException)
    }

    def 'remove with DELETE'() {
        when:
        resources.client()
                .resource('/todo/matt@veryrealemail.com/1')
                .type('application/json')
                .delete()

        then:
        1 * resource.todoDao.delete('matt@veryrealemail.com', 1)
    }

}
