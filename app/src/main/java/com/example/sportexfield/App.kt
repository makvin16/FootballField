package com.example.sportexfield

import android.app.Application
import com.example.sportexfield.model.DataDto
import com.example.sportexfield.model.SchemaDto
import com.google.gson.Gson

class App : Application() {

    private var _schemas: List<SchemaDto> = listOf()
    val schemas: List<SchemaDto> get() = _schemas

    override fun onCreate() {
        super.onCreate()
        readJson()
    }

    private fun readJson() {
        try {
            val gson = Gson()
            val inputStream = applicationContext.assets.open("schemas.json")
            val buffer = ByteArray(inputStream.available())
            inputStream.read(buffer)
            val json = String(buffer)
            val data = gson.fromJson(json, DataDto::class.java)
            _schemas = data.data
            logger("$data")
        } catch (e: Exception) {
            logger("${e.message}")
        }
    }
}