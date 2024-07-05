package com.example.mywishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
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