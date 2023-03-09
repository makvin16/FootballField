package com.example.sportexfield

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sportexfield.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var app: App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        app = application as App

        val schemas = app.schemas
        val list = arrayOfNulls<String>(schemas.size)
        schemas.forEachIndexed { index, schema ->
            list[index] = "${index+1}:${schema.title}"
        }
        binding.picker.minValue = 0
        binding.picker.maxValue = schemas.size - 1
        binding.picker.displayedValues = list
        binding.btnShow.setOnClickListener {
            val intent = Intent(this@MainActivity, FieldActivity::class.java)
            intent.putExtra("id", schemas[binding.picker.value].id)
            startActivity(intent)
        }
    }
}