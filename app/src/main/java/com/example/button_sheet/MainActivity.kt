package com.example.button_sheet

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var bottomsheet : BottomSheetBehavior<View>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        showCardPayment()
    }

    @SuppressLint("ResourceType")
    private fun setupUI(){

        var bottomsheet = findViewById<View>(R.id.bottom_sheet)
        var paymentBtn = findViewById<Button>(R.id.payment_btn)
        var sheetBehavior = BottomSheetBehavior.from(bottomsheet)

        paymentBtn.setOnClickListener{
            if(sheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED){
                sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }else{
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }

        }


    }

    private fun showCardPayment() {
        var cash_layout = findViewById<LinearLayout>(R.id.cash_layout)
        var card_layout = findViewById<LinearLayout>(R.id.card_layout)
        var card_checkbox = findViewById<CheckBox>(R.id.card_checkbox)
        var cash_checkbox = findViewById<CheckBox>(R.id.cash_checkbox)
        cash_layout.setOnClickListener {
            if (cash_checkbox.isChecked) {
                cash_checkbox.isChecked = false
            } else {
                cash_checkbox.isChecked = true
                card_checkbox.isChecked = false
            }
        }
        card_layout.setOnClickListener {
            if (card_checkbox.isChecked) {
                card_checkbox.isChecked = false
            } else {
                card_checkbox.isChecked = true
                cash_checkbox.isChecked = false
            }
        }
    }
}