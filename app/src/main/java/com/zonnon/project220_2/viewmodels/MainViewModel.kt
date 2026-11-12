package com.zonnon.project220_2.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zonnon.project220_2.domain.FilmItemModel
import com.zonnon.project220_2.repositories.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    fun loadUpcoming(): LiveData<MutableList<FilmItemModel>> {
        return repository.loadUpcoming()
    }


    fun loadItems(): LiveData<MutableList<FilmItemModel>> {
        return repository.loadItems()
    }
}