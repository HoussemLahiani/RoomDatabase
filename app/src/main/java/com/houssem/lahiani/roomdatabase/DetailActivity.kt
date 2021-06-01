package com.houssem.lahiani.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class DetailActivity : AppCompatActivity() {

    var main : MainActivity?=null

    var id : Int ? =null

    var cont : Contact?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = findViewById<EditText>(R.id.name)

        val phone =findViewById<EditText>(R.id.phone)

        val update =findViewById<Button>(R.id.update)

        val delete=  findViewById<Button>(R.id.delete)

        id= Integer.parseInt(intent?.getStringExtra("id"))

        main= MainActivity()

        Thread{

            main?.accessDatabase()
            cont= main?.contactDAO?.getOneContact(id!!)




            name.setText(cont?.name)
            phone.setText(cont?.phone)




        }.start()



        update.setOnClickListener {


            var c= Contact(id,name.getText().toString(),phone.getText().toString())

            Thread{

                main?.accessDatabase()
                main?.contactDAO?.updateContact(c)


                startActivity(Intent(this,ContactList::class.java))


            }.start()









        }




        delete.setOnClickListener {

            Thread{


                main?.accessDatabase()

                main!!.contactDAO?.deleteContact(cont)
                startActivity(Intent(this,ContactList::class.java))




            }.start()




        }




    }
}