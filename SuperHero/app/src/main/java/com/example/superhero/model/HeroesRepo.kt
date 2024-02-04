package com.example.superhero.model

import com.example.superhero.R

object HeroesRepo {

    val heroes = listOf(
        Hero(R.drawable.android_superhero1,R.string.android_superhero1,R.string.description1),
        Hero(R.drawable.android_superhero2, R.string.android_superhero2, R.string.description2),
        Hero(R.drawable.android_superhero3, R.string.android_superhero3, R.string.description3),
        Hero(R.drawable.android_superhero4, R.string.android_superhero4, R.string.description4),
        Hero(R.drawable.android_superhero5, R.string.android_superhero5, R.string.description5),
        Hero(R.drawable.android_superhero6, R.string.android_superhero6, R.string.description6)

    )

    fun loadHeroes() : List<Hero> {
        return heroes
    }
}