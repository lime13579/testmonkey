package com.example.appname

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class StopwatchActivity : AppCompatActivity() {

    private var seconds = 0
    private var running = false
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch) // XML 연결
        Toast.makeText(this, "StopwatchActivity 실행!", Toast.LENGTH_SHORT).show()
        val tvTime = findViewById<TextView>(R.id.tvTime)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnLap = findViewById<Button>(R.id.btnLap)
        val lapContainer = findViewById<LinearLayout>(R.id.lapContainer)


        btnStart.setOnClickListener{
            running = true
            runTimer(tvTime)
        }

        btnPause.setOnClickListener {
            running = false
        }

        btnReset.setOnClickListener{
            running = false
            seconds = 0
            tvTime.text = "00:00"
        }
        btnStart.setOnClickListener {
            if (!running) {
                running = true
                runTimer(tvTime)
            }
        }
        btnLap.setOnClickListener {
            val lapTime = tvTime.text.toString()
            val lapTextView = TextView(this).apply {
                text = "기록: $lapTime"
                textSize = 18f
            }
            lapContainer.addView(lapTextView)
        }


    }

    private fun runTimer(tvTime: TextView) {
        handler.post(object : Runnable {
            override fun run() {
                val minutes = seconds / 60
                val secs = seconds % 60
                tvTime.text = String.format("%02d:%02d", minutes, secs)

                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }



}
