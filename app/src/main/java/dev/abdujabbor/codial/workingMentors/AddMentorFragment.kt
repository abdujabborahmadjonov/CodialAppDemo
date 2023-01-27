package dev.abdujabbor.codial.workingMentors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.databinding.FragmentAddMentorBinding

class AddMentorFragment : Fragment() {
val binding by lazy { FragmentAddMentorBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

}