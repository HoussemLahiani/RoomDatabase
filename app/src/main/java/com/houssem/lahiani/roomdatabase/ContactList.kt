package com.houssem.lahiani.roomdatabase

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.TextView

class ContactList : AppCompatActivity() {

    var main: MainActivity?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        val ls : ListView = findViewById(R.id.lst)


        main= MainActivity()

        Thread{

            main!!.accessDatabase()

            var cursor : Cursor? = main!!.contactDAO?.getAllContacts()


            runOnUiThread {

                var adapter : SimpleCursorAdapter = SimpleCursorAdapter(

                    this,
                    R.layout.item,
                    cursor,
                    arrayOf(cursor?.getColumnName(0),
                    cursor?.getColumnName(1),
                    cursor?.getColumnName(2) ),
                    intArrayOf(R.id.id,R.id.name,R.id.phone),
                    1
                )

                ls.setAdapter(adapter)
                ls.setOnItemClickListener{parent,view,position,l
                    ->
                   var t : TextView = view.findViewById(R.id.id)

                    var intent = Intent(this, DetailActivity::class.java)

                    intent.putExtra("id",t.getText().toString())

                    startActivity(intent)






                }



            }





        }.start()






    }
}