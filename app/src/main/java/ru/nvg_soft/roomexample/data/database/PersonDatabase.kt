package ru.nvg_soft.roomexample.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.nvg_soft.roomexample.data.Person

@Database(entities = [Person::class], version = 1)
abstract class PersonDatabase: RoomDatabase() {
    abstract fun personDao(): Dao

    companion object {
        @Volatile
        private var instance: PersonDatabase? = null

        fun getInstance(context: Context): PersonDatabase? {
            if (instance == null) {
                synchronized(PersonDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PersonDatabase::class.java, "person_database"
                    )
                        .fallbackToDestructiveMigration()
                        //.addCallback(roomCallback)
                        .allowMainThreadQueries() //все будет в Ui потоке НИКОГДА ТАК НЕ ДЕЛАТЬ!!!
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

    }
}