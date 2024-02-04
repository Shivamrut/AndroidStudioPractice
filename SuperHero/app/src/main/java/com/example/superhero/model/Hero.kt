package com.example.superhero.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @DrawableRes val imageResource : Int,
    @StringRes val nameStringResource : Int,
    @StringRes val descriptionStringResource : Int,

)



