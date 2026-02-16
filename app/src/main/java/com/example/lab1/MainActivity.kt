package com.example.lab1

import android.graphics.Typeface
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rgFont = findViewById<RadioGroup>(R.id.rgFont)
        val etInput = findViewById<EditText>(R.id.etInput)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnOk = findViewById<Button>(R.id.btnOk)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        btnOk.setOnClickListener {
            val text = etInput.text.toString()
            val selectedId = rgFont.checkedRadioButtonId

            if (text.isBlank() || selectedId == -1) {
                Toast.makeText(this, "Завершіть введення всіх даних", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val typeface = when (selectedId) {
                R.id.rbSans -> Typeface.SANS_SERIF
                R.id.rbSerif -> Typeface.SERIF
                R.id.rbMono -> Typeface.MONOSPACE
                else -> Typeface.DEFAULT
            }

            tvResult.typeface = typeface
            tvResult.text = text
        }

        btnCancel.setOnClickListener {
            etInput.text.clear()
            tvResult.text = ""
            rgFont.clearCheck()
        }
    }
}
