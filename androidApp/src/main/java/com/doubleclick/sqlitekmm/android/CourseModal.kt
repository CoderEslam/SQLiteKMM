package com.doubleclick.sqlitekmm.android

/**
 * Created By Eslam Ghazy on 12/19/2022
 */
class CourseModal(
    courseName: String,
    courseDuration: String,
    courseTracks: String,
    courseDescription: String
) {
    // variables for our coursename,
    // description, tracks and duration, id.
    private var courseName: String
    private var courseDuration: String
    private var courseTracks: String
    private var courseDescription: String
    private var id = 0

    // creating getter and setter methods
    fun getCourseName(): String {
        return courseName
    }

    fun setCourseName(courseName: String) {
        this.courseName = courseName
    }

    fun getCourseDuration(): String {
        return courseDuration
    }

    fun setCourseDuration(courseDuration: String) {
        this.courseDuration = courseDuration
    }

    fun getCourseTracks(): String {
        return courseTracks
    }

    fun setCourseTracks(courseTracks: String) {
        this.courseTracks = courseTracks
    }

    fun getCourseDescription(): String {
        return courseDescription
    }

    fun setCourseDescription(courseDescription: String) {
        this.courseDescription = courseDescription
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    // constructor
    init {
        this.courseName = courseName
        this.courseDuration = courseDuration
        this.courseTracks = courseTracks
        this.courseDescription = courseDescription
    }
}