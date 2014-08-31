package com.cholick.todo.data

import com.cholick.todo.domain.Todo

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

@com.google.inject.Singleton
class TodoDao {

    AtomicInteger sequence = new AtomicInteger(1)
    ConcurrentHashMap<Integer, Todo> todos = new ConcurrentHashMap()

    Todo create(String userId, Todo todo) {
        todo.id = sequence.incrementAndGet()
        todo.userId = userId
        todos.put(todo.id, todo)
        return todo
    }

    List<Todo> list(String userId) {
        return todos.values()
                .asList()
                .findAll { it.userId == userId.toLowerCase() }
    }

    Todo update(String userId, Integer id, Todo todo) {
        todo.id = id
        todo.userId = userId
        todos.put(id, todo)
        return todo
    }

    void delete(String userId, Integer id) {
        Todo todo = todos.get(id)
        if(todo && todo.userId == userId.toLowerCase()) {
            todos.remove(id)
        }
    }

}
