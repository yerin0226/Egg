package com.example.a0913egg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a0913egg.databinding.FragmentTimetableBinding
import kotlinx.android.synthetic.main.fragment_timetable.*


class TimetableFragment : Fragment(R.layout.fragment_timetable) {

    private val day = arrayOf("월", "화", "수", "목", "금")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //table.initTable(day)

        arguments?.let {

        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_timetable, container, false)
        //table.initTable(day)



        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TimetableFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}