package dev.abdujabbor.codial.workingCourses

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.databinding.FragmentDialogAddCourseBinding
import dev.abdujabbor.codial.db.Mydbbrowser
import dev.abdujabbor.codial.models.Courses


class DialogAddCourseFragment : Fragment() {
lateinit var list  :ArrayList<Courses>
lateinit var dbHelper:Mydbbrowser

val binding by lazy { FragmentDialogAddCourseBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dbHelper = Mydbbrowser(binding.root.context)
        list = dbHelper.readCourses()

        binding.apply {
//
//            binding.addBtn.setOnClickListener {
//                val name = binding.nameOfCourse.text.toString().trim()
//                val description = binding.aboutCourseTxt.text.toString().trim()
//
//                if(name.isNotEmpty()&&description.isNotEmpty()){
//
//                    dbHelper.createCourses(Courses(name,description),binding.root.context)
//                    Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
//
//                }
//
//            }
        }
        return binding.root
    }
}