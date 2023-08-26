package com.example.kafic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.kafic.database.Category
import com.example.kafic.database.CategoryDatabase
import com.example.kafic.database.Item
import com.example.kafic.databinding.FragmentAddItemBinding
import kotlinx.coroutines.launch

class AddItemFragment : Fragment() {

    private lateinit var binding : FragmentAddItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_item, container, false)
        val view = binding.root

        val dao = CategoryDatabase.getInstance(requireContext()).categoryDao

        val category = listOf(
            Category("Drinks"),
            Category("Appetizers"),
            Category("Main course"),
            Category("Desserts")
        )

        val items = listOf(
            Item("Coke","4.0", "Drinks"),
            Item("Sprite", "4.0", "Drinks"),
            Item("Fried calamari", "8.95", "appetizers"),
            Item("Bruschetta", "9.0", "Main course"),
            Item("Tiramiu", "7.0", "Desserts")
        )

        lifecycleScope.launch {
            category.forEach { dao.insertCategory(it) }
            items.forEach { dao.insertItem(it) }

            val itemss = dao.getCategoryAndItem("Drinks")

        }
//        val options = arrayOf("Drinks","Appetizers","Main course","Desserts")
//        val arrayAdapter  = context?.let {
//            ArrayAdapter(it.applicationContext, android.R.layout.simple_list_item_1, options) }
//        binding.category.adapter = arrayAdapter
//
//        binding.category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//            }
//        }

        return view
    }
}