package com.example.feelings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class FeelingAdapter internal constructor(context: Context): RecyclerView.Adapter<FeelingAdapter.FeelingViewHolder>(){

    private val inflater : LayoutInflater = LayoutInflater.from(context)
    private var feelingList = emptyList<Feeling>() //cashed copy of feeling record

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeelingViewHolder {
        val itemView = inflater.inflate(R.layout.feeling_records,parent, false)
        return FeelingViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return feelingList.size
    }

    override fun onBindViewHolder(holder: FeelingViewHolder, position: Int) {
        //position = record position
        val feeling = feelingList.get(position)
        if(feeling.mood == 1){
            holder.imageViewFeeling.setImageResource(R.drawable.ic_sentiment_dissatisfied_100dp)
        }else if(feeling.mood == 2){
            holder.imageViewFeeling.setImageResource(R.drawable.ic_sentiment_neutral_100dp)
        }else{
            holder.imageViewFeeling.setImageResource(R.drawable.ic_sentiment_satisfied_100dp)
        }

        holder.textViewRemark.text = feeling.remarkd
        holder.textViewDate.text = SimpleDateFormat("yyyy.MM.dd.HH.MM").format(feeling.created_at)
    }

    inner class FeelingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageViewFeeling: ImageView =
            itemView.findViewById(R.id.imageViewMood)

        val //TODO - havent done yet
    }
}