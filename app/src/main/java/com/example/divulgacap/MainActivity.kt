package com.example.divulgacap

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.divulgacap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var Entrar: Button
    private lateinit var Buscar: Button
    private lateinit var Sobre: Button
    private lateinit var divulgaoseuaqui: Button
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

                Entrar = findViewById(R.id.button);
                Buscar = findViewById(R.id.button2)
                Sobre = findViewById(R.id.button4);
                divulgaoseuaqui = findViewById(R.id.button3);

        Entrar.setOnClickListener(View.OnClickListener {
            EntrarActivity()
        })
        Buscar.setOnClickListener(View.OnClickListener {
            BuscarActivity()
        })

        Sobre.setOnClickListener(View.OnClickListener {
            Snackbar.make(it, "ATENÇÃOOOO", Snackbar.LENGTH_LONG)
                    .setAction("Ok", null).show();

        })

        divulgaoseuaqui.setOnClickListener(View.OnClickListener {
            dispatchTakePictureIntent()
        })



    }

    private fun dispatchTakePictureIntent () {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { TakePictureIntent ->
            TakePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(TakePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val imageView: ImageView = findViewById(R.id.imageView)
            imageView.setImageBitmap(imageBitmap)

        }
    }
            fun EntrarActivity() {
                startActivity(Intent(this,tela1::class.java))
            }
            fun BuscarActivity() {
                startActivity(Intent(this,tela2::class.java));
            }




}