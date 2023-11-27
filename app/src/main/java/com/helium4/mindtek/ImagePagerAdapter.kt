package com.helium4.mindtek

// ImagePagerAdapter.kt
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ImagePagerAdapter(private val images: List<Int>, fragmentManager: FragmentManager) :
    FragmentStateAdapter(fragmentManager, Lifecycle) {

    override fun getItemCount(): Int {
        return images.size
    }

    override fun createFragment(position: Int): Fragment {
        return ImageFragment.newInstance(images[position])
    }
}
