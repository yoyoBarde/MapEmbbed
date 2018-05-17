package com.example.kent.hyperdeals

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



class RegistrationActivity : AppCompatActivity() {


    var mDatabaseReference: DatabaseReference? = null
    var mAuth: FirebaseAuth? = null
    var mDatabase: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrationactivity)


        val submit = findViewById<View>(R.id.btnsubmit) as Button

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Users")
        mAuth = FirebaseAuth.getInstance()


        submit.setOnClickListener {


                val tvLastName = findViewById<View>(R.id.lastname) as EditText
                val tvFirstName = findViewById<View>(R.id.firstname) as EditText
                val tvEmail = findViewById<View>(R.id.email) as EditText
                val tvPassword = findViewById<View>(R.id.password) as EditText
                val progressbar = findViewById<View>(R.id.progressbar) as ProgressBar


                var email = tvEmail.text.toString()
                var password = tvPassword.text.toString()
                var lastname = tvLastName.text.toString()
                var firstname = tvFirstName.text.toString()


                if (!email.isEmpty() && !password.isEmpty() && !lastname.isEmpty() && !firstname.isEmpty()) {
                        progressbar.visibility = View.VISIBLE

                    mAuth!!.createUserWithEmailAndPassword(email!!, password!!)
                            .addOnCompleteListener(this) {task ->
                        progressbar.visibility = View.INVISIBLE

                                if (task.isSuccessful)
                                {
                                   val userID = mAuth!!.currentUser!!.uid
                                    val currentUserDb = mDatabaseReference!!.child(userID)
                                    currentUserDb.child("firstName").setValue(firstname)
                                    currentUserDb.child("lastName").setValue(lastname)
                                    Toast.makeText(this, "Registered Success!", Toast.LENGTH_SHORT).show()

                                    val intent = Intent(this,LoginActivity::class.java)
                                    startActivity(intent)

                            } else {
                                    Toast.makeText(this,"Error!", Toast.LENGTH_SHORT).show()

                                }
                    }
            }
                else {
                    Toast.makeText(this, "Enter credentials!", Toast.LENGTH_SHORT).show()
                }
        }
    }
}