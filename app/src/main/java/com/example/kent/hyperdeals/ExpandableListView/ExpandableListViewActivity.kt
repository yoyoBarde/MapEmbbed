package com.example.kent.hyperdeals.ExpandableListView

import android.content.Context
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.kent.hyperdeals.R

class ExpandableListViewActivity (val context: Context,val listOfHeaderData:List<String>, val listOfChildData:HashMap<String,List<String>>):BaseExpandableListAdapter() {
    override fun getGroup(position: Int): Any {
        return listOfHeaderData[position]
    }

    override fun isChildSelectable(headerPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val headerTitle = getGroup(groupPosition) as String
        val view: View = LayoutInflater.from (context).inflate(R.layout.expandablefirstrow,parent,false)
        val listHeaderText = view.findViewById<View>(R.id.rowParentText) as TextView

        listHeaderText.setTypeface(null,Typeface.BOLD)
        listHeaderText.text = headerTitle

        return view
    }

    override fun getChildrenCount(groupPosition: Int): Int {
       return listOfChildData[listOfHeaderData[groupPosition]]!!.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
       return listOfChildData[listOfHeaderData[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
       val childText = getChild(groupPosition,childPosition) as String
        val view : View = LayoutInflater.from(context).inflate(R.layout.expandablesecondrow,parent,false)
        val listItemText = view.findViewById<View>(R.id.rowSecondText) as TextView
        listItemText.text = childText

        return view

    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGroupCount(): Int {
        return listOfHeaderData.size
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}