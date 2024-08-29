package com.example.mvvmtest3.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest3.repository.AlbumRepository

/*
when we wants to pass parameters to our viewModel we need to create factory class
the factory class will be responsible to create instance of ViewModel
 */
@Suppress("UNCHECKED_CAST")
class AlbumViewModelFactory(private val albumRepository: AlbumRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlbumViewModel(albumRepository) as T
    }
}

