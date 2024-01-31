package com.example.findcourses

class Course(


) {

    fun loadCoursesData() : List<CourseData> {
        return listOf<CourseData>(
            CourseData(R.drawable.architecture, R.string.architecture),
            CourseData(R.drawable.drawing, R.string.drawing),
//            CourseData(R.drawable.ic_launcher_background, R.string.ic_launcher_background),
            CourseData(R.drawable.photography, R.string.photography),
            CourseData(R.drawable.business, R.string.business),
            CourseData(R.drawable.fashion, R.string.fashion),
//            CourseData(R.drawable.ic_launcher_foreground, R.string.ic_launcher_foreground),
            CourseData(R.drawable.tech, R.string.tech),
            CourseData(R.drawable.crafts, R.string.crafts),
            CourseData(R.drawable.film, R.string.film),
            CourseData(R.drawable.lifestyle, R.string.lifestyle),
            CourseData(R.drawable.culinary, R.string.culinary),
            CourseData(R.drawable.gaming, R.string.gaming),
            CourseData(R.drawable.music, R.string.music),
            CourseData(R.drawable.design, R.string.design),
//            CourseData(R.drawable.ic_grain, R.string.ic_grain),
            CourseData(R.drawable.painting, R.string.painting)
        )
    }

}