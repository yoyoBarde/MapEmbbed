package com.example.kent.hyperdeals

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.kent.hyperdeals.NavigationBar.Main3Activity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {


    private val TAG = "LoginActivity"
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginactivity)



        val login = findViewById<View>(R.id.loginButton)

        login.setOnClickListener{

            val loginEmail = findViewById<View>(R.id.loginEmail) as EditText
            val loginPassword = findViewById<View>(R.id.loginPassword) as EditText
            val loginButton = findViewById<View>(R.id.loginButton) as Button
            val loginForgotPassword = findViewById<View>(R.id.loginForgotPassword) as TextView
            val loginProgressBar = findViewById<View>(R.id.loginProgressBar) as ProgressBar

            var LoginEmail = loginEmail.text.toString()
            var LoginPassword = loginPassword.text.toString()

            mAuth = FirebaseAuth.getInstance()

            if (!LoginEmail.isEmpty() && !LoginPassword.isEmpty()) {
                        loginProgressBar.visibility = View.VISIBLE

                mAuth!!.signInWithEmailAndPassword(LoginEmail, LoginPassword)
                        .addOnCompleteListener(this) { task ->  
                            loginProgressBar.visibility = View.INVISIBLE

                            if (task.isSuccessful){
                                Toast.makeText(this,"Login Successful!", Toast.LENGTH_SHORT).show()

                                val intent = Intent(this, Main3Activity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this,"Login Failure", Toast.LENGTH_SHORT).show()

                            }

                        }
            }

            else {
                Toast.makeText(this,"Enter necessary credentials", Toast.LENGTH_SHORT).show()

            }
        }

    }
}
