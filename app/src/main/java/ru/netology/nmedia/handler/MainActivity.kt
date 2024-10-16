package ru.netology.handler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.handler.load

class MainActivity : AppCompatActivity() {
    private val urls = listOf("netology.jpg", "sber.jpg", "tcs.jpg", "404.png")
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.load.setOnClickListener {
            if (index == urls.size) {
                index = 0
            }

            val url = "http://10.0.2.2:9999/avatars/${urls[index++]}"
            binding.image.load(url)
        }
    }
}