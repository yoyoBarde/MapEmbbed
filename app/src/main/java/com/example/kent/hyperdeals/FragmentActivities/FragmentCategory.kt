package com.example.kent.hyperdeals.FragmentActivities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import com.example.kent.hyperdeals.ExpandableListView.ExpandableListViewActivity
import com.example.kent.hyperdeals.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.expandablelistview.*

class FragmentCategory: Fragment() {




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragmentcategory, container, false)
/*


        val listHeader = listOf("Jeans", "Computers")

        val jeansList = listOf("Denim", "Ripped", "Formal", "Slacks")
        val brandList = listOf("Acer", "Lenovo", "SONY", "Dell")

        val listChild = HashMap<String, List<String>>()
        listChild.put(listHeader[0], jeansList)
        listChild.put(listHeader[1], brandList)

        val expandableListAdapter = ExpandableListViewActivity(view.context.applicationContext, listHeader, listChild)
        expandableListView.setAdapter(expandableListAdapter)


        return view
*/


    }
}