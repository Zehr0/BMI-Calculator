package com.zero.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculate: AppCompatButton = findViewById(R.id.btnCalculate)
        calculate.setOnClickListener { calcBMI() }
    }

    private fun calcBMI() {
        val weight: TextInputEditText = findViewById(R.id.etWeight)
        val height: TextInputEditText = findViewById(R.id.etHeight)

        val bmiValue: TextView = findViewById(R.id.tvBMIValue)
        val bmiResult: TextView = findViewById(R.id.tvBMIResult)
        // check for null values
        if (weight.text!!.trim().isEmpty() || height.text!!.trim().isEmpty() ){
            Toast.makeText(this, "One or more fields are empty.!", Toast.LENGTH_SHORT).show()
            return
        }
        // Formula for bmi = weight in kg / squared height in metres
        val bmiCalculated: Double = (weight.text.toString().toDouble()) / (height.text.toString().toDouble()*height.text.toString().toDouble())
        "${"%.1f".format(bmiCalculated)}kg/m2".also { bmiValue.text = it }
        //
        bmiResult.text = when {
            bmiCalculated < 18.5 -> "Oops!! You're Underweight"
            bmiCalculated in 18.5..24.9 -> "Wow.!! You're Healthy"
            bmiCalculated in 25.0..29.9 -> "Oops!! You're Overweight"
            bmiCalculated > 30 -> "Omo!! You're Obese"
            else -> "Check your values"
        }
    }

    // TODO: Complete the following tasks...
    // 1. Calculate the BMI and display it.
    //    The BMI should be displayed in the middle
    // 2. Using a new textView: Tell the user of the app
    //    if they are overweight, under weight etc...
}