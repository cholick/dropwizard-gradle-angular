package com.cholick.todo

import com.cholick.todo.data.TodoDao
import com.cholick.todo.domain.Todo
import com.cholick.todo.resources.TodoResource
import io.dropwizard.testing.junit.ResourceTestRule
import org.junit.Rule
import spock.lang.Specification

class TodoResourceSpec extends Specification {

    TodoResource resource = new TodoResource(Mock(TodoDao))

    @Rule
    ResourceTestRule resources = ResourceTestRule.builder().addResource(resource).build()

    def 'list will return list of todos'() {
        given:
        resource.todoDao.list() >> [
                new Todo(item: 'Buy milk', completed: false),
                new Todo(item: 'Mow lawn', completed: true),
        ]

        when:
        Map response = resources.client().resource("/todo").get(Map)

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

}
