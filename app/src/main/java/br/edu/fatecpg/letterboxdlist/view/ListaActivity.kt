package br.edu.fatecpg.letterboxdlist.view

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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
        val emptyState = findViewById<LinearLayout>(R.id.empty_state)
        val tvContador = findViewById<TextView>(R.id.tv_contador)

        val titulos = dao.listarTitulo().toMutableList()

        val quantidade = titulos.size
        tvContador.text = if (quantidade == 1) "1 título" else "$quantidade títulos"

        if (titulos.isEmpty()) {
            recyclerView.visibility = View.GONE
            emptyState.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyState.visibility = View.GONE
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TituloAdapter(titulos)
    }
}