package com.example.storeappagain.view.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.storeappagain.R
import com.example.storeappagain.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = FirebaseDatabase.getInstance()
        reference = database.reference
    }

    override fun onStart() {
        super.onStart()
        registrationUser()
        binding.imageViewBackToLogin.setOnClickListener {
            startActivity(Intent(
                this@RegistrationActivity,
                LoginActivity::class.java
            ))
            finish()
        }

    }
    private fun registrationUser() {
        val mAuth = FirebaseAuth.getInstance()
        with(binding) {
            buttonSignUp.setOnClickListener {
                val email = editTextEmailRegistration.text.toString()
                val password = editTextPasswordRegistration.text.toString()
                val confirmPassword = editTextConfirmPasswordRegistration.text.toString()

                if(email.isEmpty() || password.isEmpty() ||confirmPassword.isEmpty() ) {
                    Toast.makeText(this@RegistrationActivity,
                        "Please fill all the fields",Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                if(password == confirmPassword) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this@RegistrationActivity) { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this@RegistrationActivity,
                                    "Registration successful!",
                                    Toast.LENGTH_LONG
                                ).show()
                                startActivity(Intent(
                                    this@RegistrationActivity,
                                    LoginActivity::class.java
                                ))

                            } else {
                                Toast.makeText(
                                    this@RegistrationActivity,
                                    "Registration failed!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
    }
}