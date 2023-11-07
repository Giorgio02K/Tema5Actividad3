package com.jordichorro.tema5actividad3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class TransferActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transfer_activity)

        val spinner1: Spinner = findViewById(R.id.spinerCuentas1)
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(this, R.array.listaCuentas1, android.R.layout.simple_spinner_item).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner1.adapter = adapter
        }

        val spinner2: Spinner = findViewById(R.id.spinerCuentas2)
        ArrayAdapter.createFromResource(this, R.array.listaCuentas1, android.R.layout.simple_spinner_item).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner2.adapter = adapter
        }

        val spinner3: Spinner = findViewById(R.id.spinerDinero1)
        ArrayAdapter.createFromResource(this, R.array.listaDinero1, android.R.layout.simple_spinner_item).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner3.adapter = adapter
        }

        val textView = findViewById<TextView>(R.id.simboloDinero)
        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val textoSeleccionado = spinner3.getSelectedItem().toString()
                textView.text = textoSeleccionado
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // No hacer nada
            }
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupCuentas)
        val editTextCuentaAjena = findViewById<EditText>(R.id.editTextCuentaAjena)
        var cuentaAjena = false
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rCuentaPropia -> {
                    // Se muestra el Spinner y se oculta el EditText
                    spinner2.visibility = View.VISIBLE
                    editTextCuentaAjena.visibility = View.GONE
                    cuentaAjena = false
                }
                R.id.rCuentaAjena -> {
                    // Se oculta el Spinner y se muestra el EditText
                    spinner2.visibility = View.GONE
                    editTextCuentaAjena.visibility = View.VISIBLE
                    cuentaAjena = true
                }
            }
        }

        val botonEnviarDatos : Button = findViewById(R.id.btnEnviarDatos)
        val txtIntroducirDinero: EditText = findViewById(R.id.txtIntroducirDinero)
        val justificante : CheckBox = findViewById(R.id.justifiante)

        botonEnviarDatos.setOnClickListener{
            val cuentaOrigen = spinner1.getSelectedItem().toString()
            val cuentaDestino = spinner2.getSelectedItem().toString()
            val moneda = spinner3.getSelectedItem().toString()
            val cantidad = txtIntroducirDinero.text.toString()
            val numeroCuentaAjena = editTextCuentaAjena.text.toString()
            var mensaje = ""
            if (cuentaAjena == false) {
                mensaje = "Cuenta origen: \t $cuentaOrigen \t A cuenta propia: \t $cuentaDestino \t Importe: $cantidad $moneda"
            }else{
                mensaje = "Cuenta origen: \t $cuentaOrigen \t A cuenta ajena: \t $numeroCuentaAjena \t Importe: $cantidad $moneda"
            }
            if (justificante.isChecked) {
                mensaje += "\n\nJustificante solicitado"
            } else {
                mensaje += "\n\nNo se solicita justificante"
            }

            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()

        }

    }

}