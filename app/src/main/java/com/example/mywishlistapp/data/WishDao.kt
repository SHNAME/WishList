package com.example.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
abstract  class WishDao //추상 클래스로 작성하게 되면 함수의 선언만 해주면 됨
{
    //room DB에서 사용될 DATA 관련 함수를 정의한다.

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend   fun addAWish(wishEntity: Wish)
    //Insert 키워드를 사용함으로써 해당 함수가 DB에 데이터를 저장 하는 함수라는 것을 명시

    //wish-table에 있는 wish item을 load해서 전부 가져온다.
    @Query("Select * from 'wish-table'") //query는 DB에서 load해서 가져오고 싶은 데이터가 무엇인지 정의
    abstract  fun getAllWishes(): Flow<List<Wish>>

    @Update//table 안 Wish 항목을 업데이트 한다.
    abstract suspend  fun updateWish(wishEntity: Wish)

    @Delete //table 안 wish 항목을 하나 삭제한다.
    abstract suspend  fun deleteAWish(wishEntity: Wish)

    @Query("Select * from 'wish-table' where id = :id") //data filter 추가
    //해당 테이블에서 데이터를 하나만 load 해온다.
    abstract  fun getAWishesById(id: Long): Flow<Wish>
    //Flow가 코루틴과 비슷한 방식이기 때문에 suspend를 사용하지 않는다.



}