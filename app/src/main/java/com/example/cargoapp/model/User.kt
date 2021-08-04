package com.example.cargoapp.LoginRegister

data class User(
    var id: String? = null,
    var addresses: List<Adress>?
)

data class  Adress(
    var addressName: String? = null,
    var adress: String? = null
)