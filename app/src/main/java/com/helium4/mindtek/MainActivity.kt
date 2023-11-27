package com.helium4.mindtek

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.helium4.mindtek.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.widget.ViewPager2
import com.helium4.mindtek.adapter.ItemAdapter
import com.helium4.mindtek.adapter.ImageAdapter
import com.helium4.mindtek.viewModel.ItemWithImage
import com.helium4.mindtek.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val _id = MutableLiveData<String>("0")
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageAdapter = ImageAdapter()
        binding.viewPager.adapter = imageAdapter

        itemAdapter = ItemAdapter()
        binding.recyclerView.adapter = itemAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.searchView.queryHint = "Search Here"

    //    InitIndicators()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
              //  viewModel.filterItems(query.orEmpty())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.filterItems(newText.orEmpty(), _id.value.toString())
                return true
            }


        })

        observeViewModel()
    }

    private fun InitIndicators() {
//        binding.indicatorView.setNumIndicators(viewModel.getImageSize())
        Log.wtf("safkjdafaj","Total Size: " +viewModel.getImageSize())

    }

    private fun observeViewModel() {

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
_id.postValue(position.toString())
                when (position) {
                    0 -> {
                        viewModel.itemLists.observe(this@MainActivity, Observer { items ->
                            itemAdapter.submitList(items)

                        })
                    }
                    1 -> {
                        viewModel.itemLists2.observe(this@MainActivity, Observer { items ->
                            itemAdapter.submitList(items)

                        })
                    }
                    2 -> {
                        viewModel.itemLists3.observe(this@MainActivity, Observer { items ->
                            itemAdapter.submitList(items)

                        })
                    }
                }
            }
        })
        viewModel.images.observe(this, Observer { images ->
            imageAdapter.submitList(images)
        })
    }
}
