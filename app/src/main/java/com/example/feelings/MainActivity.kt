package com.example.feelings

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var feelingViewModel: FeelingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create instance of RecycleView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        //create imstance of Adapter
        val adapter = FeelingAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.adapter = LinearLayoutManager(this)

        //Initialize ViewModel
        feelingViewModel = ViewModelProvider(this).get(FeelingViewModel::class.java)

        feelingViewModel.allFeelings.observe(this,
            Observer {
                if(it.isNotEmpty())


            })

        fab.setOnClickListener {
            val intent: Intent = Intent(this,
                AddActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val mode = data?.getIntExtra(AddActivity.EXTRA_MOOD, 0)
                val remark = data?.getStringExtra(AddActivity.EXTRA_REMARK)

                val feeling:Feeling = Feeling(id=0, mood = _mode!!, remarkd = _remark!!, created_at = System.currentTimeMillis())
                //Insert record into Database
                feelingViewModel.insertFeeling(feeling)
            }
        }
    }

    companion object{
        val REQUEST_CODE = 1
    }

}
