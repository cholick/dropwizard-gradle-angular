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
    ResourceTestRule resources = ResourceTestRule
            .builder()
            .addResource(resource)
            .build()

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

}
