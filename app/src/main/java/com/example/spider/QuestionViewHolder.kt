package com.example.spider

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.contentValuesOf
import androidx.core.view.isNotEmpty
import androidx.core.view.isVisible
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView

class QuestionViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun bind(question: Question){
        val questionTextView : TextView = itemView.findViewById(R.id.tv_question)
        val radioButton1 : RadioButton = itemView.findViewById(R.id.radio_button1)
        val radioButton2 : RadioButton = itemView.findViewById(R.id.radio_button2)
        val radioButton3 : RadioButton = itemView.findViewById(R.id.radio_button3)
        val radioButton4 : RadioButton = itemView.findViewById(R.id.radio_button4)
        val radioButton5 : RadioButton = itemView.findViewById(R.id.radio_button5)
        questionTextView.text = question.question
        radioButton1.text = question.optionList[0]
        radioButton2.text = question.optionList[1]
        if(question.optionList[2] == null)
            radioButton3.visibility = View.GONE
        else radioButton3.text = question.optionList[2]
        if(question.optionList[3] == null)
            radioButton4.visibility = View.GONE
        else radioButton4.text = question.optionList[3]
        if(question.optionList[4] == null)
            radioButton5.visibility = View.GONE
        else radioButton5.text = question.optionList[4]

//        val selectTextView : TextView = itemView.findViewById(R.id.result_text_view)!!
//        val radioGroup: RadioGroup = itemView.findViewById(R.id.radio_group)
//        radioGroup.setOnCheckedChangeListener { group, checkedId ->
//            when {
//                radioButton1.isChecked -> selectTextView.text = radioButton1.toString()
//                radioButton2.isChecked -> selectTextView.text = radioButton2.toString()
//                radioButton3.isChecked -> selectTextView.text = radioButton3.toString()
//                radioButton4.isChecked -> selectTextView.text = radioButton4.toString()
//                else -> (radioButton5.isChecked)
//            }
//            selectTextView.text = radioButton5.toString()
//
//        }
//
        val rightAnswers = listOf<String>(
            itemView.resources.getString(R.string.q1option5),
            itemView.resources.getString(R.string.q2option3),
            itemView.resources.getString(R.string.q3option2),
            itemView.resources.getString(R.string.q4option2),
            itemView.resources.getString(R.string.q5option5),
            itemView.resources.getString(R.string.q6option2),
            itemView.resources.getString(R.string.q7option4),
            itemView.resources.getString(R.string.q8option3),
            itemView.resources.getString(R.string.q9option1),
            itemView.resources.getString(R.string.q10option3)
        )
        val questionCardView : CardView = itemView.findViewById(R.id.card_view_question)
        val resultButton : Button = itemView.findViewById(R.id.button_result)
        val radioGroup : RadioGroup = itemView.findViewById(R.id.radio_group)

        var rightAnswersCount : Int = 0
        //val resultTextView : TextView = itemView.findViewById(R.id.result_text_view)

        var indexRightAnswer : Int = 0
       // val intentResultFragment = Intent(itemView, ResultFragment::class.java)


            resultButton.setOnClickListener {
                val checkedRadioButtonId = radioGroup.checkedRadioButtonId
                when(checkedRadioButtonId){
                    -1 -> {
                        resultButton.text = "Ответ не выбран"
                    }
                    else -> {
                        val selectedRadioButton = itemView.findViewById<RadioButton>(checkedRadioButtonId)
                        if (selectedRadioButton.text == rightAnswers[indexRightAnswer]){
                            rightAnswersCount++
                            indexRightAnswer++
                        }
                    }
                }
        }
        resultButton.text = rightAnswersCount.toString() + "in 10"


    }

}