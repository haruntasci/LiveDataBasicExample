package com.haruntasci.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {

            tv_textView.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {

            tv_booleanText.text = it.toString()
        })

        viewModel.currentString.observe(this, Observer{
                tv_stringText.text = it
            }
        )



        incrementText()


    }

    private fun incrementText() {
        btn_button.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
            viewModel.currentString.value = viewModel.number.toString()
        }
    }

}