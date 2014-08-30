package com.cholick.todo.data

import com.cholick.todo.domain.Todo

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

@com.google.inject.Singleton
class TodoDao {

    AtomicInteger sequence = new AtomicInteger(1)
    ConcurrentHashMap<Integer, Todo> todos = new ConcurrentHashMap()

    Todo create(Todo todo) {
        todo.id = sequence.incrementAndGet()
        todos.put(todo.id, todo)
        return todo
    }

    List<Todo> list() {
        return todos.values().asList()
    }

    Todo update(Integer id, Todo todo) {
        todos.put(id, todo)
        return todo
    }

}
