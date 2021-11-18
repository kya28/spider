package com.example.spider

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView


class QuestionAdapter(private val questionList: List<Question>) :
    RecyclerView.Adapter<QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val questionItemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.question_list_item, parent, false)
        return QuestionViewHolder(questionItemView)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questionList[position]
        holder.bind(question)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }




}