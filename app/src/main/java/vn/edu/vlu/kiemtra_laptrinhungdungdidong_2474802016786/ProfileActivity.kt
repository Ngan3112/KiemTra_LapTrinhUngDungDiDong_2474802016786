package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802016786
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Anh xa giao dien bang findViewById
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val listView = findViewById<ListView>(R.id.listViewSubjects)

        // Nhan Email tu LoginActivity
        val email = intent.getStringExtra("USER_EMAIL") ?: ""
        tvEmail.text = "Email: $email"

        // Danh sach 5 mon hoc
        val subjects = arrayOf(
            "Kotlin Programming",
            "XML Layout Design",
            "Git/GitHub Management",
            "Intent Processing",
            "Android Architecture"
        )

        // Tao ArrayAdapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            subjects
        )

        // Hien thi danh sach
        listView.adapter = adapter

        // Xu ly khi nhan vao mon hoc
        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                "Selected: ${subjects[position]}",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Xu ly dang xuat
        btnLogout.setOnClickListener {
            finish()
        }
    }
}
