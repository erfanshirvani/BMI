package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtHeight: EditText = findViewById(R.id.txt_height)
        val txtWeight: EditText = findViewById(R.id.txt_weight)
        val btnCal: Button = findViewById(R.id.btn_cal)
        val btnRes: Button = findViewById(R.id.btn_res)
        val tvResult: TextView = findViewById(R.id.tv_res)

        btnCal.setOnClickListener {

            if (txtWeight.text.isEmpty() or txtHeight.text.isEmpty()) {
                Toast.makeText(this, "weight or height is not found",Toast.LENGTH_LONG).show()

            } else {

                val weight: Double = txtWeight.text.toString().toDouble()
                val height: Double = txtHeight.text.toString().toDouble() / 100

                val bmi = weight / (height * height)
                // tvResult.text = bmi.toString()

                when (bmi) {
                    in 0.0..18.5 -> tvResult.text =
                        "Under Weight \n" + "BMI : " + bmi.toInt().toString()
                    in 18.6..25.0 -> tvResult.text =
                        "Normal Weight \n" + "BMI : " + bmi.toInt().toString()
                    in 25.1..35.0 -> tvResult.text =
                        "Over Weight \n" + "BMI : " + bmi.toInt().toString()
                    in 36.0..100.0 -> tvResult.text=
                        "very over weight \n" + "BMI : " + bmi.toInt().toString()
                    else -> tvResult.text = "Bece"

                }
            }
            btnRes.setOnClickListener {
                txtWeight.text.clear()
                txtHeight.text.clear()
                tvResult.text = ""
                txtWeight.requestFocus()
            }
        }
    }
}