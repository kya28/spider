package com.example.spider

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.Transliterator
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"

class PlayActivity  : AppCompatActivity() {

    private lateinit var bottomMenu : BottomNavigationView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        var position : Int = 1

        bottomMenu = findViewById(R.id.bottom_navigation_view)
        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.statistic -> {
                    val statisticFragment = StatisticFragment()
                    replaceFragment(statisticFragment)
                }
                R.id.forward -> {
                    val recyclerViewQuestion : RecyclerView = findViewById(R.id.question_recycle_view)
                    position++
                    recyclerViewQuestion.scrollToPosition(position)
                }
                R.id.menu -> {
                    val menuFragment = MenuFragment()
                    replaceFragment(menuFragment)
                }
                R.id.undo -> {
                    val recyclerViewQuestion : RecyclerView = findViewById(R.id.question_recycle_view)
                    position--
                    recyclerViewQuestion.scrollToPosition(position)
                }
                R.id.settings -> {
                    val settingsFragment = SettingsFragment()
                    replaceFragment(settingsFragment)
                }
            }
            true
        }
        bottomMenu.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.statistic

        val rightAnswers = listOf<String>(
            resources.getString(R.string.q1option5),
            resources.getString(R.string.q2option3),
            resources.getString(R.string.q3option2),
            resources.getString(R.string.q4option2),
            resources.getString(R.string.q5option5),
            resources.getString(R.string.q6option2),
            resources.getString(R.string.q7option4),
            resources.getString(R.string.q8option3),
            resources.getString(R.string.q9option1),
            resources.getString(R.string.q10option3)
        )
//        val questionCardView : CardView = findViewById(R.id.card_view_question)
//        val resultButton : Button = findViewById(R.id.button_result)
//        val radioGroup : RadioGroup = findViewById(R.id.radio_group)
//
//        var rightAnswersCount : Int = 0
//        val resultTextView : TextView = findViewById(R.id.result_text_view)
//
//        var indexRightAnswer : Int = 0
//        val intentResultFragment = Intent(this, ResultFragment::class.java)
//
//
//       // if(questionCardView.isSelected){
//            resultButton.isVisible
//            resultButton.setOnClickListener {
//                val checkedRadioButtonId = radioGroup.checkedRadioButtonId
//                when(checkedRadioButtonId){
//                    -1 -> {
//                        resultTextView.text = "Ответ не выбран"
//                    }
//                    else -> {
//                        val selectedRadioButton = findViewById<RadioButton>(checkedRadioButtonId)
//                        if (selectedRadioButton.text == rightAnswers[indexRightAnswer]){
//                            rightAnswersCount++
//                        }
//                    }
//                }
//                indexRightAnswer++
//                resultTextView.text = rightAnswersCount.toString() + "in 10"
//                startActivity(intentResultFragment)
//
//            //}
//
//        }

    }

    private fun replaceFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }
}