package com.example.practicaltest01var03

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03MainActivity : AppCompatActivity() {
    private var plusButton: Button?= null
    private var minusButton: Button?= null

    private var resultText: TextView?= null

    private var editableText1: EditText ?= null
    private var editableText2: EditText ?= null


    private inner class minusButtonOnClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            var finalText = ""
            try {
                var finalResult = editableText1?.text.toString().toInt() - editableText2?.text.toString().toInt()
                finalText = finalText.plus(editableText1?.text.toString().plus(" - ").plus(editableText2?.text.toString()).plus(" = ").plus(finalResult.toString()))
                resultText?.text = finalText
                Log.d("vlad",finalText)
            }
            catch (ex: Exception) {
                Log.d("vlad","nu se poate")
            }
        }
    }
    private inner class plusButtonOnClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            var finalText = ""
            try {
                var finalResult = editableText1?.text.toString().toInt() + editableText2?.text.toString().toInt()
                finalText = finalText.plus(editableText1?.text.toString().plus(" + ").plus(editableText2?.text.toString()).plus(" = ").plus(finalResult.toString()))
                resultText?.text = finalText
                Log.d("vlad",finalText)
            }
            catch (ex: Exception) {
                Log.d("vlad","nu se poate")
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var03_main)
        plusButton = findViewById(R.id.buttonPlus)
        minusButton = findViewById(R.id.buttonMinus)
        resultText = findViewById(R.id.resultText)
        editableText1 = findViewById(R.id.editableText1)
        editableText2 = findViewById(R.id.editableText2)
        plusButton?.setOnClickListener(plusButtonOnClickListener())
        minusButton?.setOnClickListener(minusButtonOnClickListener())
        if (savedInstanceState != null) {
            editableText1?.setText(savedInstanceState.getString("editText1"))
            editableText2?.setText(savedInstanceState.getString("editText2"))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("ediText1",editableText1?.text.toString())
        outState.putString("ediText2",editableText2?.text.toString())
    }
}