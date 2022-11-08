package com.gussoft.kotlinexample.model

import com.gussoft.kotlinexample.model.dto.UserRequest
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "user", schema = "demo")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 10)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,
    var name: String,
    var created: LocalDate?,
    var email: String) {

    constructor() : this(null, "", null, "")

    constructor(user: UserRequest) : this(null, user.name, LocalDate.now(), user.email)

}
