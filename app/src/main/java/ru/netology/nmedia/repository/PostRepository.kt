package ru.netology.nmedia.repository

import ru.netology.nmedia.dto.Post

interface PostRepository {
    fun getAll(callback: GetAllCallback)
    fun likeById(id: Long, callback: PostCallback)
    fun unlikeById(id: Long, callback: PostCallback)
    fun save(post: Post, callback: PostCallback)
    fun removeById(id: Long, callback: RemoveCallback)

    interface GetAllCallback {
        fun onSuccess(posts: List<Post>)
        fun onError(e: Exception)
    }

    interface PostCallback {
        fun onSuccess(post: Post)
        fun onError(e: Exception)
    }

    interface RemoveCallback {
        fun onSuccess()
        fun onError(e: Exception)
    }
}