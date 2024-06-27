package com.example.busschedule.data

import android.content.Context

interface AppContainer {
    val database: ScheduleDatabase
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val database: ScheduleDatabase by lazy { ScheduleDatabase.getDatabase(context) }
}