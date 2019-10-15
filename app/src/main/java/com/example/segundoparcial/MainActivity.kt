package com.example.segundoparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_dialog.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            var userText = editUser.text.toString()
            var passwordText = editPassword.text.toString()
            if(userText=="segundoparcial"&&passwordText=="1"){
                val intent = Intent(this,Menu::class.java)
                startActivity(intent)
            }else{
                val myDialogView = layoutInflater.inflate(R.layout.login_dialog,null)
                val mBuilder = AlertDialog.Builder(this).setView(myDialogView).setTitle("Login").show()

                myDialogView.btnClose.setOnClickListener {
                    mBuilder.dismiss()
                }
            }
        }
    }
}
