package com.example.appname

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appname.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    // 고정된 로그인 정보
    private val validUsername = "lime"
    private val validPassword = "2171183"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 뷰 바인딩 사용
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username == validUsername && password == validPassword) {
                val intent = Intent(this, StopwatchActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "ID 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}