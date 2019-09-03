package com.camilo.vuelingo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrolora.seccion_07_drawer_recycler_card.toast
import com.camilo.vuelingo.R
import com.camilo.vuelingo.adapters.FlightAdapter
import com.camilo.vuelingo.listeners.RecyclerFlightListener
import com.camilo.vuelingo.models.Flight
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_departures.view.*

class DeparturesFragment : Fragment() {

    private val list: ArrayList<Flight> by lazy { getFlights() }

    private lateinit var recycler : RecyclerView

    private lateinit var adapter : FlightAdapter

    private val layoutManager by lazy { LinearLayoutManager(context) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View?
    {
        activity?.setTitle(R.string.departures_fragment_title)
        val rootView = inflater.inflate(R.layout.fragment_departures, container, false)

        recycler = rootView.recyclerView as RecyclerView
        setRecyclerView()

        return rootView
    }

    private fun setRecyclerView()
    {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager

        adapter = (FlightAdapter(list, object : RecyclerFlightListener
        {
            override fun onClick(flight: Flight, position: Int) {
                activity?.toast("Let's go to ${flight.city}")
            }

            override fun onDelete(flight: Flight, position: Int) {
                list.remove(flight)
                adapter.notifyItemRemoved(position)
                activity?.toast("${flight.city} has been delete")
            }
        }))
        recycler.adapter = adapter
    }

    private fun getFlights() : ArrayList<Flight>
    {
        return object : ArrayList<Flight>()
        {
            init {
                add(Flight(1, "Seattle", R.drawable.seattle))
                add(Flight(2, "Caribbean Sea", R.drawable.caribean_sea))
                add(Flight(3, "New York", R.drawable.new_york))
                add(Flight(4, "London", R.drawable.london))
                add(Flight(5, "Seville", R.drawable.seville))
                add(Flight(6, "Venice", R.drawable.venice))
                add(Flight(7, "Athens", R.drawable.athens))
                add(Flight(8, "Toronto", R.drawable.toronto))
                add(Flight(9, "Dublin", R.drawable.dublin))
            }
        }
    }

}
