package dev.abdujabbor.codial.workinggroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.databinding.FragmentItemBinding

class ItemFragment : Fragment() {

val binding by lazy { FragmentItemBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

}