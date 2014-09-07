package com.cholick.todo.resources

import com.cholick.todo.domain.Todo

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path('/todo/')
@Produces(MediaType.APPLICATION_JSON)
class TodoResource {

    List<Todo> data = [
            new Todo(item: 'Buy milk', completed: false),
            new Todo(item: 'Mail mortgage payment', completed: false),
            new Todo(item: 'Upload slides', completed: false),
            new Todo(item: 'Mow lawn', completed: true)
    ]

    @GET
    Map list() {
        return [data: data]
    }

}
