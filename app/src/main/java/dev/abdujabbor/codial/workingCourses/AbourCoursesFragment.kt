package dev.abdujabbor.codial.workingCourses

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.data.MyData
import dev.abdujabbor.codial.data.MyData.course
import dev.abdujabbor.codial.databinding.FragmentAbourCoursesBinding
import dev.abdujabbor.codial.db.Mydbbrowser
import dev.abdujabbor.codial.models.Courses

class AbourCoursesFragment : Fragment() {
    lateinit var dbHelper:Mydbbrowser
    lateinit var list:ArrayList<Courses>
    val binding by lazy { FragmentAbourCoursesBinding.inflate(layoutInflater) }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dbHelper = Mydbbrowser(binding.root.context)
        list = dbHelper.readCourses()
        binding.imageDelete.setOnClickListener {

        }
      binding.tvAllCourseName.text = course.name
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.tvDescription.text = course.description
        return binding.root
    }

}