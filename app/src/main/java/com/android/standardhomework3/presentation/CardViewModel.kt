package com.android.standardhomework3.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.standardhomework3.data.DataSource
import java.lang.IllegalArgumentException

class CardViewModel(val dataSource: DataSource): ViewModel() {
    val cardLiveData = dataSource.getCardList()

}

class CardViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CardViewModel::class.java)) {
            return CardViewModel(dataSource = DataSource.getDataSource()) as T
        }
        throw IllegalArgumentException("unknown")
    }
}