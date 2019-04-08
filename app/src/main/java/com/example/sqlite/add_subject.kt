package com.example.sqlite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class add_subject : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subject)



        val DB = SQL_Helper(applicationContext)
        val title_input = findViewById<EditText>(R.id.title_edit)
        val desc_input = findViewById<EditText>(R.id.desc_edit)
        val add_btn = findViewById<Button>(R.id.add_subject_btn)


        add_btn.setOnClickListener{
            val title_text = title_input.text.toString().trim()
            val desc_text = desc_input.text.toString().trim()

            DB.add_data(title_text, desc_text)
            Toast.makeText(this@add_subject, "This subject has been added", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@add_subject,MainActivity::class.java))


        }
    }
}
