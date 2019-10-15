package com.example.segundoparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.about_dialog.view.*
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.login_dialog.view.*
import kotlinx.android.synthetic.main.sign_out_dialog.view.*

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnCarScan.setOnClickListener {
            val intent = Intent(this,CarScan::class.java)
            startActivity(intent)
        }
        btnCars.setOnClickListener {
            val intent = Intent(this,Cars::class.java)
            startActivity(intent)
        }
        btnAbout.setOnClickListener {
            val myDialogView = layoutInflater.inflate(R.layout.about_dialog,null)
            val mBuilder = AlertDialog.Builder(this).setView(myDialogView).setTitle("About").show()

            myDialogView.btnDismiss.setOnClickListener {
                mBuilder.dismiss()
            }
            myDialogView.btnGit.setOnClickListener {
                mBuilder.dismiss()
                val intent = Intent(this@Menu,Git::class.java)
                startActivity(intent)
            }
        }
        btnSignOut.setOnClickListener {
            val myDialogView = layoutInflater.inflate(R.layout.sign_out_dialog,null)
            val mBuilder = AlertDialog.Builder(this).setView(myDialogView).setTitle("Sign Out").show()

            myDialogView.btnSignOut.setOnClickListener {
                mBuilder.dismiss()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}
