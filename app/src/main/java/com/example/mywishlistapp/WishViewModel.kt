package com.example.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private  val wishRepository: WishRepository = Graph.wishRepository
) :ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString:String)
    {
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String)
    {
        wishDescriptionState = newString
    }


    lateinit var getAllWishes: Flow<List<Wish>> //여기서는 아직 empty 상태

    init{
        viewModelScope.launch{
            getAllWishes = wishRepository.getWishes()
            //repository로부터 항목 전체를 가져와 초기화를 진행한다.
        }
    }
    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            //IO thread에서 해당 비동기 작업을 실행하도록 최적화 시켜준다.
            wishRepository.addAWish(wish = wish)
        }
    }

    fun getAWishById(id:Long): Flow<Wish> {
        return wishRepository.getWishById(id)
    }
    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish = wish)
        }
    }
    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish = wish)
        }
    }



}