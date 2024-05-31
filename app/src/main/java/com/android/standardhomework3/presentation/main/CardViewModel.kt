package com.android.standardhomework3.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.android.standardhomework3.data.database.DataSource
import com.android.standardhomework3.data.repository.SearchRepositoryImpl
import com.android.standardhomework3.network.RetrofitClient
import com.android.standardhomework3.presentation.model.MyCardModel
import com.android.standardhomework3.presentation.search.repository.SearchRepository

class MainViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    //liveData를 외부에서 수정할 수 없도록 하고, ViewModel을 통해서만 데이터를 업데이트 하고 observing 하도록 함
    //실제 데이터를 저장하고 있는 MutableLiveData
    //_getBlueCardModel을 private로 선언함으로써, ViewModel외부에서 이 데이터를 직접적으로 접근할 수 없음
    private val _getMyCardModel: MutableLiveData<List<MyCardModel>> = MutableLiveData()

    //_getBlueCardModel의 public getter()이며 외부에서 liveData를 읽을 수 있는 접근자
    val getMyCardModel: LiveData<List<MyCardModel>> get() = _getMyCardModel

    fun getMyCardModel() {
        _getMyCardModel.value = searchRepository.getCardList()
    }
}

class MainViewModelFactory : ViewModelProvider.Factory {
    private val repository = SearchRepositoryImpl(DataSource, RetrofitClient.searchGitHubUser)
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {

        return MainViewModel(
            repository
        ) as T
    }
}