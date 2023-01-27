package dev.abdujabbor.codial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.abdujabbor.codial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}