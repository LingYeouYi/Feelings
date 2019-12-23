package com.example.feelings

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.feeling_records.*

class AddActivity : AppCompatActivity() {

    private var mood: Int = 0 //0 = default, 1 = sad, 2 = neutral, 3 = happy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        buttonSave.setOnClickListener{
            saveUser()
        }

        imageViewHappyMood.setOnClickListener{
            mood = 3
            //it.background = #CCCCCC
        }

        imageViewBadMood.setOnClickListener{
            mood = 1
        }

        imageViewNeutral.setOnClickListener{
            mood = 2
        }

    }

    private fun saveUser(){
        if(TextUtils.isEmpty(editTextRemark.text)){
            editTextRemark.setError("Must enter the value...")
        }

        val remark = editTextRemark.text.toString()

        val intent = Intent()
        intent.putExtra(EXTRA_REMARK, remark)
        intent.putExtra(EXTRA_MOOD, mood)

        setResult(Activity.RESULT_OK, intent)

        finish()
    }

    companion object{
        const val EXTRA_MOOD = "com.example.feelings.MOOD"
        const val EXTRA_REMARK = "com.example.feelings.REMARK"
    }

}
