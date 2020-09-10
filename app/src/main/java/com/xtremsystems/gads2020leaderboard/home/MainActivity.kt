package com.xtremsystems.gads2020leaderboard.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.xtremsystems.gads2020leaderboard.R
import com.xtremsystems.gads2020leaderboard.adapters.HomeViewPagerAdapter
import com.xtremsystems.gads2020leaderboard.home.hours.HoursFragment
import com.xtremsystems.gads2020leaderboard.home.skills.SkillsFragment
import com.xtremsystems.gads2020leaderboard.submit.SubmitActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "LEADERBOAD"
        homeViewPagerAdapter = HomeViewPagerAdapter(supportFragmentManager, lifecycle)


        initFragments()
    }

    private fun initFragments() {
        homeViewPagerAdapter.addFragment(HoursFragment())
        homeViewPagerAdapter.addFragment(SkillsFragment())

        vpHome.adapter = homeViewPagerAdapter

        TabLayoutMediator(tbHome, vpHome) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Learning Leaders"
                }
                1 -> {
                    tab.text = "Skill IQ Leaders"
                }
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)

        val view: View = menu.findItem(R.id.itSubmit).actionView

        view.setOnClickListener{
            startActivity(Intent(this, SubmitActivity::class.java))

        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            android.R.id.home -> {
                onBackPressed()
                true
            }

            R.id.itSubmit -> {
                startActivity(Intent(this, SubmitActivity::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)

        }
    }


}