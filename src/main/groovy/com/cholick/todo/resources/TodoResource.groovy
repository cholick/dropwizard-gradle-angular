package com.cholick.todo.resources

import com.cholick.todo.data.TodoDao
import com.cholick.todo.domain.Todo
import com.google.inject.Inject

import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Todo create(@Valid Todo todo) {
        return todoDao.create(todo)
    }

    @GET
    Map list() {
        return [data: todoDao.list()]
    }

    @PUT
    @Path('/{id}')
    @Consumes(MediaType.APPLICATION_JSON)
    Todo update(@PathParam('id') Integer id, @Valid Todo todo) {
        todo.id = id
        return todoDao.update(id, todo)
    }

}
