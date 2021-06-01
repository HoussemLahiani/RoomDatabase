package com.houssem.lahiani.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var appDatabase : AppDatabase ? =null

    var contactDAO : ContactDAO ?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name :EditText = findViewById(R.id.name)
        val phone : EditText = findViewById(R.id.phone)
        val add : Button = findViewById(R.id.add)
        add.setOnClickListener {
            var co= Contact(null,name.getText().toString(),phone.getText().toString())

            Thread{

            accessDatabase()



                contactDAO?.insertContact(co)

                startActivity(Intent(this,ContactList::class.java))


            }.start()



        }




    }


    fun accessDatabase()
    {
        appDatabase = AppDatabase.getAppdataBase(this)

        contactDAO = appDatabase?.contactDAO()


    }

}