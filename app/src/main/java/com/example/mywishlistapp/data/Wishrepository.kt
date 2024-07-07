package com.example.mywishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {

    suspend fun addAWish(wish:Wish){
        wishDao.addAWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()
    fun getWishById(id:Long): Flow<Wish> = wishDao.getAWishesById(id)

    suspend fun updateAWish(wish: Wish){
        wishDao.updateWish(wish)
    }
    suspend fun deleteAWish(wish:Wish){
        wishDao.deleteAWish(wish)
    }

}