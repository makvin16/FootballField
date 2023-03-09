package com.example.sportexfield

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sportexfield.databinding.ActivityFieldBinding

class FieldActivity : AppCompatActivity() {

    lateinit var binding: ActivityFieldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFieldBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.extras?.getInt("id") ?: return
        val schema = (application as App).schemas.find {
            it.id == id
        } ?: return
        binding.field.setScheme(schema)
        showToast(schema.title)
    }
}