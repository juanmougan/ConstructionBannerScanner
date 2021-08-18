package com.github.juanmougan.constructionbannerscanner

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.github.juanmougan.constructionbannerscanner.databinding.ActivityMainBinding
import io.github.g00fy2.quickie.QRResult
import io.github.g00fy2.quickie.ScanQRCode
import io.github.g00fy2.quickie.content.QRContent

class MainActivity : ComponentActivity() {

    val scanQrCode = registerForActivityResult(ScanQRCode(), ::handleResult)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.scanBtn.setOnClickListener { scanQrCode.launch(null) }
    }

    fun handleResult(result: QRResult) {
        Log.i("\n\n\n\n\nMY APP result", result.toString())
        val qrSuccess = result as QRResult.QRSuccess
        val qrUrl = qrSuccess.content as QRContent.Url
        Toast.makeText(this, "QR URL: ${qrUrl.url}", Toast.LENGTH_LONG).show()
    }
}
