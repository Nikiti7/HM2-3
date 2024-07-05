package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.summerpractice24.databinding.FragmentCityInfoBinding

class CityInformationFragment : Fragment(R.layout.fragment_city_info) {

    private var binding: FragmentCityInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCityInfoBinding.bind(view)

        val id = arguments?.getInt(ID) ?: 0
        val name = arguments?.getString(NAME) ?: ""
        val url = arguments?.getString(URL) ?: ""
        val country = arguments?.getString(COUNTRY) ?: ""
        val longDescription = arguments?.getString(INFORMATION) ?: ""

        with(binding!!) {
            textViewName.text = name
            textViewCountry.text = country
            textViewLongDescription.text = longDescription
            Glide.with(requireContext()).load(url).into(imageView)

            imageViewBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    companion object {
        private const val ID = "id"
        private const val NAME = "name"
        private const val URL = "url"
        private const val COUNTRY = "country"
        private const val INFORMATION = "information"

        fun createBundle(
            id: Int,
            name: String,
            url: String,
            country: String,
            information: String
        ): Bundle {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            bundle.putString(NAME, name)
            bundle.putString(URL, url)
            bundle.putString(COUNTRY, country)
            bundle.putString(INFORMATION, information)
            return bundle
        }
    }

}