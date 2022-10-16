package com.app.recyclerviewupdaterdemo.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.app.recyclerviewupdaterdemo.R
import com.app.recyclerviewupdaterdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        findNavController( R.id.homeFragmentContainer).let {
            binding.navBar.setupWithNavController(it)
        }
    }


}

/**
 * Arama barı içeren ülke kodu seçme ekranı yap.
 * BottomNavigationBar olsun solda kareli cardview içerisinde 2/3 Column içerisinde listelensin.
 * Sağda ise Düz LinearLayout içerisinde.
 */