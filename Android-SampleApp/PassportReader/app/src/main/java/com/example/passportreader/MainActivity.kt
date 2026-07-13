package com.example.passportreader

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pixl.pixlpassportreader.PassportResult
import com.pixl.pixlpassportreader.scanner.MRZScanActivity
import com.pixl.pixlpassportreader.scanner.PixlResultCallback

class MainActivity : AppCompatActivity(), PixlResultCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        findViewById<Button>(R.id.btnStartScan).setOnClickListener {
            startMRZScan(this, isNfc = false)
        }
    }

    private fun startMRZScan(context: Context, isNfc: Boolean = false) {
        val apiKey = "APIKEY" // Replace with your actual API key

        val intent = Intent(context, MRZScanActivity::class.java).apply {
            putExtra(MRZScanActivity.EXTRA_API_KEY, apiKey)
        }
        MRZScanActivity.scanResultCallback(this)
        MRZScanActivity.isNFCBased = isNfc  // change to true if you want to scan using NFC

        context.startActivity(intent)
    }

    override fun onScanDataSuccess(passportInfoJson: String) {
        Log.e("PassportResult", "onScanDataSuccess: $passportInfoJson")
    }

    override fun onNFCScanSuccess(
        passportInfoJson: String,
        bitmap: Bitmap
    ) {
        Log.e("PassportResult", "onNFCScanSuccess: $passportInfoJson")
    }

    override fun onScanError(errorCode: String, errorMessage: String) {
        Log.e("ScanError", "onScanError: $errorCode, $errorMessage")
    }
}