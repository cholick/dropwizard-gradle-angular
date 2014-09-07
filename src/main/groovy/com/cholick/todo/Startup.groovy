package com.cholick.todo

import com.cholick.todo.data.TodoDao
import com.cholick.todo.domain.Todo
import com.google.inject.Inject
import io.dropwizard.lifecycle.Managed

// http://dropwizard.github.io/dropwizard/0.7.1/dropwizard-lifecycle/apidocs/io/dropwizard/lifecycle/Managed.html
class Startup implements Managed {

    TodoDao todoDao

    @Inject
    Startup(TodoDao todoDao) {
        this.todoDao = todoDao
    }

    @Override
    void start() throws Exception {
        [
                new Todo(item: 'Buy milk', completed: false),
                new Todo(item: 'Mail mortgage payment', completed: false),
                new Todo(item: 'Upload slides', completed: false),
                new Todo(item: 'Mow lawn', completed: true),
        ].each {
            todoDao.create('matt@veryrealemail.com', it)
        }
    }

    @Override
    void stop() throws Exception {}

}
