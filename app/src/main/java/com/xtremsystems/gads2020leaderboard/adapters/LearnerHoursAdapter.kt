package com.xtremsystems.gads2020leaderboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.xtremsystems.gads2020leaderboard.R
import com.xtremsystems.gads2020leaderboard.data.LearnerHoursItem
import kotlinx.android.synthetic.main.learner_item.view.*

class LearnerHoursAdapter(private val leanerHoursList: List<LearnerHoursItem>) :
    RecyclerView.Adapter<LearnerHoursAdapter.LearnerSkillsVH>() {

    class LearnerSkillsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView? = itemView.tvName
        val badge: ImageView? = itemView.imgBadge
        val score: TextView? = itemView.tvScore

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnerSkillsVH {
        return LearnerSkillsVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.learner_item,
                parent,
                false
            ),
        )
    }

    override fun getItemCount(): Int {
        return leanerHoursList.size
    }

    override fun onBindViewHolder(holder: LearnerSkillsVH, position: Int) {
        val hourItem = leanerHoursList[position]

        holder.name?.text = hourItem.name
        holder.score?.text = hourItem.hours.toString() + " learning hours, " + hourItem.country

        Picasso.get().load(hourItem.badgeUrl).into(holder.badge)
    }
}