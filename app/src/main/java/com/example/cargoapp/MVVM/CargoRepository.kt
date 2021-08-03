package com.example.cargoapp.MVVM

import com.example.cargoapp.LoginRegister.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class CargoRepository {

    private lateinit var database: DatabaseReference

    fun defineDB(){
        database = Firebase.database.reference
    }

    fun writeNewUser(userId: String) {
        defineDB()
        val user = User(userId,null)

        database.child("users").child(userId).setValue(user)
    }
}