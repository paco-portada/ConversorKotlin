package com.example.conversornuevo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversornuevo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val RATIO = 0.9

    //private var binding: ActivityMainBinding? = null
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //activity_main.xml -> ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //botón convertir en activity_main.xml
        binding.convertir.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view === binding.convertir) {
            try {
                if (binding.eurosADolares.isChecked) {
                    binding.dolares.setText(
                        Conversion.convertirADolares(binding.euros.text.toString(), RATIO)
                    )
                } else {
                    binding.euros.setText(
                        Conversion.convertirAEuros(binding.dolares.text.toString(), RATIO)
                    )
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Error en la conversión: " + e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}