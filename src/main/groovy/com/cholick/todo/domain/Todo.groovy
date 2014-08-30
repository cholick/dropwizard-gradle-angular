package com.cholick.todo.domain

import groovy.transform.AutoClone
import groovy.transform.EqualsAndHashCode
import org.hibernate.validator.constraints.NotEmpty

@AutoClone
@EqualsAndHashCode
class Todo {

    Integer id

    @NotEmpty
    String item
    Boolean completed = false

}
