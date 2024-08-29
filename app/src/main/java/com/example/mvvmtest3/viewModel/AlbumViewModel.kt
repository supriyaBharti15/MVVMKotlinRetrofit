package com.example.mvvmtest3.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmtest3.repository.AlbumRepository
import com.example.mvvmtest3.model.AlbumResponseItem
import kotlinx.coroutines.Job

/*
AlbumViewModel will communicate with AlbumRepository class so we need
AlbumRepository instance inside our AlbumViewModel class
 */
class AlbumViewModel(private val albumRepository: AlbumRepository) : ViewModel() {
    private lateinit var job: Job

    /*
    define a private val album of mutable type
    we should not expose MutableLiveData outside the class so we made it private
     */
    private val albumMutableData = MutableLiveData<List<AlbumResponseItem>>()
    val albumLiveData: LiveData<List<AlbumResponseItem>>
        /*
        now we define getter for the albumLiveData like below
         */
        get() = albumMutableData

    /*
    it : contain the list of movies
     */
     fun getAlbum() {
        job = Coroutines.ioThenMain(
            { albumRepository.getAlbum() },
            {
                albumMutableData.value = it

            }
        )
    }

override fun onCleared(){
    super.onCleared()
    if(::job.isInitialized) job.cancel()
}
}