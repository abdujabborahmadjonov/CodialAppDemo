package dev.abdujabbor.codial.workinggroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.data.MyData
import dev.abdujabbor.codial.databinding.FragmentAddNewGroupBinding
import dev.abdujabbor.codial.models.Groups
import dev.abdujabbor.codial.models.Mentors

class AddNewGroupFragment : Fragment() {

    lateinit var arrayAdapterTimes: ArrayAdapter<String>
    lateinit var arrayAdapterDays: ArrayAdapter<String>
    lateinit var arrayListDay: ArrayList<String>
    lateinit var arrayListTime: ArrayList<String>
    val binding by lazy { FragmentAddNewGroupBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        arrayListTime = ArrayList()
        arrayListTime.add("10:00 - 12:00")
        arrayListTime.add("08:00 - 10:00")
        arrayListDay = ArrayList()
        arrayListTime.add("08:00 - 10:00")
        arrayListTime.add("12:00 - 14:00")
        arrayListTime.add("14:00 - 16:00")
        arrayListTime.add("16:00 - 18:00")
        arrayListTime.add("18:00 - 20:00")
        arrayListDay.add("Monday/Wednesday/Friday")
        arrayListDay.add("Tuesday/Thursday/Saturday")

        arrayAdapterTimes = ArrayAdapter(requireActivity(), R.layout.item_spinner, arrayListTime)
        arrayAdapterDays = ArrayAdapter(requireActivity(), R.layout.item_spinner, arrayListDay)
        binding.spinnerDays.setAdapter(arrayAdapterDays)
        binding.spinnerTimes.setAdapter(arrayAdapterTimes)
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.imageSave.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

}