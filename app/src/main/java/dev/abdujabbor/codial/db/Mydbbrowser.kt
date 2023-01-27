package dev.abdujabbor.codial.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import dev.abdujabbor.codial.models.Courses
import dev.abdujabbor.codial.models.Groups
import dev.abdujabbor.codial.models.Mentors
import dev.abdujabbor.codial.models.Students

class Mydbbrowser(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, 1), MyDbService {


    override fun onCreate(db: SQLiteDatabase?) {
        val queryGroups =
            "create table $TABLE_GROUPS($GROUPS_ID integer not null primary key unique,$GROUPS_NAME text not null unique,$GROUPS_MENTORS_ID integer not null,$GROUPS_TIMES text not null," +
                    "$GROUPS_DAYS text not null,$GROUPS_COURSES_ID integer not null,$GROUPS_OPEN numeric not null, foreign key ($GROUPS_COURSES_ID) references $TABLE_COURSES($COURSE_ID))"
        val queryCourses =
            "create table $TABLE_COURSES($COURSE_ID integer not null primary key autoincrement unique ,$COURSE_NAME text not null unique ,$COURSE_ABOUT text  not null )"
        db?.execSQL(queryCourses)
        db?.execSQL(queryGroups)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // hali yuklaganim yo
    }


    override fun createCourses(courses: Courses, context: Context): Boolean {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COURSE_NAME, courses.name)
        contentValues.put(COURSE_ABOUT, courses.description)

        val result = database.insert(TABLE_COURSES, null, contentValues)
        val boolean = if (result.toInt() == -1) {
            Toast.makeText(
                context,
                "Failed to added \n a coure with this name already exists, please try again by changing the name ",
                Toast.LENGTH_SHORT
            ).show()
            false
        } else {
            Toast.makeText(context, "Sucsseful added", Toast.LENGTH_SHORT).show()
            true
        }
        return boolean
    }

    override fun readCourses(): ArrayList<Courses> {
        val arraylistCourses = ArrayList<Courses>()
        val database = this.readableDatabase
        val query = "select * from $TABLE_COURSES"

        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val courses = Courses(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)

                )
                arraylistCourses.add(courses)
            } while (cursor.moveToNext())
        }
        return arraylistCourses

    }

    override fun deleteCourses(courses: Courses): Boolean {

        val database = this.writableDatabase
        getMentorByCoursesID(courses)

        var result =database.delete(TABLE_COURSES,"$COURSE_ID =?", arrayOf(courses.id.toString()))

        return result !=1
    }

    override fun getCourseById(id: Int): Courses {

        val database = this.writableDatabase
        val cursor = database.query(
            TABLE_COURSES, arrayOf(COURSE_ID, COURSE_NAME, COURSE_ABOUT), "$COURSE_ID = ?",
            arrayOf(id.toString()), null, null, null
        )
        cursor.moveToNext()
        return return Courses(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2)
        )


    }

    override fun createMentors(mentors: Mentors, context: Context) {
        TODO("Not yet implemented")
    }

    override fun readMentors(): ArrayList<Mentors> {
        TODO("Not yet implemented")
    }

    override fun updateMentors(mentors: Mentors, context: Context) {
        TODO("Not yet implemented")
    }

    override fun deleteMentors(mentors: Mentors): Boolean {
        TODO("Not yet implemented")
    }

    override fun getMentorsByID(id: Int): Mentors {
        TODO("Not yet implemented")
    }

    override fun getMentorByCoursesID(courses: Courses) {
        val database = this.writableDatabase
        val query = "select * from $TABLE_MMENTORS where $MENTORS_COURSES_ID ='${courses.id}'"
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {

                val mentors = Mentors(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    getCourseById(cursor.getInt(4))
                )

            } while (cursor.moveToNext())
        }
    }

    override fun getAllMentorsByID(id: Int): ArrayList<Mentors> {
        TODO("Not yet implemented")
    }

    override fun createGroups(groups: Groups, context: Context): Boolean {
        TODO("Not yet implemented")
    }

    override fun readGroups(string: String, context: Context): ArrayList<Groups> {
        TODO("Not yet implemented")
    }

    override fun updateGroups(groups: Groups, context: Context) {
        TODO("Not yet implemented")
    }

    override fun deleteGroups(groups: Groups): Boolean {
        TODO("Not yet implemented")
    }

    override fun getGroupsByMentorsID(mentors: Mentors) {
        TODO("Not yet implemented")
    }

    override fun getGroupsByID(id: Int, boolean: Boolean): Groups {
        TODO("Not yet implemented")
    }

    override fun startLessonGroup(groups: Groups, context: Context): Boolean {
        TODO("Not yet implemented")
    }

    override fun createStudents(students: Students, context: Context) {
        TODO("Not yet implemented")
    }

    override fun readStudents(id: Int, boolean: Boolean): ArrayList<Students> {
        TODO("Not yet implemented")
    }

    override fun updateStudents(students: Students, context: Context) {
        TODO("Not yet implemented")
    }

    override fun deleteStudents(students: Students): Boolean {
        TODO("Not yet implemented")
    }

    override fun getStudentByGroupsID(groups: Groups) {
        TODO("Not yet implemented")
    }

    companion object {
        const val DB_NAME = "Codial"

        //courses
        const val TABLE_COURSES = "courses"
        const val COURSE_ID = "id"
        const val COURSE_NAME = "name"
        const val COURSE_ABOUT = "about"

        //mentors
        const val TABLE_MMENTORS = "mentors"
        const val MMENTORS__ID = "id"
        const val MENTORS_SURNAME = "surname"
        const val MMENTORS__NAME = "name"
        const val MMENTORS__ABOUT = "name"
        const val MENTORS_COURSES_ID = "courses_id"


        //groups
        const val TABLE_GROUPS = "groups"
        const val GROUPS_ID = "id"
        const val GROUPS_NAME = "name"
        const val GROUPS_MENTORS_ID = "mentors_id"
        const val GROUPS_TIMES = "times"
        const val GROUPS_DAYS = "days"
        const val GROUPS_COURSES_ID = "courses_id"
        const val GROUPS_OPEN = "open"

        //studets
        const val TABLE_STUDENTS = "students"
        const val STUDENTS_ID = "id"
        const val STUDENTS_NAME = "name"
        const val STUDENTS_SURNAME = "surname"
        const val STUDENTS_NUMBER = "number"
        const val STUDENTS_DAY = "day"
        const val STUDENTS_GROUPS_ID = "groups_id"

    }
}
