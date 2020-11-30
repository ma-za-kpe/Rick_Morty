package com.maku.rickmorty.view.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.maku.rickmorty.R
import com.maku.rickmorty.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    //databinding
    private lateinit var mViewBinding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initialize the binding
        mViewBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_list
        )

        mViewBinding.lifecycleOwner = this

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.listFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

    }
}