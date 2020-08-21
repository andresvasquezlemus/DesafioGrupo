package com.example.desafiogrupo.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class CheckRoomDataBase {

    // Annotates class to be a Room Database with a table (entity) of the
    //Check class
    @Database(entities = [Check::class], version = 1)
    abstract class CheckRoomDataBase : RoomDatabase() {
        abstract fun checkDao (): CheckDao
        companion object {
// Singleton prevents multiple instances of database opening at the // same time.
            @Volatile
            private var INSTANCE: CheckRoomDataBase? = null
            fun getDatabase (context: Context): CheckRoomDataBase {
                val tempInstance = INSTANCE
                if (tempInstance != null ) {
                    return tempInstance
                }
                synchronized( this ) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        CheckRoomDataBase:: class . java ,
                        "check_database"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}