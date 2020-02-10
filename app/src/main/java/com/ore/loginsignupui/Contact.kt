package com.ore.loginsignupui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(val name: String?, val email: String, val phone: String) : Parcelable
