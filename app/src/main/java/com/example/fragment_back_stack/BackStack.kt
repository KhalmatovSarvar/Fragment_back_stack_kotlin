package com.example.fragment_back_stack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragment_back_stack.fragments.PageOneFragment
import com.example.fragment_back_stack.fragments.PageThreeFragment
import com.example.fragment_back_stack.fragments.PageTwoFragment

class BackStack : AppCompatActivity() {
    var TAG = BackStack::class.java.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)
    initViews()
    }

    private fun initViews() {
     var b_first = findViewById<Button>(R.id.btn_1)
        b_first.setOnClickListener{
            replaceFragment(PageOneFragment())
        }
        var b_second = findViewById<Button>(R.id.btn_2)
        b_second.setOnClickListener{
            replaceFragment(PageTwoFragment())
        }
        var b_third = findViewById<Button>(R.id.btn_3)
        b_third.setOnClickListener{
            replaceFragment(PageThreeFragment())
        }

        replaceFragment(PageOneFragment())


    }

    private fun replaceFragment(fragment: Fragment){
        val backStateName = fragment.javaClass.name
        val manager = supportFragmentManager
        val fragmentPopped = manager.popBackStackImmediate(backStateName,0)
        if(!fragmentPopped){
            //fragment not inn backStack, create it.
            val ft = manager.beginTransaction()
            ft.replace(R.id.frameLayout,fragment)
            ft.addToBackStack(backStateName)
            ft.commit()
        }
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 1){
            finish()
        }else{
            super.onBackPressed()
        }
    }
}