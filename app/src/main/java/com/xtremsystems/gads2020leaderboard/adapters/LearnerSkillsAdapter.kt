package com.xtremsystems.gads2020leaderboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.xtremsystems.gads2020leaderboard.R
import com.xtremsystems.gads2020leaderboard.data.LearnerSkillsItem
import kotlinx.android.synthetic.main.learner_item.view.*

class LearnerSkillsAdapter(private val leanerSkillsList: List<LearnerSkillsItem>) :
    RecyclerView.Adapter<LearnerSkillsAdapter.LearnerSkillsVH>() {

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
        return leanerSkillsList.size
    }

    override fun onBindViewHolder(holder: LearnerSkillsVH, position: Int) {
        val skillItem = leanerSkillsList[position]

        holder.name?.text = skillItem.name
        holder.score?.text = skillItem.score.toString() + " skill IQ Score, " + skillItem.country

        Picasso.get().load(skillItem.badgeUrl).into(holder.badge)
    }

}