package com.example.cargoapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
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
):Parcelable{
    constructor() : this("","","","",
        "","","","","","")
}