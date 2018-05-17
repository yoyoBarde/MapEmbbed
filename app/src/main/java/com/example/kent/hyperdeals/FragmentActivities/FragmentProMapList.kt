package com.example.kent.hyperdeals.FragmentActivities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kent.hyperdeals.Adapters.PromoListAdapter
import com.example.kent.hyperdeals.Adapters.PromoModel
import com.example.kent.hyperdeals.Interface.RecyclerTouchListener
import com.example.kent.hyperdeals.R
import kotlinx.android.synthetic.main.fragmentpromaplist.*

class FragmentProMapList: Fragment() {

    private val promolist = ArrayList<PromoModel>()
    private var mAdapter : PromoListAdapter? = null
    private var mSelected: SparseBooleanArray = SparseBooleanArray()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragmentpromaplist,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)

        mAdapter = PromoListAdapter(mSelected,promolist)

        recyclerViewProMapList.layoutManager = layoutManager
        recyclerViewProMapList.itemAnimator = DefaultItemAnimator()
        recyclerViewProMapList.adapter = mAdapter

        promolist.add(PromoModel("", "Bench Denim 50% Off!", "Bench denim sale: Promo runs til May20-21,2018. Hurry and grab yours now!" ))
        promolist.add(PromoModel("", "Bench Denim 50% Off!", "Bench denim sale: Promo runs til May20-21,2018. Hurry and grab yours now!"))
        promolist.add(PromoModel("", "Bench Denim 50% Off!", "Bench denim sale: Promo runs til May20-21,2018. Hurry and grab yours now!" ))
        promolist.add(PromoModel("", "Bench Denim 50% Off!", "Bench denim sale: Promo runs til May20-21,2018. Hurry and grab yours now!" ))
        promolist.add(PromoModel("", "Bench Denim 50% Off!", "Bench denim sale: Promo runs til May20-21,2018. Hurry and grab yours now!" ))
        promolist.add(PromoModel("", "Bench Denim 50% Off!", "Bench denim sale: Promo runs til May20-21,2018. Hurry and grab yours now!" ))
        promolist.add(PromoModel("", "Bench Denim 50% Off!", "Bench denim sale: Promo runs til May20-21,2018. Hurry and grab yours now!" ))
        promolist.add(PromoModel("", "Bench Denim 50% Off!", "Bench denim sale: Promo runs til May20-21,2018. Hurry and grab yours now!" ))
        promolist.add(PromoModel("", "Bench Denim 50% Off!", "Bench denim sale: Promo runs til May20-21,2018. Hurry and grab yours now!" ))
        promolist.add(PromoModel("", "Bench Denim 50% Off!", "Bench denim sale: Promo runs til May20-21,2018. Hurry and grab yours now!" ))

        mAdapter?.notifyDataSetChanged()


        recyclerViewProMapList.addOnItemTouchListener(RecyclerTouchListener(this.context!!.applicationContext, object : RecyclerTouchListener.ClickListener {
            override fun onClick(view: View, position: Int) {
                for (i in 0 until position)
                Toast.makeText(context,"You clicked one", Toast.LENGTH_SHORT).show()


            }


        }))

    }
}