package com.camilo.vuelingo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.camilo.vuelingo.R

class ArrivalsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle(R.string.arrivals_fragment_title)
        return inflater.inflate(R.layout.fragment_arrivals, container, false)
    }


}
