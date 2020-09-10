package com.xtremsystems.gads2020leaderboard.submit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.xtremsystems.gads2020leaderboard.R
import kotlinx.android.synthetic.main.activity_submit.*


class SubmitActivity : AppCompatActivity() {
    private val submitViewModel: SubmitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        setSupportActionBar(toolbar)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        btnSubmit.setOnClickListener {
            showConfirmDialog()
        }
    }

    private fun showConfirmDialog() {
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View =
            LayoutInflater.from(this).inflate(R.layout.custom_dialog, viewGroup, false)
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog: android.app.AlertDialog? = builder.create()
        alertDialog?.setCancelable(false)

        val btnSend: Button = dialogView.findViewById(R.id.btnDialog) as Button
        val imgCancel: ImageView = dialogView.findViewById(R.id.imgDialog) as ImageView

        btnSend.setOnClickListener {
            submitViewModel.submitProject(
                etFirstName.text.toString(),
                etSurname.text.toString(),
                etEmail.text.toString(),
                etProjectLink.text.toString()
            )

            submitViewModel.submit.observe(this, {
                showSuccess()
            })

            submitViewModel.errorMessage.observe(this, {
                showError()
            })
        }

        imgCancel.setOnClickListener {
            alertDialog?.dismiss()
        }

        alertDialog?.show()
    }

    private fun showError() {
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View =
            LayoutInflater.from(this).inflate(R.layout.error_dialog, viewGroup, false)
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog: android.app.AlertDialog? = builder.create()
        alertDialog?.setCancelable(true)

        alertDialog?.show()

    }

    private fun showSuccess() {
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View =
            LayoutInflater.from(this).inflate(R.layout.success_dialog, viewGroup, false)
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog: android.app.AlertDialog? = builder.create()
        alertDialog?.setCancelable(true)

        alertDialog?.show()

    }
}