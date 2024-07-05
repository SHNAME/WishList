package com.example.mywishlistapp

sealed class Screen(val route: String) {
    //상속이 불가능하도록 sealed class로 작성
    object HomeScreen: Screen("home_screen")
    object AddScreen: Screen("add_screen")
}