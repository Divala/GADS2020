package com.xtremsystems.gads2020leaderboard.home.hours

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xtremsystems.gads2020leaderboard.R
import com.xtremsystems.gads2020leaderboard.adapters.LearnerHoursAdapter
import com.xtremsystems.gads2020leaderboard.home.MainViewModel
import kotlinx.android.synthetic.main.fragment_hours.*

class HoursFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainViewModel = MainViewModel()

        getLearnersHours()

        return inflater.inflate(R.layout.fragment_hours, container, false)
    }

    private fun getLearnersHours() {
        mainViewModel.learnerHours()

        mainViewModel.learnerHours.observe(this, { learnerHours ->

            rvHours.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            rvHours.adapter = LearnerHoursAdapter(learnerHours)
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