package dev.abdujabbor.codial.basic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.btnGroups.setOnClickListener {
            findNavController().navigate(R.id.groupsFragment)
        }
        binding.btnCourses.setOnClickListener {
            findNavController().navigate(R.id.allCoursesFragment)
        }
        binding.btnMentors.setOnClickListener {
            findNavController().navigate(R.id.allCoursesForMentorsFragment)
        }
        return binding.root
    }

}