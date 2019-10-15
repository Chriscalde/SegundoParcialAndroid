package com.example.segundoparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_car_scan.*
import org.json.JSONException
import org.json.JSONObject

class CarScan : AppCompatActivity() {

    internal var qrScanIntegrator: IntentIntegrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_scan)

        btnClose.setOnClickListener {
            val intent = Intent(this,Menu::class.java)
            startActivity(intent)
        }

        btnScan!!.setOnClickListener { performAction() }

        qrScanIntegrator = IntentIntegrator(this)

    }
    private fun performAction() {
        qrScanIntegrator?.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            // If QRCode has no data.
            if (result.contents == null) {
                Toast.makeText(this, "Not Found", Toast.LENGTH_LONG).show()
            } else {
                // If QRCode contains data.
                try {
                    // Converting the data to json format
                    val obj = JSONObject(result.contents)

                    // Show values in UI.
                    txtBrand.setText(obj.getString("brand"))
                    txtModel.setText ( obj.getString("model"))
                    txtYear.setText ( obj.getString("year"))
                    txtDebt.setText ( obj.getString("debt"))
//                    imgUser?.src = obj.getString("imgDir")
                    Picasso.get().load(obj.getString("imgDir")).into(imgCar)
                    Log.d("Chris",obj.getString(result.contents))



                } catch (e: JSONException) {
                    e.printStackTrace()

                    // Data not in the expected format. So, whole object as toast message.

                    Log.d("Chris",e.toString())
                    Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }


    }
}
