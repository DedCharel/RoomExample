package ru.nvg_soft.roomexample.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey(autoGenerate = true) val personId: Int?,
   val name:String,
    val height: Int,
    val weight: Int,
    val dob: Int

) {
}