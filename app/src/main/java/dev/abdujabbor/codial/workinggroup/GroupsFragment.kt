package dev.abdujabbor.codial.workinggroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import dev.abdujabbor.codial.R
import dev.abdujabbor.codial.adapters.GroupsAdapter
import dev.abdujabbor.codial.adapters.ViewPagerAdapter
import dev.abdujabbor.codial.data.MyData
import dev.abdujabbor.codial.databinding.FragmentGroupsBinding


class GroupsFragment : Fragment(), GroupsAdapter.RVClickGroups {
    private lateinit var arrayListTypes: ArrayList<String>
    private var arrayListFragment = arrayListOf<Fragment>()
   lateinit var viewPagerAdapter:ViewPagerAdapter


    val binding by lazy { FragmentGroupsBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadData()
        binding.viewPager.adapter = viewPagerAdapter
        binding.viewPager.isSaveEnabled = false
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.lyAdd.setOnClickListener{
            findNavController().navigate(R.id.addGroupsFragment)
        }
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = arrayListTypes[position]
        }.attach()


        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.imageAdd.visibility = View.INVISIBLE
                        binding.lyAdd.visibility = View.INVISIBLE
                    }
                    1 -> {
                        binding.imageAdd.visibility = View.VISIBLE
                        binding.lyAdd.visibility = View.VISIBLE
                    }
                }
            }
        })



        return binding.root
    }
    private fun loadData() {
        arrayListTypes = ArrayList()
        binding.tvCoursesName.text = "Android"
        arrayListFragment = arrayListOf(
            Item2Fragment(), ItemFragment()
        )

        arrayListTypes.add("Opened\nGroups")
        arrayListTypes.add("Opening\nGroups")
        viewPagerAdapter =
            ViewPagerAdapter(arrayListFragment, requireActivity().supportFragmentManager, lifecycle)
    }


}