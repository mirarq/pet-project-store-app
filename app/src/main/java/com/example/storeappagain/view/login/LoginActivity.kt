package com.example.storeappagain.view.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.storeappagain.R
import com.example.storeappagain.databinding.ActivityLoginBinding
import com.example.storeappagain.view.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
         auth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        binding.textViewSignUp.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    RegistrationActivity::class.java
                )
            )
        }
        with(binding) {
            buttonLogin.setOnClickListener {
                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()
                login(email, password)
            }
        }


    }
private fun login(email: String,password: String) {
    auth.signInWithEmailAndPassword(email,password)
        .addOnCompleteListener(this) { task ->
            if(task.isSuccessful) {
                Toast.makeText(this@LoginActivity,
                "Login is successful!",Toast.LENGTH_SHORT).show()
                startActivity(Intent(
                    this@LoginActivity,MainActivity::class.java
                ))
            } else {
                Toast.makeText(this@LoginActivity,
                "Login is failed!",Toast.LENGTH_SHORT).show()
            }
        }
}





}