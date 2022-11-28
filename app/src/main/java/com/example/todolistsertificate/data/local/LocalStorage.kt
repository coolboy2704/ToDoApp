package com.example.todolistsertificate.data.local

import android.content.Context
import com.example.todolistsertificate.app.App
import com.example.todolistsertificate.utils.StringPreference

class LocalStorage {
    companion object {
        val pref = App.instance.getSharedPreferences("Kazibek", Context.MODE_PRIVATE)
    }

    val token by StringPreference(pref)
}