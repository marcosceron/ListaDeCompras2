package com.example.listadecompras

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.listadecompras.data.ItemsDatabase
import com.example.listadecompras.data.toModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(
    private val database: ItemsDatabase
) : ViewModel() {


    val itemsLiveData = MutableLiveData<List<ItemModel>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            fetchAll()
        }
    }


    fun addItem(name: String) {

    }

    private fun removeItem(item: ItemModel) {

    }

    private suspend fun fetchAll() {
        val result = database.itemsDao().getAll().map {
            it.toModel(onRemove = ::removeItem)
        }
        itemsLiveData.postValue(result)
    }
}