package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ScheduleItem::class], version = 1, exportSchema = false)
abstract class ScheduleDatabase : RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

    companion object {
        @Volatile
        private var Instance: ScheduleDatabase? = null

        fun getDatabase(context: Context): ScheduleDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ScheduleDatabase::class.java, "app_database")
                    .createFromAsset("database/bus_schedule.db").build().also { Instance = it }
            }
        }
    }
}