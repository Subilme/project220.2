package com.zonnon.project220_2.domain

import java.io.Serializable


data class FilmItemModel(
    var title: String = "",
    var description: String = "",
    var poster: String = "",
    var time: String = "",
    var trailer: String = "",
    var imdb: Int = 0,
    var year: Int = 0,
    var price: Double = 0.0,
    var genre: ArrayList<String> = ArrayList(),
    var casts: ArrayList<CastModel> = ArrayList()
) : Serializable
