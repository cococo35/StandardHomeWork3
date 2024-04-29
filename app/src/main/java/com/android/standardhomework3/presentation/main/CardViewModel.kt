package com.android.standardhomework3.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.standardhomework3.data.database.DataSource
import com.android.standardhomework3.data.repository.SearchRepositoryImpl
import com.android.standardhomework3.presentation.model.MyCardModel
import com.android.standardhomework3.presentation.repository.SearchRepository
import java.lang.IllegalArgumentException

class CardViewModel(private val searchRepository: SearchRepository): ViewModel() {
    private val _getMyCardModel: MutableLiveData<List<MyCardModel>> = MutableLiveData()

    val getMyCardModel: LiveData<List<MyCardModel>> get() = _getMyCardModel

    fun getMyCardModel() {
        _getMyCardModel.value = searchRepository.getCardList()
    }
}

@Suppress("UNCHECKED_CAST")
class CardViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CardViewModel(SearchRepositoryImpl(DataSource)) as T
    }
}