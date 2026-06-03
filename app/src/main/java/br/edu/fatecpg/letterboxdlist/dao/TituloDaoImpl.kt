package br.edu.fatecpg.letterboxdlist.dao
import br.edu.fatecpg.letterboxdlist.model.Titulo

class TituloDaoImpl : TituloDao {
    companion object {
        private val titulos: MutableList<Titulo> = mutableListOf()
    }

    override fun adicionarTitulo(titulo: Titulo) {
        titulos.add(titulo)
    }

    override fun listarTitulo(): List<Titulo> {
        return titulos.toList()
    }
}