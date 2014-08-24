package com.cholick.todo.domain

import org.hibernate.validator.constraints.NotEmpty

class Todo {

    @NotEmpty
    String item
    Boolean completed

}
