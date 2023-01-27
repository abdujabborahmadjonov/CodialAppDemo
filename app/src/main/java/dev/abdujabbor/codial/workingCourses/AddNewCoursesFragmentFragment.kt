package dev.abdujabbor.codial.workingCourses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.databinding.FragmentAddNewCoursesFragmentBinding


class AddNewCoursesFragmentFragment : Fragment() {
val bindning by lazy {FragmentAddNewCoursesFragmentBinding.inflate(layoutInflater)}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new_courses_fragment, container, false)
    }

}