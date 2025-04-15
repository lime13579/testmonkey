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
//박준영 개병신 이새기는 왜 한음을 한거임 ㄹㅇ'
    // ✅ 고정된 로그인 정보
    private val validUsername = "admin"
    private val validPassword = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ✅ 뷰 바인딩 사용
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ✅ 로그인 버튼 클릭 이벤트
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username == validUsername && password == validPassword) {
                val intent = Intent(this, StopwatchActivity::class.java)
                startActivity(intent) // 오타 수정됨
                finish()
            } else {
                Toast.makeText(this, "ID 또는 비밀번호가 올바르지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}