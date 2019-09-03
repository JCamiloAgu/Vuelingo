package com.camilo.vuelingo.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alejandrolora.seccion_07_drawer_recycler_card.inflate
import com.alejandrolora.seccion_07_drawer_recycler_card.loadByResource
import com.camilo.vuelingo.R
import com.camilo.vuelingo.listeners.RecyclerFlightListener
import com.camilo.vuelingo.models.Flight
import kotlinx.android.synthetic.main.recycler_flight.view.*

class FlightAdapter(private val flight: List<Flight>, private val listener: RecyclerFlightListener)
    :RecyclerView.Adapter<FlightAdapter.viewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolder(parent.inflate(R.layout.recycler_flight))

    override fun onBindViewHolder(holder: viewHolder, position: Int) = holder.bind(flight[position], listener)

    override fun getItemCount(): Int = flight.size

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(flight: Flight, listener: RecyclerFlightListener) = with(itemView)
        {
            textViewCityName.text = flight.city
            imageViewBg.loadByResource(flight.imgResource)

            setOnClickListener{ listener.onClick(flight, adapterPosition) }
            buttonDelete.setOnClickListener{ listener.onDelete(flight, adapterPosition) }
        }
    }
}