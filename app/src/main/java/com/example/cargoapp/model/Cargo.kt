package com.example.cargoapp.model

import com.example.cargoapp.LoginRegister.Adress

data class Cargo(
    var senderName: String,
    var senderTc:String,
    var senderMail:String,
    var senderAddress:String,
    val receiverName:String,
    var receiverTc:String,
    val receiverMail:String,
    val receiverAddress:String,
){
    constructor() : this("","","","",
        "","","","")
}