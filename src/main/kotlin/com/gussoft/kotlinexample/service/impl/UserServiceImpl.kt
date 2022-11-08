package com.gussoft.kotlinexample.service.impl

import com.gussoft.kotlinexample.excetion.GenericException
import com.gussoft.kotlinexample.model.User
import com.gussoft.kotlinexample.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import com.gussoft.kotlinexample.service.UserService as UserService

@Service
class UserServiceImpl(@Autowired val repo: UserRepository) : UserService {

    override fun findAll(): Iterable<User> {
        return repo.findAll()
    }

    override fun findById(id: Long): Optional<User> {
        val data: Optional<User> = repo.findById(id)
        if (data.isEmpty) {
            throw GenericException("Id no encontrado")
        }
        return data
    }

    override fun create(user: User): User {
        return repo.save(user)
    }

    override fun update(id: Long, user: User): User {
        val data: Optional<User> = repo.findById(id)
        if (data.isEmpty) {
            throw GenericException("Id no encontrado")
        }
        user.id = id;
        return repo.save(user)
    }

    override fun delete(id: Long) {
        repo.deleteById(id)
    }
}