package ru.nvg_soft.roomexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event(
    @PrimaryKey(autoGenerate = true)var id:Int?,
    var name:String
)