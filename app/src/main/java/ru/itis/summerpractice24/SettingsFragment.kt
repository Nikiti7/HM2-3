package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.itis.summerpractice24.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var binding: FragmentSettingsBinding? = null

    private var adapter: CityAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = CityAdapter(
                list = CityRepository.cities,
                glide = Glide.with(this@SettingsFragment),
                onClick = ::onItemClicked
            )

            val layoutManager = LinearLayoutManager(requireContext())

            rvCity.layoutManager = layoutManager
            rvCity.adapter = adapter

            tvTitle.setOnClickListener {
                adapter?.updateDataset(CityRepository.citiesNew)
            }
        }
    }

    private fun onItemClicked(city: City) {
        findNavController().navigate(
            R.id.action_settingsFragment_to_cityInformationFragment,
            CityInformationFragment.createBundle(city.id, city.name, city.country,city.longDescription, city.url)
        )
    }

}
