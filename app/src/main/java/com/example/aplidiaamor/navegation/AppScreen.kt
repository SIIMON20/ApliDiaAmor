package com.example.aplidiaamor.navegation

sealed class AppScreen( val route : String){
    object LoginScreen:AppScreen(route = "Login Screen")
    object registrationScreen:AppScreen(route = "Registrar Screen")
}
