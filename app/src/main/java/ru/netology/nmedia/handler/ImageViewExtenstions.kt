package ru.netology.nmedia.handler

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import ru.netology.nmedia.R

fun ImageView.loadAvatar(url: String) {
    Glide.with(this)
        .load("http://10.0.2.2:9999/avatars/$url")
        .placeholder(R.drawable.ic_loading_100dp)
        .error(R.drawable.ic_error_100dp)
        .transform(CircleCrop())
        .timeout(5000)
        .into(this)
}
