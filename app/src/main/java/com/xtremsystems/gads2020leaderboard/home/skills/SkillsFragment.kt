package com.xtremsystems.gads2020leaderboard.home.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xtremsystems.gads2020leaderboard.R
import com.xtremsystems.gads2020leaderboard.adapters.LearnerSkillsAdapter
import com.xtremsystems.gads2020leaderboard.home.MainViewModel
import kotlinx.android.synthetic.main.fragment_skills.*

class SkillsFragment : Fragment() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainViewModel = MainViewModel()

        getLearnersSkills()

        return inflater.inflate(R.layout.fragment_skills, container, false)
    }

    private fun getLearnersSkills() {
        mainViewModel.learnerSkills()

        mainViewModel.learnerSkills.observe(this, { learnerSkills ->
            rvSkills.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            rvSkills.adapter = LearnerSkillsAdapter(learnerSkills)
        })

        mainViewModel.errorMessage.observe(this, { message ->
            if (message.isNotEmpty()) {

                activity?.let {
                    androidx.appcompat.app.AlertDialog.Builder(it)
                        .setMessage(message)
                        .setTitle("Error")
                        .setNegativeButton("Ok") { dialogInterface, _ ->
                            mainViewModel.errorMessage.postValue("")
                            dialogInterface.cancel()
                        }
                        .show()
                }
            }

        })

    }
}