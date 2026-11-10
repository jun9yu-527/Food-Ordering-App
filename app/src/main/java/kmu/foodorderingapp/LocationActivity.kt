package kmu.foodorderingapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kmu.foodorderingapp.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val locations = arrayOf("Jaipur", "Delhi", "Mumbai", "Seoul", "Daegu", "Busan")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locations)
        binding.locationList.setAdapter(adapter)
        binding.locationList.setText(locations[0], false)

        binding.locationList.setOnClickListener { binding.locationList.showDropDown() }
        binding.arrowDown.setOnClickListener { binding.locationList.showDropDown() }
    }
}
