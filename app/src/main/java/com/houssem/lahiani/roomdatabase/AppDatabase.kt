package com.houssem.lahiani.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class],version = 1)
abstract class AppDatabase : RoomDatabase()
{

    abstract fun contactDAO (): ContactDAO


    companion object{

        @Volatile private var instance : AppDatabase?=null

        fun getAppdataBase(context : Context) : AppDatabase?
        {
            if(instance==null)
            {

                synchronized(AppDatabase::class)
                {

                    if(instance==null)
                    {

                        instance= Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"contactsManger").build()

                    }


                }





            }



            return  instance

        }






    }








}