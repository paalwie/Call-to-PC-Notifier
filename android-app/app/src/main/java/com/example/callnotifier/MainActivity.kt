package com.example.callnotifier

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ipInput = findViewById<EditText>(R.id.ipInput)
        val saveButton = findViewById<Button>(R.id.saveButton)

        val prefs = getSharedPreferences("Settings", Context.MODE_PRIVATE)

        val savedIp = prefs.getString("pc_ip", "")
        ipInput.setText(savedIp)

        saveButton.setOnClickListener {
            val enteredIp = ipInput.text.toString().trim()
            if (enteredIp.isNotEmpty()) {
                prefs.edit().putString("pc_ip", enteredIp).apply()
                Toast.makeText(this, "IP $enteredIp gespeichert!", Toast.LENGTH_SHORT).show()
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
}