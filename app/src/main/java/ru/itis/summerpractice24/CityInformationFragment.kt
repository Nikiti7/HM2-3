package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summerpractice24.databinding.FragmentCityInfoBinding

class CityInformationFragment : Fragment(R.layout.fragment_city_info) {

    private var binding: FragmentCityInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt(ID) ?: 0
        val name = arguments?.getInt(NAME) ?: ""
        val url = arguments?.getString(URL) ?: ""
        val country = arguments?.getInt(COUNTRY) ?: ""

        with(binding) {
            // здесь забиндишь все TextView и с помощью Glide подтянешь картинку
        }
    }

    companion object {
        private const val ID = "id"
        private const val NAME = "name"
        private const val URL = "url"
        private const val COUNTRY = "country"

        fun createBundle(id:Int, name: String , url: String, country: String): Bundle {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            bundle.putString(NAME, name)
            bundle.putString(URL, url)
            bundle.putString(COUNTRY, country)
            return bundle
        }
    }

}