package com.cholick.todo.resources

import com.cholick.todo.data.TodoDao
import com.google.inject.Inject

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path('/todo')
@Produces(MediaType.APPLICATION_JSON)
class TodoResource {

    TodoDao todoDao

    @Inject
    TodoResource(TodoDao todoDao) {
        this.todoDao = todoDao
    }

    @GET
    Map list() {
        return [data: todoDao.list()]
    }

}
