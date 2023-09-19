package com.example.imc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class TableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        val imgButton = findViewById<ImageButton>(R.id.imgBtn_voltar)

        imgButton.setOnClickListener(View.OnClickListener {
            finish()
        })


    }
}