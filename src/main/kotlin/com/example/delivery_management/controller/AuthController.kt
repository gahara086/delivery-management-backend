package com.example.delivery_management.controller

import com.example.delivery_management.util.JwtUtil
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val jwtUtil: JwtUtil,
    private val passwordEncoder: PasswordEncoder
) {
    private val users = mutableMapOf(
        "user1" to passwordEncoder.encode("password1"),
        "user2" to passwordEncoder.encode("password2")
    )

    @PostMapping("/login")
    fun login(@RequestBody authRequest: AuthRequest): Map<String, String> {
        println("Received login request: $authRequest")
        val storedPassword = users[authRequest.username]
        if (storedPassword != null && passwordEncoder.matches(authRequest.password, storedPassword)) {
            val token = jwtUtil.generateToken(authRequest.username)
            return mapOf("token" to token)
        }
        throw RuntimeException("Invalid username or password")
    }
}

data class AuthRequest(
    val username: String = "",
    val password: String = ""
)
