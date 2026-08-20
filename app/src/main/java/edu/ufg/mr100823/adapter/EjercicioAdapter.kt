package edu.ufg.mr100823.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ufg.mr100823.R
import edu.ufg.mr100823.model.Ejercicio
import java.util.Locale

class EjercicioAdapter(private var listaOriginal: List<Ejercicio>) :
    RecyclerView.Adapter<EjercicioAdapter.ViewHolder>() {

    private var listaFiltrada: List<Ejercicio> = listaOriginal

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitulo: TextView = view.findViewById(R.id.tvTitulo)
        val tvDescripcion: TextView = view.findViewById(R.id.tvDescripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ejercicio, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listaFiltrada[position]
        holder.tvTitulo.text = item.titulo
        holder.tvDescripcion.text = item.descripcion
        holder.itemView.setOnClickListener {
            item.launch(it.context)
        }
    }

    override fun getItemCount() = listaFiltrada.size

    fun filter(query: String) {
        listaFiltrada = if (query.isEmpty()) {
            listaOriginal
        } else {
            listaOriginal.filter {
                it.titulo.lowercase(Locale.getDefault()).contains(query.lowercase(Locale.getDefault())) ||
                it.descripcion.lowercase(Locale.getDefault()).contains(query.lowercase(Locale.getDefault()))
            }
        }
        notifyDataSetChanged()
    }
}