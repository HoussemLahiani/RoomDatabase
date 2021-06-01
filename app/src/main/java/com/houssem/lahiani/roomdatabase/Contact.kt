package com.houssem.lahiani.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity
class Contact(


    @PrimaryKey(autoGenerate = true)
    @NotNull
    var _id: Int?,

    @ColumnInfo(name="name_contact")
    var name: String,

    @ColumnInfo(name="phone_contact")
    var phone: String



    )