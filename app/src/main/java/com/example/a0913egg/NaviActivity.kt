package com.example.a0913egg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.a0913egg.databinding.ActivityNaviBinding

private const val TAG_CALENDER = "calender_fragment"
private const val TAG_TIMETABLE = "timetable_fragment"
private const val TAG_MYPAGE = "mypage_fragment"

class NaviActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navi)

        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setFragment(TAG_TIMETABLE, TimetableFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
                R.id.timetableFragment -> setFragment(TAG_TIMETABLE, TimetableFragment())
                R.id.mypageFragment-> setFragment(TAG_MYPAGE, MypageFragment())
            }
            true
        }

    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val calender = manager.findFragmentByTag(TAG_CALENDER)
        val timetable = manager.findFragmentByTag(TAG_TIMETABLE)
        val myPage = manager.findFragmentByTag(TAG_MYPAGE)

        if (calender != null){
            fragTransaction.hide(calender)
        }

        if (timetable != null){
            fragTransaction.hide(timetable)
        }

        if (myPage != null) {
            fragTransaction.hide(myPage)
        }

        if (tag == TAG_CALENDER) {
            if (calender!=null){
                fragTransaction.show(calender)
            }
        }
        else if (tag == TAG_TIMETABLE) {
            if (timetable != null) {
                fragTransaction.show(timetable)
            }
        }

        else if (tag == TAG_MYPAGE){
            if (myPage != null){
                fragTransaction.show(myPage)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }

}