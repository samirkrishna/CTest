package com.has.sam.cej.ctest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.firebase.client.DataSnapshot
import com.firebase.client.Firebase
import com.firebase.client.FirebaseError
import com.firebase.client.ValueEventListener

class MainActivity : AppCompatActivity() {

   private var name:TextView?=null
   private var mRef: Firebase?=null
    var iview:ImageView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name=findViewById(R.id.name)
        iview=findViewById(R.id.iview)
        mRef= Firebase("https://fir-test-1b74d.firebaseio.com/User")

        mRef?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot?) {

              var value= p0?.child("Name")!!.getValue().toString()
                name?.setText(value)
                var url = p0!!.child("Image").getValue().toString()

                Glide.with(this@MainActivity).
                        load(url).into(iview!!)
            }

            override fun onCancelled(p0: FirebaseError?) {

            }
        })


    }
}
