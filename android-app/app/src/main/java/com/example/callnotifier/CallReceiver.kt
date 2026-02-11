package com.example.callnotifier

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

class CallReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)

            if (state == TelephonyManager.EXTRA_STATE_RINGING) {
                val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER) ?: "Unbekannte Nummer"

                val prefs = context.getSharedPreferences("Settings", Context.MODE_PRIVATE)
                val ip = prefs.getString("pc_ip", "")

                if (!ip.isNullOrEmpty()) {
                    sendToPC(ip, incomingNumber)
                }
            }
        }
    }

    private fun sendToPC(ip: String, message: String) {
        val client = OkHttpClient()
        val body = message.toRequestBody("text/plain".toMediaType())
        val request = Request.Builder().url("http://$ip:5000/call").post(body).build()

        Thread {
            try {
                client.newCall(request).execute()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }
}