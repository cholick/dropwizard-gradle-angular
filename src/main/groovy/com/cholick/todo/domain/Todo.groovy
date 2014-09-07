package com.cholick.todo.domain

import groovy.transform.AutoClone
import groovy.transform.EqualsAndHashCode
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty

@AutoClone
@EqualsAndHashCode
class Todo {

    Integer id

    @Email
    String userId

    @NotEmpty
    String item
    Boolean completed = false

    void setUserId(String userId) {
        this.userId = userId?.toLowerCase()
    }

}
