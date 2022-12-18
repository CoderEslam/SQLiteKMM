package com.doubleclick.sqlitekmm.android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*


class MainActivity : AppCompatActivity() {
    // creating variables for our edittext, button and dbhandler
    private lateinit var courseNameEdt: EditText
    private lateinit var courseTracksEdt: EditText
    private lateinit var courseDurationEdt: EditText
    private lateinit var courseDescriptionEdt: EditText
    private lateinit var addCourseBtn: Button
    private lateinit var readCourseBtn: Button
    private lateinit var dbHandler: DBHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        // initializing all our variables.
        courseNameEdt = findViewById(R.id.idEdtCourseName)
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks)
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration)
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription)
        addCourseBtn = findViewById(R.id.idBtnAddCourse)
        readCourseBtn = findViewById(R.id.idBtnReadCourse);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = DBHandler(this@MainActivity)

        // below line is to add on click listener for our add course button.
        addCourseBtn.setOnClickListener(View.OnClickListener { // below line is to get data from all edit text fields.
            val courseName = courseNameEdt!!.text.toString()
            val courseTracks = courseTracksEdt!!.text.toString()
            val courseDuration = courseDurationEdt!!.text.toString()
            val courseDescription = courseDescriptionEdt!!.text.toString()

            // validating if the text fields are empty or not.
            if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseDescription.isEmpty()) {
                Toast.makeText(this@MainActivity, "Please enter all the data..", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }

            // on below line we are calling a method to add new
            // course to sqlite data and pass all our values to it.
            dbHandler!!.addNewCourse(courseName, courseDuration, courseDescription, courseTracks)

            // after adding the data we are displaying a toast message.
            Toast.makeText(this@MainActivity, "Course has been added.", Toast.LENGTH_SHORT).show()
            courseNameEdt!!.setText("")
            courseDurationEdt!!.setText("")
            courseTracksEdt!!.setText("")
            courseDescriptionEdt!!.setText("")
        })

        readCourseBtn.setOnClickListener(View.OnClickListener { // opening a new activity via a intent.
            val i = Intent(this@MainActivity, ViewCourses::class.java)
            startActivity(i)
        })
    }
}

