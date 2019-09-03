package com.camilo.vuelingo.listeners

import com.camilo.vuelingo.models.Flight

interface RecyclerFlightListener {
    fun onClick(flight: Flight, position: Int)
    fun onDelete(flight: Flight, position: Int)
}