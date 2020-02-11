package com.ore.loginsignupui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Blog(val title: String?, val email: String, val post: String) : Parcelable
