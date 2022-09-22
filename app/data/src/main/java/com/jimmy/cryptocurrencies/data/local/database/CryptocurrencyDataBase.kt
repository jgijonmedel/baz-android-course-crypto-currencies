package com.jimmy.cryptocurrencies.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [], version = 1, exportSchema = false)
internal abstract class CryptocurrencyDataBase : RoomDatabase() {

    companion object {
        private var dataBase: CryptocurrencyDataBase? = null
        private const val DATABASE_NAME = "cryptocurrency_database"

        fun getDatabase(context: Context): CryptocurrencyDataBase {
            if (dataBase == null) {
                dataBase =
                    Room.databaseBuilder(context, CryptocurrencyDataBase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return dataBase!!
        }
    }

}