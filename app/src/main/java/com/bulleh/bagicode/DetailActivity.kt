package com.bulleh.bagicode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.jar.Attributes

class DetailActivity : AppCompatActivity() {

    private lateinit var textviewData: TextView

    companion object {
         const val EXTRA_NAME = "extra_name"
         const val EXTRA_AGE = "extra_age"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textviewData = findViewById(R.id.showDetailData)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val viewText = "My name is $name and iam $age years old"
        textviewData.text = viewText

    }
}