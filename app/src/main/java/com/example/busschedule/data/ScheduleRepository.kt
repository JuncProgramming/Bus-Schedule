package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {
    fun getScheduleItemByStopName(stopName: String): Flow<List<ScheduleItem>>

    fun getAllScheduleItems(): Flow<List<ScheduleItem>>
}