package com.example.spider

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.example.spider.PlayActivity as PlayActivity1




class StatisticFragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_statistic, container, false)
        val questions = listOf<Question>(
            Question(resources.getString(R.string.question1), listOf(resources.getString(R.string.q1option1),
                resources.getString(R.string.q1option2),resources.getString(R.string.q1option3),
                resources.getString(R.string.q1option4),resources.getString(R.string.q1option5))
            ),
            Question(resources.getString(R.string.question2), listOf(resources.getString(R.string.q2option1),
                resources.getString(R.string.q2option2),resources.getString(R.string.q2option3),
                resources.getString(R.string.q2option4), null) as List<String>
            ),
            Question(resources.getString(R.string.question3), listOf(resources.getString(R.string.q3option1),
                resources.getString(R.string.q3option2),null,null,null) as List<String>
            ),
            Question(resources.getString(R.string.question4), listOf(resources.getString(R.string.q4option1),
                resources.getString(R.string.q4option2),resources.getString(R.string.q4option3),
                resources.getString(R.string.q4option4),resources.getString(R.string.q4option5))
            ),
            Question(resources.getString(R.string.question5), listOf(resources.getString(R.string.q5option1),
                resources.getString(R.string.q5option2),resources.getString(R.string.q5option3),
                resources.getString(R.string.q5option4),resources.getString(R.string.q5option5)) as List<String>
            ),
            Question(resources.getString(R.string.question6), listOf(resources.getString(R.string.q6option1),
                resources.getString(R.string.q6option2),null,null,null) as List<String>
            ),
            Question(resources.getString(R.string.question7), listOf(resources.getString(R.string.q7option1),
                resources.getString(R.string.q7option2),resources.getString(R.string.q7option3),
                resources.getString(R.string.q7option4),null) as List<String>
            ),
            Question(resources.getString(R.string.question8), listOf(resources.getString(R.string.q8option1),
                resources.getString(R.string.q8option2),resources.getString(R.string.q8option3),
                resources.getString(R.string.q8option4), null) as List<String>
            ),
            Question(resources.getString(R.string.question9), listOf(resources.getString(R.string.q9option1),
                resources.getString(R.string.q3option2),resources.getString(R.string.q9option3),
                resources.getString(R.string.q9option4),resources.getString(R.string.q9option5))
            ),
            Question(resources.getString(R.string.question10), listOf(resources.getString(R.string.q10option1),
                resources.getString(R.string.q10option2),resources.getString(R.string.q10option3),null,null) as List<String>
            )
            )

        val questionsRecyclerView : RecyclerView = view.findViewById(R.id.question_recycle_view)
        questionsRecyclerView.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL, false)
        questionsRecyclerView.adapter = QuestionAdapter(questions)



        return view
    }
}


