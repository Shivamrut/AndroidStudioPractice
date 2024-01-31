package com.example.findcourses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseData(
    @DrawableRes val imageResource: Int,
    @StringRes val stringResource: Int,
//    val numberOfCourses : Int
)
