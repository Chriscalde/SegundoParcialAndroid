package com.example.segundoparcial

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_cars.*

class Cars : AppCompatActivity() {

    internal var qrScanIntegrator: IntentIntegrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars)

        val sharedPreferences = getSharedPreferences("MiniDB", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var data = sharedPreferences.getString("data","Not assigned")
        editData.setText(data)

        btnSaveData.setOnClickListener {
            editor.putString("data",editData.text.toString())
            editor.commit()
            Toast.makeText(this,"Data saved succesfully",Toast.LENGTH_LONG).show()
        }

    }
}
