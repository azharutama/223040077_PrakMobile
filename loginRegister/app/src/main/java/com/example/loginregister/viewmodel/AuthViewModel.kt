package com.example.loginregister.viewmodel

class AuthViewModel {
    var loginState by mutableStateOf<Result<LoginResponse>?>(null)
    var registerState by mutableStateOf<Result<RegisterResponse>?>(null)

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.login(LoginRequest(email, password))
                loginState = Result.success(response)
            } catch (e: Exception) {
                loginState = Result.failure(e)
            }
        }
    }

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.register(RegisterRequest(name, email, password))
                registerState = Result.success(response)
            } catch (e: Exception) {
                registerState = Result.failure(e)
            }
        }
    }
}