package com.example.kent.hyperdeals.Adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kent.hyperdeals.LoginActivity
import com.example.kent.hyperdeals.R
import kotlinx.android.synthetic.main.notification_layout_row.view.*

class PromoListAdapter(private val selectedItem: SparseBooleanArray, private val promolist : ArrayList<PromoModel>) : RecyclerView.Adapter<PromoListAdapter.ViewHolder>(){

    private val TAG = "RecyclerViewAdapter"

    private val ListPromos = ArrayList<PromoModel>()

    private val mImage = ArrayList<String>()
    private val mTitlte = ArrayList<String>()
    private val mDescription = ArrayList<String>()

    private var mContext: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):

            ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.notification_layout_row,parent,false))

    override fun getItemCount(): Int  = promolist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val promos = promolist!![position]
        holder.ivPromoImage.setImageResource(R.drawable.bench)
        holder!!.tvPromoTitile.text = promos.promoname
        holder!!.tvPromoDescription.text = promos.promodescription

        holder.tvPromoTitile.isSelected = selectedItem.get(position,false)

       /* val intent = Intent (mContext,LoginActivity::class.java)
        intent.putExtra("" , mImage[position])
        intent.putExtra("" , mTitlte[position])
        intent.putExtra("", mDescription[position])
        mContext!!.startActivity(intent)*/

    }

    inner class ViewHolder (view:View): RecyclerView.ViewHolder(view){
        val ivPromoImage = view.PromoImage!!
        val tvPromoTitile = view.PromoTitle!!
        val tvPromoDescription = view.PromoDescription!!
    }

}