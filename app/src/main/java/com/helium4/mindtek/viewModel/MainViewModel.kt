package com.helium4.mindtek.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helium4.mindtek.R
import com.helium4.mindtek.data.ImageItem

data class ItemWithImage(val imageResource: Int, val text: String)

class MainViewModel : ViewModel() {

    private val _images = MutableLiveData<List<ImageItem>>()
    val images: LiveData<List<ImageItem>>
        get() = _images

    private val _originalItemList = MutableLiveData<List<ItemWithImage>>()
    private val _originalItemList2 = MutableLiveData<List<ItemWithImage>>()
    private val _originalItemList3 = MutableLiveData<List<ItemWithImage>>()

    private val _itemLists = MutableLiveData<List<ItemWithImage>>()
    val itemLists: LiveData<List<ItemWithImage>>
        get() = _itemLists

    private val _itemLists2 = MutableLiveData<List<ItemWithImage>>()
    val itemLists2: LiveData<List<ItemWithImage>>
        get() = _itemLists2
    private val _itemLists3 = MutableLiveData<List<ItemWithImage>>()
    val itemLists3: LiveData<List<ItemWithImage>>
        get() = _itemLists3

    init {
        initData()
    }

    fun initData() {
        _images.value = listOf(
            ImageItem(R.drawable.ic_launcher_foreground, "Image 1"),
            ImageItem(R.drawable.ic_launcher_foreground, "Image 2"),
            ImageItem(R.drawable.ic_launcher_foreground, "Image 3")
        )

        _originalItemList.value = listOf(
            ItemWithImage(R.drawable.baseline_android_24, "Label1"),
            ItemWithImage(R.drawable.baseline_android_24, "Label2"),
            ItemWithImage(R.drawable.baseline_android_24, "Label3"),
            ItemWithImage(R.drawable.baseline_android_24, "Label4"),
            ItemWithImage(R.drawable.baseline_android_24, "Label5"),
            ItemWithImage(R.drawable.baseline_android_24, "Label6"),
            ItemWithImage(R.drawable.baseline_android_24, "Label7"),
            ItemWithImage(R.drawable.baseline_android_24, "Label8"),
            ItemWithImage(R.drawable.baseline_android_24, "Label9"),
            ItemWithImage(R.drawable.baseline_android_24, "Label40"),
            ItemWithImage(R.drawable.baseline_android_24, "Label25"),
            ItemWithImage(R.drawable.baseline_android_24, "Label36"),
            ItemWithImage(R.drawable.baseline_android_24, "Label77"),
        )
        _originalItemList2.value = listOf(
            ItemWithImage(R.drawable.baseline_android_24, "XYZ1"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ2"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ3"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ4"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ5"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ6"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ7"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ8"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ9"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ40"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ25"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ36"),
            ItemWithImage(R.drawable.baseline_android_24, "XYZ77"),
        )

        _originalItemList3.value = listOf(
            ItemWithImage(R.drawable.baseline_android_24, "abc1"),
            ItemWithImage(R.drawable.baseline_android_24, "abc2"),
            ItemWithImage(R.drawable.baseline_android_24, "abc3"),
            ItemWithImage(R.drawable.baseline_android_24, "abc4"),
            ItemWithImage(R.drawable.baseline_android_24, "abc5"),
            ItemWithImage(R.drawable.baseline_android_24, "abc6"),
            ItemWithImage(R.drawable.baseline_android_24, "abc7"),
            ItemWithImage(R.drawable.baseline_android_24, "abc8"),
            ItemWithImage(R.drawable.baseline_android_24, "abc9"),
            ItemWithImage(R.drawable.baseline_android_24, "abc40"),
            ItemWithImage(R.drawable.baseline_android_24, "abc25"),
            ItemWithImage(R.drawable.baseline_android_24, "abc6"),
            ItemWithImage(R.drawable.baseline_android_24, "abc77"),
        )
        _itemLists.value = _originalItemList.value
        _itemLists2.value = _originalItemList2.value

        _itemLists3.value = _originalItemList3.value

    }

    fun filterItems(query: String,id:String) {
        if (id=="0"){
            if (query.isEmpty()) {
                // If the query is empty, restore the original data
                _itemLists.value = _originalItemList.value
            } else {
                // Filter the data based on the query
                val filteredList = _originalItemList.value?.filter { it.text.contains(query, true) }
                _itemLists.value = filteredList
            }
        }else if(id =="1"){
            if (query.isEmpty()) {
                // If the query is empty, restore the original data
                _itemLists.value = _originalItemList2.value
            } else {
                // Filter the data based on the query
                val filteredList = _originalItemList2.value?.filter { it.text.contains(query, true) }
                _itemLists.value = filteredList
            }
        }
        else if (id=="2"){
            if (query.isEmpty()) {
                // If the query is empty, restore the original data
                _itemLists.value = _originalItemList3.value
            } else {
                // Filter the data based on the query
                val filteredList = _originalItemList3.value?.filter { it.text.contains(query, true) }
                _itemLists.value = filteredList
            }
        }


    }
    fun getImageSize():Int {
        return  images.value!!.size
    }
}
