package com.lgcns.tct_template.data

import android.content.Context
import android.content.SharedPreferences

class TctPreference(context: Context) {

    private val editor: SharedPreferences.Editor
    private val pref: SharedPreferences =
        context.getSharedPreferences(context.applicationInfo.packageName, Context.MODE_PRIVATE)

    init {
        editor = pref.edit()
        editor.apply()
    }

    fun put(key: String, value: String) = editor.putString(key, value).commit()

    fun put(key: String, value: Int) = editor.putInt(key, value).commit()

    fun getString(key: String, def: String = ""): String = pref.getString(key, def) ?: def

    fun getInt(key: String, def: Int = 0): Int = pref.getInt(key, def)
}