package com.cholick.todo.views

import com.cholick.todo.domain.Todo
import io.dropwizard.views.View

class TodoView extends View {

    String user
    List<Todo> todos

    TodoView(String user, List<Todo> todos) {
        super('todo.ftl')
        this.user = user
        this.todos = todos
    }

}
