package com.camilo.vuelingo

class User {
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var password: String

    private val user = User()

    private fun User()
    {
        email = "jcagudelo42@misena.edu.co"
        name = "Camilo Agudelo"
        password = "1234"
    }

    fun getUser() = user

    fun getName() : String = name

    fun getEmail() : String = email

    fun getPassword() : String = password

    fun setName(name : String) {
        this.name = name
    }

    fun setEmail(email : String) {
        this.email = email
    }

    fun setPassword(password: String) {
        this.password = password
    }

}