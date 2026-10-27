package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802016786

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() -> {
                    tvStatus.text = "Email cannot be empty!"
                }

                password.isEmpty() -> {
                    tvStatus.text = "Password cannot be empty!"
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.text = "Invalid email format!"
                }

                password.length < 6 -> {
                    tvStatus.text = "Password must be at least 6 characters!"
                }

                else -> {
                    tvStatus.text = "Validation Successful!"
                }
            }
        }
    }
}
