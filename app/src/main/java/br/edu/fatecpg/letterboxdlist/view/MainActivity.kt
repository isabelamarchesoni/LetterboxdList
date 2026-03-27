package br.edu.fatecpg.letterboxdlist.view

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.letterboxdlist.R
import br.edu.fatecpg.letterboxdlist.dao.TituloDaoImpl
import br.edu.fatecpg.letterboxdlist.model.Titulo

class MainActivity : AppCompatActivity() {

    private val dao = TituloDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNome = findViewById<EditText>(R.id.edt_nome)
        val spinnerGenero = findViewById<Spinner>(R.id.spinner_genero)
        val buttonAdicionar = findViewById<Button>(R.id.btn_registrar)
        val buttonVerLista = findViewById<Button>(R.id.btn_lista)

        val generos = resources.getStringArray(R.array.generos)

        val adapterSpinner = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            generos
        )

        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGenero.adapter = adapterSpinner

        buttonAdicionar.setOnClickListener {
            val nome = editTextNome.text.toString()
            val genero = spinnerGenero.selectedItem.toString()

            if (nome.isNotEmpty()) {
                val titulo = Titulo(
                    nome = nome,
                    genero = genero
                )

                dao.adicionarTitulo(titulo)
                editTextNome.text.clear()
            }
        }

        buttonVerLista.setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
    }
}