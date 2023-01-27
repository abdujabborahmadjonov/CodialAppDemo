package dev.abdujabbor.codial.workingMentors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.databinding.FragmentMentorsOfCoursesBinding


class MentorsOfCoursesFragment : Fragment() {

    val binding by lazy { FragmentMentorsOfCoursesBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.lyAdd.setOnClickListener {
            findNavController().navigate(R.id.addMentorFragment)
        }
        return binding.root
    }


}