package br.edu.fatecpg.letterboxdlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.letterboxdlist.R
import br.edu.fatecpg.letterboxdlist.model.Titulo

class TituloAdapter(private val titulos: MutableList<Titulo>) :
    RecyclerView.Adapter<TituloAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNome: TextView = itemView.findViewById(R.id.textView_nome)
        val textViewGenero: TextView = itemView.findViewById(R.id.textView_genero)
        val checkBoxAssistido: CheckBox = itemView.findViewById(R.id.checkBox_assistido)
        val ratingBarNota: RatingBar = itemView.findViewById(R.id.ratingBar_nota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_titulo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val titulo = titulos[position]

        holder.textViewNome.text = titulo.nome
        holder.textViewGenero.text = titulo.genero

        holder.checkBoxAssistido.setOnCheckedChangeListener(null)
        holder.checkBoxAssistido.isChecked = titulo.isAssistido

        if (titulo.isAssistido) {
            holder.ratingBarNota.visibility = View.VISIBLE
            holder.ratingBarNota.rating = titulo.nota.toFloat()
        } else {
            holder.ratingBarNota.visibility = View.GONE
        }

        holder.checkBoxAssistido.setOnCheckedChangeListener { _, isChecked ->
            titulos[position] = titulo.copy(isAssistido = isChecked)
            notifyItemChanged(position)
        }

        holder.ratingBarNota.setOnRatingBarChangeListener { _, rating, _ ->
            titulos[position] = titulos[position].copy(nota = rating.toDouble())
        }
    }

    override fun getItemCount(): Int {
        return titulos.size
    }
}