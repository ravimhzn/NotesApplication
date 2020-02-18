package com.ravimhzn.mynotes.ui

import android.os.Bundle
import android.util.Log
import com.ravimhzn.mynotes.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    val TAG = MainActivity::class.java.name
    @Inject
    lateinit var tString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "*******$tString********")
    }
}
