package com.example.mvvmtest3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmtest3.repository.AlbumRepository
import com.example.mvvmtest3.databinding.FragmentAlbumBinding
import com.example.mvvmtest3.network.MyApi
import com.example.mvvmtest3.viewModel.AlbumViewModel
import com.example.mvvmtest3.viewModel.AlbumViewModelFactory

class AlbumFragment : Fragment() {
    private lateinit var factory: AlbumViewModelFactory
    private lateinit var viewModel: AlbumViewModel
    lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //initialization of variable factory
        val api = MyApi()
        val repository = AlbumRepository(api)
        factory = AlbumViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(AlbumViewModel::class.java)
        viewModel.getAlbum()
        viewModel.albumLiveData.observe(viewLifecycleOwner,
            Observer { albumLiveData ->
                binding.recyclerView.also {
                    albumLiveData[1].title="https://via.placeholder.com/150/771796"
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter = AlbumAdapter(albumLiveData)
                }
            })
    }

}