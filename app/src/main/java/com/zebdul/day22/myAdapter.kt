package com.zebdul.day22

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class myAdapter (private val context: Activity, private val arrayList:ArrayList<User>)
    :ArrayAdapter<User>(    context, R.layout.each_item, arrayList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        //get view of each_item.xml and inflate layout from main activity
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.each_item, null)

        //set value of each parameter
        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.name)
        val lastMessage = view.findViewById<TextView>(R.id.lastMessage)
        val lastMessageTime = view.findViewById<TextView>(R.id.LastMessageTime)

        name.text = arrayList[position].name
        lastMessage.text = arrayList[position].lastMessage
        lastMessageTime.text = arrayList[position].lastMessageTime
        image.setImageResource(arrayList[position].imageId)


        return view
    }

}
