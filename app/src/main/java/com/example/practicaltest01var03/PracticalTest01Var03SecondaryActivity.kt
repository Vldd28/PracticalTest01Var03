package com.example.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03SecondaryActivity : AppCompatActivity() {
    private var resultText: TextView ?= null
    private var incorrectButton: Button? = null
    private var correctButton: Button? = null

    private val incorrectOnClickListener = View.OnClickListener {
        var finalText = ""
        startActivity(Intent(this, PracticalTest01Var03MainActivity::class.java).putExtra("result","incorrect"))
   }
    private val correctOnClickListener = View.OnClickListener {
        var finalText = ""
        startActivity(Intent(this, PracticalTest01Var03MainActivity::class.java).putExtra("result","incorrect"))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var03_secondary)
        resultText = findViewById(R.id.resultText)
        correctButton = findViewById(R.id.correctButton)
        incorrectButton = findViewById(R.id.incorrectButton)
        correctButton?.setOnClickListener(correctOnClickListener)
        incorrectButton?.setOnClickListener(incorrectOnClickListener)

        resultText?.text = intent.getStringExtra("result").toString()
        Log.d("vlad aici",intent.getStringExtra("result").toString())

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.resultText)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}