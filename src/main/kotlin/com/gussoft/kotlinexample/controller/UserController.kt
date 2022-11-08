package com.gussoft.kotlinexample.controller

import com.gussoft.kotlinexample.model.User
import com.gussoft.kotlinexample.model.dto.GenericResponse
import com.gussoft.kotlinexample.model.dto.UserRequest
import com.gussoft.kotlinexample.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class UserController(@Autowired private val service: UserService) {

    @GetMapping("/user/")
    fun findAll() : ResponseEntity<Iterable<User>> {
        return ResponseEntity.ok(service.findAll())
    }

    @GetMapping("/user/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<User> {
        return ResponseEntity.ok(service.findById(id).get())
    }

    @PostMapping("/user/")
    fun saved(@RequestBody user: UserRequest): ResponseEntity<User> {
        return ResponseEntity.ok(service.create(User(user)))
    }

    @PutMapping("/user/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: UserRequest) : ResponseEntity<User> {
        return ResponseEntity.ok(service.update(id, User(user)))
    }

    @DeleteMapping("/user/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<GenericResponse> {
        service.delete(id)
        return ResponseEntity.ok(GenericResponse(HttpStatus.OK.value(), "OK"))
    }

}