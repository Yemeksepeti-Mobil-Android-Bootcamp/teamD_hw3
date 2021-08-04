package com.example.cargoapp.MVVM

import android.util.Log
import com.example.cargoapp.LoginRegister.User
import com.example.cargoapp.model.Cargo
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
    fun addCargo(cargo: Cargo){
        defineDB()
        database.child("cargo").push().setValue(cargo)
    }

    fun listCargo(callback: (list: List<Cargo>) -> Unit){
        defineDB()
        database.child("cargo").get().addOnSuccessListener {
            val list : MutableList<Cargo> = mutableListOf()
            Log.i("firebase", "Got value ${it.value}")
            val children = it!!.children
            children.forEach {
                var cargo = it.getValue(Cargo::class.java)
                if (cargo != null) {
                    println(cargo)
                    list.add(cargo)
                }
            }
            callback(list)
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }

    }

}