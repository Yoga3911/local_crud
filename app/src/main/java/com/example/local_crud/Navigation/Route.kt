package com.example.local_crud.Navigation

sealed class Route(val screen: String) {
    object Home : Route("home")
    object Add : Route("add")
    object Edit : Route("edit")
}