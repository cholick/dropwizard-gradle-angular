package com.cholick.todo.resources

import com.cholick.todo.data.TodoDao
import com.cholick.todo.domain.Todo
import com.cholick.todo.views.TodoView
import com.google.inject.Inject

import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path('/todo/{userId}')
@Produces(MediaType.APPLICATION_JSON)
class TodoResource {

    TodoDao todoDao

    @Inject
    TodoResource(TodoDao todoDao) {
        this.todoDao = todoDao
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response create(@PathParam('userId') String userId, @Valid Todo todo) {
        Todo created = todoDao.create(userId, todo)
        return Response.status(201).entity(created).build()
    }

    @GET
    Map list(@PathParam('userId') String userId) {
        return [data: todoDao.list(userId)]
    }

    @PUT
    @Path('/{id}')
    @Consumes(MediaType.APPLICATION_JSON)
    Todo update(@PathParam('id') Integer id, @PathParam('userId') String userId, @Valid Todo todo) {
        return todoDao.update(userId, id, todo)
    }

    @DELETE
    @Path('/{id}')
    void delete(@PathParam('id') Integer id, @PathParam('userId') String userId) {
        todoDao.delete(userId, id)
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path('/view')
    TodoView view(@PathParam('userId') String userId) {
        return new TodoView(userId, todoDao.list(userId))
    }

}
