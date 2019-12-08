package com.android.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
 lateinit var BMIImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateButton : Button = findViewById(R.id.buttonCalculate)
        calculateButton.setOnClickListener{calculate()}
        val resetButton :Button = findViewById(R.id.buttonReset)
        resetButton.setOnClickListener{reset()}
        BMIImage = findViewById(R.id.imageViewProfile)
    }

    private fun reset() {
        val weightText : TextView = findViewById(R.id.editTextWeight)

        val heightText : TextView = findViewById(R.id.editTextHeight)
        weightText.text= null
        heightText.text = null
        BMIImage.setImageResource( R.drawable.empty)
        val BMIText : TextView = findViewById(R.id.textViewBMI)
        BMIText.text =getString(R.string.bmi)

    }

    private fun calculate() {
        val weightText : TextView = findViewById(R.id.editTextWeight)

        val heightText : TextView = findViewById(R.id.editTextHeight)
        val weight : Double = weightText.text.toString().toDouble()
        val height : Double = heightText.text.toString().toDouble()/100
        val BMIText : TextView = findViewById(R.id.textViewBMI)
        val heightSquare = height *height
        val bmi :Double = (weight/heightSquare)

        var drawableResource: Int
        if(bmi <18.5)
        {
            BMIText.text = getString(R.string. under)
            drawableResource =R.drawable.under
        }else if (bmi >25)
        {
            BMIText.text = getString( R.string.over)
             drawableResource =R.drawable.over
        }else
        {
            BMIText.text = getString( R.string.normal)
            drawableResource =R.drawable.normal
        }
        BMIImage.setImageResource(drawableResource)

    }
}
