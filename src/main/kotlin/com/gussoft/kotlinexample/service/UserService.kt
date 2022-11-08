package com.gussoft.kotlinexample.service

import com.gussoft.kotlinexample.model.User
import java.util.Optional

interface UserService {

    fun findAll(): Iterable<User>

    fun findById(id: Long): Optional<User>

    fun create(user: User): User

    fun update(id: Long, user: User): User

    fun delete(id: Long)

}