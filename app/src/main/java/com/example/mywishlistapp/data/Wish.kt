package com.example.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wish-table")
//데이터 베이스에 wish-table이란 표를 하나 만듬
data class Wish(
    @PrimaryKey(autoGenerate = true)
    //primary key id 로 설정하는데 새로 생길 떄 마다 자동으로 id가 증가한다.
    val id: Long = 0L,//id로 room에서 data를 찾아와야하기 때문에 유일성 조건을 만족해야한다.
    @ColumnInfo(name = "wish-title") //열의 제목을 지정한다.
    val title: String = "",
    @ColumnInfo(name = "wish-desc")
    val description: String = ""
)


object  DummyWish{
    val wishList = listOf(
        Wish(title = "Apple Watch", description = "ios watch"),
        Wish(title = "Mac Book", description = "ios labtop"),
        Wish(title = "computer", description = "intel cpu i9"),
        Wish(title = "book", description = "Computer book from  any best seller"),
        Wish(title = "Bag", description = "A comfy bag to substitutefor a chair")
    )
}