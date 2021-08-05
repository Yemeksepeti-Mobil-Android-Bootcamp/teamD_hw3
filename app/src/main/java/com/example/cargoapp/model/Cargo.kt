package com.example.cargoapp.model

import com.example.cargoapp.LoginRegister.Adress

data class Cargo(
    val senderName: String,
    val senderTc:String,
    val senderMail:String,
    val senderAddress:String,
    val receiverName:String,
    val receiverTc:String,
    val receiverMail:String,
    val receiverAddress:String,
    val receiveDate:String,
    val sendDate:String
){
    constructor() : this("","","","",
        "","","","","","")
}