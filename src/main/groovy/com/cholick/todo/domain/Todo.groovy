package com.cholick.todo.domain

import groovy.transform.AutoClone
import groovy.transform.EqualsAndHashCode

@AutoClone
@EqualsAndHashCode
class Todo {

    String item
    Boolean completed = false

}
