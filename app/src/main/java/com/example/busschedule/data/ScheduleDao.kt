package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    @Query("SELECT * from schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getScheduleItemByStopName(stopName: String): Flow<List<ScheduleItem>>

    @Query("SELECT * from schedule ORDER BY arrival_time ASC")
    fun getAllScheduleItems(): Flow<List<ScheduleItem>>
}