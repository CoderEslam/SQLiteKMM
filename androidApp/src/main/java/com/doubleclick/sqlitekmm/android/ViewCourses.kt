package com.doubleclick.sqlitekmm.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ViewCourses : AppCompatActivity() {
    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private lateinit var courseModalArrayList: ArrayList<CourseModal>
    private lateinit var dbHandler: DBHandler
    private lateinit var courseRVAdapter: CourseRVAdapter
    private lateinit var coursesRV: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_courses)

        // initializing our all variables.
        courseModalArrayList = ArrayList()
        dbHandler = DBHandler(this@ViewCourses)

        // getting our course array
        // list from db handler class.
        courseModalArrayList = dbHandler!!.readCourses()

        // on below line passing our array lost to our adapter class.
        courseRVAdapter = CourseRVAdapter(courseModalArrayList!!, this@ViewCourses)
        coursesRV = findViewById(R.id.idRVCourses)

        // setting layout manager for our recycler view.
        val linearLayoutManager =
            LinearLayoutManager(this@ViewCourses, RecyclerView.VERTICAL, false)
        coursesRV.layoutManager = linearLayoutManager

        // setting our adapter to recycler view.
        coursesRV.adapter = courseRVAdapter
    }
}