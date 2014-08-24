package com.cholick.todo.data

import com.cholick.todo.domain.Todo

class TodoDao {

    List<Todo> todos = [
            new Todo(item: 'Buy milk', completed: false),
            new Todo(item: 'Mail mortgage payment', completed: false),
            new Todo(item: 'Upload slides', completed: false),
            new Todo(item: 'Mow lawn', completed: true),
    ]

    List<Todo> list() {
        return todos
    }

}
