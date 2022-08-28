package com.example.challengechapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.challengechapter2.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var cost: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnCalculate: Button

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cost = findViewById(R.id.textInputEditText)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_calculate) {
            val inputCost = cost.text.toString().trim()
            var res = tvResult.text.toString().trim()

            var isEmptyFields = false

            if (inputCost.isEmpty()) {
                isEmptyFields = true
                cost.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields) {
                var result = inputCost.toDouble() + res.toDouble()
                tvResult.text = result.toString()

            }
        }
    }

    fun onSwitchClicked(view: View) {
        var res = tvResult.text.toString().trim()

        if (view is Switch){
            if (view.isChecked) {
                res = (res.toDouble() + 10).toString()
                tvResult.text = res
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val inputCost = cost.text.toString().trim()

            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioButton1 ->
                    if (checked) {
                        val res = inputCost.toDouble() * 20 / 100
                        tvResult.text = res.toString()
                    }
                R.id.radioButton2 ->
                    if (checked) {
                        val res = inputCost.toDouble() * 18 / 100
                        tvResult.text = res.toString()
                    }
                R.id.radioButton3 ->
                    if (checked) {
                        val res = inputCost.toDouble() * 15 / 100
                        tvResult.text = res.toString()
                    }
            }
        }
    }
}
