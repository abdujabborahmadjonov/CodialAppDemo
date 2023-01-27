package dev.abdujabbor.codial.workingCourses

import android.app.AlertDialog
import android.content.DialogInterface.BUTTON_POSITIVE
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.adapters.CourseAdapter
import dev.abdujabbor.codial.data.MyData
import dev.abdujabbor.codial.databinding.FragmentAllCoursesBinding
import dev.abdujabbor.codial.databinding.FragmentDialogAddCourseBinding
import dev.abdujabbor.codial.db.Mydbbrowser
import dev.abdujabbor.codial.models.Courses

class AllCoursesFragment : Fragment(),CourseAdapter.RVClickCourses {
    lateinit var dbHelper:Mydbbrowser
    lateinit var courseAdapter:CourseAdapter
    lateinit var list :ArrayList<Courses>
    val binding by lazy { FragmentAllCoursesBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        dbHelper = Mydbbrowser(binding.root.context)
        list = dbHelper.readCourses()

        courseAdapter = CourseAdapter(list,this)

        binding.recycleViewCourse.adapter = courseAdapter




        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.imageAdd.setOnClickListener {
//            var itmembinding = FragmentDialogAddCourseBinding.inflate(layoutInflater)
//            var dialog = AlertDialog.Builder(binding.root.context)
//            dialog.setView(itmembinding.root)
//            dialog.show()

            val alertDialogLayoutBinding =
                FragmentDialogAddCourseBinding.inflate(layoutInflater)
            val dialog: AlertDialog =
                AlertDialog.Builder(requireContext(), R.style.MyMenuDialogTheme)
                    .setView(alertDialogLayoutBinding.root)
                    .setPositiveButton(
                        "Qo'shish"
                    ) { _, _ ->
                        val nameCourse = alertDialogLayoutBinding.nameOfCourse.text.toString().trim()
                        val aboutCourse =
                            alertDialogLayoutBinding.aboutCourseTxt.text.toString().trim()
                        dbHelper.createCourses(Courses(nameCourse, aboutCourse),binding.root.context)
                        courseAdapter.arrayListCourses = dbHelper.readCourses()
                    }
                    .setNegativeButton("Yopish", null)
                    .create()
            dialog.show()
            dialog.getButton(BUTTON_POSITIVE).setTextColor(Color.parseColor("#FFB800"))

    }
        return binding.root
    }

    override fun onClick(courses: Courses) {
      MyData.course = courses
      findNavController().navigate(R.id.abourCoursesFragment)
    }
}