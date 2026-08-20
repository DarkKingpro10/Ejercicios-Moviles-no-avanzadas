package edu.ufg.mr100823.parcial1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ufg.mr100823.R
import java.util.Locale

class ContactoAdapter(
    private var listaOriginal: List<Contacto>,
    private val onDialClick: (String) -> Unit
) : RecyclerView.Adapter<ContactoAdapter.ViewHolder>() {

    private var listaFiltrada: List<Contacto> = listaOriginal

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivContacto: ImageView = view.findViewById(R.id.ivContacto)
        val tvNombre: TextView = view.findViewById(R.id.tvNombreContacto)
        val tvNumero: TextView = view.findViewById(R.id.tvNumeroContacto)
        val btnLlamar: ImageButton = view.findViewById(R.id.btnLlamarContacto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = listaFiltrada[position]
        holder.tvNombre.text = contacto.nombre
        holder.tvNumero.text = contacto.numero
        
        if (contacto.fotoUri != null) {
            holder.ivContacto.setImageURI(contacto.fotoUri)
            holder.ivContacto.setBackgroundColor(android.graphics.Color.TRANSPARENT)
            holder.ivContacto.setPadding(0, 0, 0, 0)
        } else {
            holder.ivContacto.setImageResource(R.drawable.ic_telefono)
            holder.ivContacto.setBackgroundColor(android.graphics.Color.LTGRAY)
            holder.ivContacto.setPadding(8, 8, 8, 8)
        }

        holder.btnLlamar.setOnClickListener {
            onDialClick(contacto.numero)
        }
    }

    override fun getItemCount() = listaFiltrada.size

    fun filter(query: String) {
        listaFiltrada = if (query.isEmpty()) {
            listaOriginal
        } else {
            val lowercaseQuery = query.lowercase(Locale.getDefault())
            listaOriginal.filter {
                it.nombre.lowercase(Locale.getDefault()).contains(lowercaseQuery) ||
                it.numero.contains(lowercaseQuery)
            }
        }
        notifyDataSetChanged()
    }
}
