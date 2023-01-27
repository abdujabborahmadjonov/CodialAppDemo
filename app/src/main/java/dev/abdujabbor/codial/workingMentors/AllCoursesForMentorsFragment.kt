package dev.abdujabbor.codial.workingMentors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.databinding.FragmentAllCoursesForMentorsBinding

class AllCoursesForMentorsFragment : Fragment() {

    val binding by lazy { FragmentAllCoursesForMentorsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {

        binding.lyAdd.setOnClickListener {
            findNavController().navigate(R.id.mentorsOfCoursesFragment)
        }
        return binding.root
    }

}