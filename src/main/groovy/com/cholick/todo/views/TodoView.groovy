package com.cholick.todo.views

import com.cholick.todo.domain.Todo
import io.dropwizard.views.View

class TodoView extends View {

    List<Todo> todos

    TodoView(List<Todo> todos) {
        super('todo.ftl')
        this.todos = todos
    }

}
