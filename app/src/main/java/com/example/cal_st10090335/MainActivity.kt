package com.example.cal_st10090335

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private val ADDITION = '+'
    private val SUBTRACTION = '-'
    private val MULTIPLICATION = '*'
    private val DIVISION = '/'
    private val PERCENT = '%'

    private var currentSymbol: Char = ' '
    private var firstValue = Double.NaN
    private var secondValue: Double = 0.0
    private lateinit var inputDisplay: TextView
    private lateinit var outputDisplay: TextView
    private lateinit var decimalFormat: DecimalFormat
    private lateinit var button0: MaterialButton
    private lateinit var button1: MaterialButton
    private lateinit var button2: MaterialButton
    private lateinit var button3: MaterialButton
    private lateinit var button4: MaterialButton
    private lateinit var button5: MaterialButton
    private lateinit var button6: MaterialButton
    private lateinit var button7: MaterialButton
    private lateinit var button8: MaterialButton
    private lateinit var button9: MaterialButton
    private lateinit var buttonDot: MaterialButton
    private lateinit var buttonAdd: MaterialButton
    private lateinit var buttonSub: MaterialButton
    private lateinit var buttonMultiply: MaterialButton
    private lateinit var buttonDivide: MaterialButton
    private lateinit var buttonPercent: MaterialButton
    private lateinit var buttonClear: MaterialButton
    private lateinit var buttonOFF: MaterialButton
    private lateinit var buttonEqual: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            decimalFormat = DecimalFormat("#.##########")

            inputDisplay = findViewById(R.id.input)
            outputDisplay = findViewById(R.id.output)

            button0 = findViewById(R.id.btn0)
            button1 = findViewById(R.id.btn1)
            button2 = findViewById(R.id.btn2)
            button3 = findViewById(R.id.btn3)
            button4 = findViewById(R.id.btn4)
            button5 = findViewById(R.id.btn5)
            button6 = findViewById(R.id.btn6)
            button7 = findViewById(R.id.btn7)
            button8 = findViewById(R.id.btn8)
            button9 = findViewById(R.id.btn9)

            buttonAdd = findViewById(R.id.add)
            buttonSub = findViewById(R.id.subtract)
            buttonMultiply = findViewById(R.id.multiply)
            buttonDivide = findViewById(R.id.division)
            buttonDot = findViewById(R.id.btnPoint)
            buttonClear = findViewById(R.id.clear)
            buttonOFF = findViewById(R.id.off)
            buttonEqual = findViewById(R.id.equal)
            buttonPercent = findViewById(R.id.percent)

            button0.setOnClickListener {
                inputDisplay.text = inputDisplay.text.toString() + "0"
            }

            button1.setOnClickListener {
                inputDisplay.text = inputDisplay.text.toString() + "1"
            }

            button2.setOnClickListener {
                inputDisplay.text = inputDisplay.text.toString() + "2"
            }

            button3.setOnClickListener {
                inputDisplay.text = inputDisplay.text.toString() + "3"
            }

            button4.setOnClickListener {
                inputDisplay.text = inputDisplay.text.toString() + "4"
            }

            button5.setOnClickListener {
                inputDisplay.text = inputDisplay.text.toString() + "5"
            }

            button6.setOnClickListener {
                inputDisplay.text = inputDisplay.text.toString() + "6"
            }

            button7.setOnClickListener {
                inputDisplay.text = inputDisplay.text.toString() + "7"
            }

        button8.setOnClickListener {
            inputDisplay.text = inputDisplay.text.toString() + "8"
        }
        button9.setOnClickListener {
            inputDisplay.text = inputDisplay.text.toString() + "9"
        }
        buttonAdd.setOnClickListener {
            allCalculations()
            currentSymbol = ADDITION
            outputDisplay.text = decimalFormat.format(firstValue) + "+"
            inputDisplay.text = null
        }
        buttonSub.setOnClickListener {
            allCalculations()
            currentSymbol = SUBTRACTION
            outputDisplay.text = decimalFormat.format(firstValue) + "-"
            inputDisplay.text = null
        }
        buttonMultiply.setOnClickListener {
            allCalculations()
            currentSymbol = MULTIPLICATION
            outputDisplay.text = decimalFormat.format(firstValue) + "x"
            inputDisplay.text = null
        }
        buttonDivide.setOnClickListener {
            allCalculations()
            currentSymbol = DIVISION
            outputDisplay.text = decimalFormat.format(firstValue) + "/"
            inputDisplay.text = null
        }
        buttonPercent.setOnClickListener {
            allCalculations()
            currentSymbol = PERCENT
            outputDisplay.text = decimalFormat.format(firstValue) + "%"
            inputDisplay.text = null
        }
        buttonDot.setOnClickListener {
            inputDisplay.text = inputDisplay.text.toString() + "."
        }
        buttonClear.setOnClickListener {
            if (inputDisplay.text.length > 0) {
                val currentText: CharSequence = inputDisplay.text
                inputDisplay.text = currentText.subSequence(0, currentText.length - 1)
            } else {
                firstValue = Double.NaN
                secondValue = Double.NaN
                inputDisplay.text = ""
                outputDisplay.text = ""
            }
        }
        buttonOFF.setOnClickListener {
            finish()
        }
        buttonEqual.setOnClickListener {
            allCalculations()
            outputDisplay.text = decimalFormat.format(firstValue)
            firstValue = Double.NaN
            currentSymbol = '0'
        }
    }


    private fun allCalculations() {
        if (!firstValue.isNaN()) {
            secondValue = inputDisplay.text.toString().toDouble()
            inputDisplay.text = null
            when (currentSymbol) {
                ADDITION -> firstValue += secondValue
                SUBTRACTION -> firstValue -= secondValue
                MULTIPLICATION -> firstValue *= secondValue
                DIVISION -> firstValue /= secondValue
                PERCENT -> firstValue %= secondValue
            }
        } else {
            try {
                firstValue = inputDisplay.text.toString().toDouble()
            } catch (e: Exception) {
            }
        }
    }
}





