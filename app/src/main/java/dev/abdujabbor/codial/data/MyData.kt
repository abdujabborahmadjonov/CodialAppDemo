package dev.abdujabbor.codial.data

import dev.abdujabbor.codial.models.Courses
import dev.abdujabbor.codial.models.Groups
import dev.abdujabbor.codial.models.Mentors
import dev.abdujabbor.codial.models.Students

object MyData {
    var tvAllCourseNames = ""
    var booleanAddCourses = true
    var course = Courses()
    var mentors = Mentors()
    var groups = Groups()
    var students = Students()
    var navigationID = 0
    var editStudents = false
}