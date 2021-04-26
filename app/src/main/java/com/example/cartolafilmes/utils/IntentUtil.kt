package com.example.cartolafilmes.utils

import android.content.Intent
import com.example.cartolafilmes.response.Movies
import com.google.gson.Gson
import com.google.gson.GsonBuilder

const val DEFALT_NAME = "object"

object IntentUtil{
    @Suppress("SpellCheckingInspection")
    val gson: Gson = GsonBuilder().create()
}

fun Intent.putExtraJson(src: Any){
    putExtra(DEFALT_NAME, IntentUtil.gson.toJson(src))
}

fun <T> Intent.getJsonExtra(`class`: Class<T>): T? {
    val stringExtra = getStringExtra(DEFALT_NAME)
    if (stringExtra != null){
        return IntentUtil.gson.fromJson(stringExtra, `class`)
    }
    return null
}