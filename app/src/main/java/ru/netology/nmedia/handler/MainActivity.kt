package ru.netology.handler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.handler.loadAvatar

class MainActivity : AppCompatActivity() {
    private val avatars = listOf("netology.jpg", "sber.jpg", "tcs.jpg", "404.png")
    private var currentAvatarIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadNextAvatar(binding)

        binding.load.setOnClickListener {
            loadNextAvatar(binding)
        }
    }

    private fun loadNextAvatar(binding: ActivityMainBinding) {
        val avatarName = avatars[currentAvatarIndex]
        binding.image.loadAvatar(avatarName)

        currentAvatarIndex = (currentAvatarIndex + 1) % avatars.size
    }
}
