package com.promedia.mycheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.promedia.mycheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rb1.setOnClickListener {
            binding.tvRadioButton.text = "Opción 1"
        }

        binding.rb2.setOnClickListener {
            binding.tvRadioButton.text = "Opción 2"
        }

        binding.rb3.setOnClickListener {
            binding.tvRadioButton.text = "Opción 3"
        }

        binding.cb1.setOnClickListener {
            if (binding.cb1.isChecked) {
                binding.tvTexto.text = "Activado CheckBox1"
            } else {
                binding.tvTexto.text = "Desactivado CheckBox1"
            }
        }

        binding.cb2.setOnClickListener {
            if (binding.cb2.isChecked) {
                binding.tvTexto.text = "Activado CheckBox2"
            } else {
                binding.tvTexto.text = "Desactivado CheckBox2"
            }
        }

        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this, R.array.Opciones, android.R.layout.simple_spinner_item
        )
        binding.spinner.adapter = adaptador
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity, "Selección: ".plus(position.toString()), Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Sin elección", Toast.LENGTH_SHORT).show()
            }
        }
    }
}