package com.yml.retrofitexample2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var recycler:RecyclerView
class ProductCategoryFragment : Fragment(R.layout.fragment_product_category) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.recyclerView8)
        recycler.layoutManager = LinearLayoutManager(view.context)
        val mainViewModel = ViewModelClass()
        mainViewModel.getProductCategories(object : APIResponseInterface {
            override fun onResponse(response: List<ResponseObjects>) {
                recycler.adapter = AdapterClass(response)
            }

            override fun onFailure(t: Throwable) {
                Toast.makeText(view.context, t.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

}