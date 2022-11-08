package com.gussoft.kotlinexample.repository

import com.gussoft.kotlinexample.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>