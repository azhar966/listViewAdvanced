package com.zebdul.day22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.zebdul.day22.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding:ActivityMainBinding
    lateinit var userArrayList:ArrayList<User>  //initialize our user class in variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //use viewBinding to save time
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initialize all varibles with array and give data
        val name = arrayOf("Cristiano Ronaldo", "Robert Downey Jr.", "Taylor Swift",
            "Dwayne Johnson", "Shah Rukh Khan")
        val lastMessage = arrayOf("Hey Whats Up", "Call Me Now", "cant impliment Day21",
            "plan for this weekend", "doubt on Digital")
        val lastMessageTime = arrayOf("04:56 AM", "05:45 AM", "07:89 PM", "01:89 PM", "03:87 AM")
        val phoneNumber = arrayOf("123456789", "234567891", "345678912", "456789123", "567891234")
        val imageId = intArrayOf(R.drawable.pick1,R.drawable.pick2,R.drawable.pick3,
            R.drawable.pick4,R.drawable.pick5)

//        initialize user arrayList
        userArrayList = ArrayList()

        //implement a for loop in name for take all arrays of name variable and give it on User.kt
        for(eachIndex in name.indices){     //find i in name.indices
//            create a var using User.kt and implement value in all parameters of user.kt
            val user = User(name[eachIndex], lastMessage[eachIndex], lastMessageTime[eachIndex]
            , phoneNumber[eachIndex], imageId[eachIndex])

            userArrayList.add(user) //add data for each user
        }
        //build an adapter
        binding.listView.isClickable = true
        binding.listView.adapter = myAdapter(this, userArrayList )

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            //open a new activity
            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imageId[position]

            val i = Intent(this, UserActivity::class.java)

            i.putExtra("name",userName)
            i.putExtra("phone",userPhone)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }
    }
}