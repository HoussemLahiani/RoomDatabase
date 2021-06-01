package com.houssem.lahiani.roomdatabase

import android.database.Cursor
import androidx.room.*


@Dao
interface ContactDAO {


    @Insert
    fun insertContact(contact : Contact)


    @Update
    fun updateContact(Contact : Contact)

    @Delete
    fun deleteContact(Contact : Contact?)

    @Query("SELECT * FROM Contact")
    fun getAllContacts() : Cursor


    @Query("SELECT * FROM Contact WHERE _id=:id")
    fun getOneContact(id : Int) : Contact



}