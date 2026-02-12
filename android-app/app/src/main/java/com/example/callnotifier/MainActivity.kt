package com.example.callnotifier

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    private lateinit var ipLabel: TextView
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ipLabel = findViewById(R.id.currentIpLabel)
        val ipInput = findViewById<EditText>(R.id.ipInput)
        val saveButton = findViewById<Button>(R.id.saveButton)

        prefs = getSharedPreferences("Settings", Context.MODE_PRIVATE)

        updateIpDisplay()

        saveButton.setOnClickListener {
            val newIp = ipInput.text.toString().trim()
            if (newIp.isNotEmpty()) {
                prefs.edit().putString("pc_ip", newIp).apply()

                updateIpDisplay()
                ipInput.text.clear()

                Toast.makeText(this, "Erfolgreich gespeichert!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bitte eine IP eingeben", Toast.LENGTH_SHORT).show()
            }
        }

        val permissions = arrayOf(
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_CALL_LOG
        )
        ActivityCompat.requestPermissions(this, permissions, 1)
    }

    private fun updateIpDisplay() {
        val savedIp = prefs.getString("pc_ip", "Nicht gesetzt")
        ipLabel.text = "Gespeicherte IP: $savedIp"
    }
}