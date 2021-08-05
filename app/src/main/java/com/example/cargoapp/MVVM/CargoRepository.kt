package com.example.cargoapp.MVVM

import android.util.Log
import com.example.cargoapp.LoginRegister.User
import com.example.cargoapp.model.Cargo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class CargoRepository {

    private lateinit var database: DatabaseReference

    private fun defineDB(){
        database = Firebase.database.reference
    }

    fun getCurrentUser(): FirebaseUser? {
        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        return user
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

    fun listSendCargo(callback: (list: List<Cargo>) -> Unit){
        defineDB()
        var user = getCurrentUser()

        val list : MutableList<Cargo> = mutableListOf()
        if (user == null) {
            user=getCurrentUser()
        }
        database.child("cargo")
            .orderByChild("senderMail")
            .equalTo(user?.email)
            .get().addOnSuccessListener {

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

    fun listReceiveCargo(callback: (list: List<Cargo>) -> Unit){
        defineDB()
        getCurrentUser()
        val list : MutableList<Cargo> = mutableListOf()
        database.child("cargo")
            .orderByChild("receiverMail")
            .equalTo(user.email)
            .get().addOnSuccessListener {

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