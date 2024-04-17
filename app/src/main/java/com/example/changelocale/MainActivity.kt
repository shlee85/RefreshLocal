package com.example.changelocale

import android.content.Context
import android.content.res.Configuration
import com.example.changelocale.R
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.changelocale.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.kor.setOnClickListener {
            Log.i(TAG, "Korea")
            updateView("ko")
        }

        binding.eng.setOnClickListener {
            Log.i(TAG, "English")
            updateView("en")
        }

    }

    private fun updateView(language: String) {
        val ctx: Context = LocaleHelper.setLocale(this, language)
        val resources = ctx.resources

        binding.centerText.text = resources.getString(R.string.hello)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        Log.i(TAG, "attachBaseContext")
    }
}

