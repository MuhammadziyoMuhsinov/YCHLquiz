package com.fenix.ychlquiz

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.fenix.ychlquiz.databinding.FragmentQuestionBinding
import com.fenix.ychlquiz.databinding.ItemDialogBinding
import com.fenix.ychlquiz.models.Mydata
import com.fenix.ychlquiz.models.Question
import kotlinx.coroutines.flow.combine


class FragmentQuestion : Fragment() {

    private lateinit var list: ArrayList<Question>
    private var position = 0
    var has = false
    private lateinit var listviews: ArrayList<View>
    private lateinit var binding: FragmentQuestionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentQuestionBinding.inflate(layoutInflater)
        list = ArrayList()
        Mydata.correct = 0
        Mydata.wrong = 0
        listviews = ArrayList()

        listviews.add(binding.answer1contratint)
        listviews.add(binding.answer2contratint)
        listviews.add(binding.answer3contratint)
        listviews.add(binding.answer4contratint)

        loadList()
        loadQuestion()

        binding.answer1.setOnClickListener {
            chekQuestion(1)
        }
        binding.answer2.setOnClickListener {
            chekQuestion(2)
        }
        binding.answer3.setOnClickListener {
            chekQuestion(3)
        }
        binding.answer4.setOnClickListener {
            chekQuestion(4)
        }
        binding.btnNext.setOnClickListener {
            if (has) {
                loadQuestion()
                has = false
            } else {
                Toast.makeText(binding.root.context, "Javobni belgilang!", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        return binding.root
    }

    private fun loadQuestion() {
        binding.txtQuestion.text = list[position].question
        binding.txtAnswer1.text = list[position].answer1
        binding.txtAnswer2.text = list[position].answer2
        binding.txtAnswer3.text = list[position].answer3
        binding.txtAnswer4.text = list[position].answer4

        binding.answer1contratint.setBackgroundColor(Color.WHITE)
        binding.answer2contratint.setBackgroundColor(Color.WHITE)
        binding.answer3contratint.setBackgroundColor(Color.WHITE)
        binding.answer4contratint.setBackgroundColor(Color.WHITE)
    }

    private fun loadList() {
        list.add(Question("How many teams are there in the group stage of the Champions League?",
            "28",
            "32",
            "48",
            "50",
            2
        ))
        list.add(Question("What's the maximum number of teams that a country's national league can send to the Champion's League?",
            "two",
            "three",
            "four",
            "five",
            4
        ))
        list.add(Question("How many seasons are used to factor a country's ranking?",
            "five",
            "six",
            "seven",
            "eight",
            1
        ))
        list.add(Question("What is the fastest own goal in Champions League history?",
            "7.10 minutes",
            "4.20 minutes",
            "2.9 minutes",
            "2 minutes",
            3
        ))
        list.add(Question("When does the Champions League tournament begin?",
            "May",
            "June",
            "July",
            "August",
            3
        ))
        list.add(Question("Which club holds the record for the most Champions League defeats?",
            "Inter",
            "Porto",
            "Milan",
            "Juventus",
            2
        ))
        list.add(Question("What is the most common final score of Champions League matches?",
            "1 to 1",
            "1 to 0",
            "2 to 0",
            "3 to 0",
            1
        ))
        list.add(Question("How many goals did Raul score during his Champions League career?",
            "71",
            "75",
            "81",
            "85",
            1
        ))
        list.add(Question("How many times has Real Madrid won the tournament?",
            "ten",
            "nine",
            "eight",
            "seven",
            1
        ))
        list.add(Question("Which team has the most consecutive appearances in the quarterfinals?",
            "R.Madrid",
            "Barcelona",
            "Milan",
            "PSG",
            2
        ))


    }

    private fun chekQuestion(answer: Int) {
        if (!has) {
            if (answer == list[position].correctAnswer) {
                Mydata.correct += 1
                listviews[answer - 1].setBackgroundColor(Color.GREEN)

            } else {
                listviews[list[position].correctAnswer!! - 1].setBackgroundColor(Color.GREEN)
                listviews[answer - 1].setBackgroundColor(Color.RED)
                Mydata.wrong += 1
            }

            if (position == list.size - 1) {
                finish()
            } else {
                position += 1
            }
            has = true

        } else {

        }


    }


    private fun finish() {
        val alertDialog = AlertDialog.Builder(binding.root.context, R.style.NewDialog).create()
        val itemDialogBinding = ItemDialogBinding.inflate(layoutInflater)
        itemDialogBinding.img.setImageResource(R.drawable.background1)
        itemDialogBinding.txtCorrect.text = "correct: ${Mydata.correct}"
        itemDialogBinding.txtWrong.text = "wrong: ${Mydata.wrong}"
        itemDialogBinding.txtOk.setOnClickListener {
            alertDialog.cancel()
        }
        alertDialog.setView(itemDialogBinding.root)
        alertDialog.show()
        binding.xira.visibility = View.VISIBLE
        alertDialog.setOnDismissListener {
            findNavController().popBackStack()

        }
    }


}