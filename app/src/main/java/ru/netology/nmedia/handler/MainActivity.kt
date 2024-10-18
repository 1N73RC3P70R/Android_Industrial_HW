package ru.netology.handler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import okhttp3.OkHttpClient
import ru.netology.nmedia.R
import java.io.InputStream
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val avatars = listOf("netology.jpg", "sber.jpg", "tcs.jpg", "404.png")
    private var currentAvatarIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .build()

        Glide.get(this).registry.replace(
            GlideUrl::class.java,
            InputStream::class.java,
            OkHttpUrlLoader.Factory(okHttpClient))

//        loadNextAvatar(binding)
//
//        binding.load.setOnClickListener {
//            loadNextAvatar(binding)
//        }
//    }
//
//    private fun loadNextAvatar(binding: ActivityMainBinding) {
//        val avatarName = avatars[currentAvatarIndex]
//        binding.image.loadAvatar(avatarName)
//
//        currentAvatarIndex = (currentAvatarIndex + 1) % avatars.size
    }
}
