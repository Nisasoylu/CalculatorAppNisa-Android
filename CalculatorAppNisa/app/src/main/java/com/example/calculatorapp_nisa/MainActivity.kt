package com.example.calculatorapp_nisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_ac.setOnClickListener { clickButton("") }
        button_zero.setOnClickListener { clickButton("0") }
        button_equal.setOnClickListener { clickButton("=") }
        button_plus.setOnClickListener { clickButton("+") }

        button_one.setOnClickListener { clickButton("1") }
        button_two.setOnClickListener { clickButton("2") }
        button_three.setOnClickListener { clickButton("3") }
        button_minus.setOnClickListener { clickButton("-") }

        button_four.setOnClickListener { clickButton("4") }
        button_five.setOnClickListener { clickButton("5") }
        button_six.setOnClickListener { clickButton("6") }
        button_mult.setOnClickListener { clickButton("*") }

        button_seven.setOnClickListener { clickButton("7") }
        button_eight.setOnClickListener { clickButton("8") }
        button_nine.setOnClickListener { clickButton("9") }
        button_div.setOnClickListener { clickButton("/") }

        button_equal.setOnClickListener {
            hesapla()
        }

        button_ac.setOnClickListener {
            click_ac_button()
        }

    }

    fun click_ac_button() {
        calculation_text.text = null
        result_text.text = null
    }

    fun clickButton(text: String) {
        if (calculation_text.text.equals("") && result_text.text.equals("")) {
            calculation_text.append(text)
        } else if (!calculation_text.text.equals("") && !result_text.text.equals("")) {
            if (text == "+" || text == "-" || text == "*" || text == "/") {
                calculation_text.text = null
                calculation_text.append(result_text.text)
                calculation_text.append(text)
                result_text.text = null
            } else {
                click_ac_button()
                calculation_text.append(text)
            }
        } else {
            calculation_text.append(result_text.text)
            calculation_text.append(text)
            result_text.text = ""
        }
    }

    fun hesapla() {
        try {
            val alinan_veri = ExpressionBuilder(calculation_text.text.toString()).build()
            val cikti = alinan_veri.evaluate()
            val sayi_cikti = cikti.toFloat()

            result_text.text = sayi_cikti.toString()
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }


    }

}