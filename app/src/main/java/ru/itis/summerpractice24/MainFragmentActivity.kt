package ru.itis.summerpractice24

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.itis.summerpractice24.databinding.ActivityFragmentMainBinding

class MainFragmentActivity : AppCompatActivity() {

    private var binding: ActivityFragmentMainBinding? = null

    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        controller?.let { navController ->
            binding?.bottomNavigation?.setupWithNavController(navController)
        }

//        val cities = CityRepository.getCityById()
//        val adapter = CityAdapter() { city ->
//            val bundle = CityInformationFragment.createBundle(
//                city.id, city.name, city.url, city.country, city.longDescription
//            )
//            val fragment = CityInformationFragment().apply {
//                arguments = bundle
//            }
//        findNavController().popBackStack() {
//            setOnclickListener()
//        }
//
//        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()

        controller?.navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}