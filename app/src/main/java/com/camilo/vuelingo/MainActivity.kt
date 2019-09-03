package com.camilo.vuelingo

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.alejandrolora.mylibrary.ToolbarActivity
import com.alejandrolora.seccion_07_drawer_recycler_card.toast
import com.camilo.vuelingo.fragments.ArrivalsFragment
import com.camilo.vuelingo.fragments.DeparturesFragment
import com.camilo.vuelingo.fragments.HomeFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity(),NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarToLoad(toolbar as Toolbar)

        setNavDrawer()
        setUserHeaderInformation()

        if (savedInstanceState == null)
            fragmentTransaction(HomeFragment())
            navView.menu.getItem(0).isChecked = true
    }

    private fun setNavDrawer()
    {
        val toggle = ActionBarDrawerToggle(this, drawerLayout, _toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    private fun fragmentTransaction(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun loadFragmentById(id: Int)
    {
        when (id)
        {
            R.id.nav_home -> fragmentTransaction(HomeFragment())
            R.id.nav_departures -> fragmentTransaction(DeparturesFragment())
            R.id.nav_arrivals -> fragmentTransaction(ArrivalsFragment())
        }
    }

    private fun showMessageNavItemSelected(id: Int)
    {
        when (id)
        {
            R.id.nav_profile -> toast("Profile")
            R.id.nav_settings -> toast("Settings")

        }
    }

    private fun setUserHeaderInformation()
    {
        val name = navView.getHeaderView(0).findViewById<TextView>(R.id.txtName)
        val email = navView.getHeaderView(0).findViewById<TextView>(R.id.txtEmail)

        val user = User()

        name?.let { name.text = user.getName()}
        email?.let { email.text = user.getEmail() }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        showMessageNavItemSelected(item.itemId)
        loadFragmentById(item.itemId)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }
}
