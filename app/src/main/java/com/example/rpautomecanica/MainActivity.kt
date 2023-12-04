package com.example.rpautomecanica

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.rpautomecanica.databinding.ActivityMainBinding
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.StrictMode
import android.provider.MediaStore
import android.widget.Button
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.VmPolicy.Builder().build().also {
            StrictMode.setVmPolicy(it)
        }


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.totalButton.setOnClickListener(this)

        val btnShare: Button = findViewById(R.id.botaoprint)
        btnShare.setOnClickListener {
            compartilharTela()
        }

    }

    private fun compartilharTela() {
        // Obtenha uma captura de tela
        val rootView: View = window.decorView.rootView
        rootView.isDrawingCacheEnabled = true

        val screenshot: Bitmap = Bitmap.createBitmap(rootView.drawingCache)
        rootView.isDrawingCacheEnabled = false

        // Salve a captura de tela em algum lugar temporário
        // (você também pode salvar em cache ou armazenamento externo)
        val screenshotFile = File(externalCacheDir, "screenshot.png")

        try {
            val fileOutputStream = FileOutputStream(screenshotFile)
            screenshot.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
            fileOutputStream.flush()
            fileOutputStream.close()

            // Crie uma intenção de compartilhamento
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "image/png" // ou "text/plain" para compartilhar texto

            // Adicione a captura de tela à intenção
            val screenshotUri = Uri.fromFile(screenshotFile)
            shareIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri)

            // Inicie a atividade de compartilhamento
            startActivity(Intent.createChooser(shareIntent, "Compartilhar via"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }



    override fun onClick(view: View?) {
        if (view != null) {
            if (view.id == R.id.total_button) {
                calculate()
            }
        }
    }

    private fun calculate() {


        var value1 = 0f
        if (binding.editValor1.text.toString() != "" &&
            binding.editValor1.text.toString() != "."
        ) {
            value1 = binding.editValor1.text.toString().toFloat()
        }
        var value2 = 0f
        if (binding.editValor2.text.toString() != "" &&
            binding.editValor2.text.toString() != "."
        ) {
            value2 = binding.editValor2.text.toString().toFloat()
        }
        var value3 = 0f
        if (binding.editValor3.text.toString() != "" &&
            binding.editValor3.text.toString() != "."
        ) {
            value3 = binding.editValor3.text.toString().toFloat()
        }
        var value4 = 0f
        if (binding.editValor4.text.toString() != "" &&
            binding.editValor4.text.toString() != "."
        ) {
            value4 = binding.editValor4.text.toString().toFloat()
        }
        var value5 = 0f
        if (binding.editValor5.text.toString() != "" &&
            binding.editValor5.text.toString() != "."
        ) {
            value5 = binding.editValor5.text.toString().toFloat()
        }
        var value6 = 0f
        if (binding.editValor6.text.toString() != "" &&
            binding.editValor6.text.toString() != "."
        ) {
            value6 = binding.editValor6.text.toString().toFloat()
        }
        var value7 = 0f
        if (binding.editValor7.text.toString() != "" &&
            binding.editValor7.text.toString() != "."
        ) {
            value7 = binding.editValor7.text.toString().toFloat()
        }
        var value8 = 0f
        if (binding.editValor8.text.toString() != "" &&
            binding.editValor8.text.toString() != "."
        ) {
            value8 = binding.editValor8.text.toString().toFloat()
        }
        var value9 = 0f
        if (binding.editValor9.text.toString() != "" &&
            binding.editValor9.text.toString() != "."
        ) {
            value9 = binding.editValor9.text.toString().toFloat()
        }
        var value10 = 0f
        if (binding.editValor10.text.toString() != "" &&
            binding.editValor10.text.toString() != "."
        ) {
            value10 = binding.editValor10.text.toString().toFloat()
        }

        val totalValue =
            (value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9 + value10)

        binding.editValorTotal.text = "R$${"%.2f".format(totalValue)}"










    }
}