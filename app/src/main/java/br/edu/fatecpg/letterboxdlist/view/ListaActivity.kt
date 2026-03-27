package br.edu.fatecpg.letterboxdlist.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.letterboxdlist.R
import br.edu.fatecpg.letterboxdlist.adapter.TituloAdapter
import br.edu.fatecpg.letterboxdlist.dao.TituloDaoImpl

class ListaActivity : AppCompatActivity() {

    private val dao = TituloDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_titulo_list)
        val titulos = dao.listarTitulo().toMutableList()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TituloAdapter(titulos)
    }
}