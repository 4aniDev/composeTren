package ru.chani.composetren

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    private val _isFollowing = MutableLiveData<Boolean>()
    val isFollowing: LiveData<Boolean> = _isFollowing

    fun changeFollowingSate() {
        val wasFollowing = _isFollowing.value ?: DEFAULT_FOLLOWING_STATE
        _isFollowing.value = !wasFollowing
    }

    companion object {
        private const val DEFAULT_FOLLOWING_STATE = false
    }
}