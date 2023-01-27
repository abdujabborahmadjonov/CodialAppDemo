package dev.abdujabbor.codial.workinggroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.databinding.FragmentItem2Binding


class Item2Fragment : Fragment() {
val binding by lazy {FragmentItem2Binding.inflate(layoutInflater)}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
}