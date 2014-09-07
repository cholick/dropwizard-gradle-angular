package com.cholick.todo.domain

import groovy.transform.AutoClone
import groovy.transform.EqualsAndHashCode

@AutoClone
@EqualsAndHashCode
class Todo {

    Integer id

    String userId

    String item
    Boolean completed = false

    void setUserId(String userId) {
        this.userId = userId?.toLowerCase()
    }

}
