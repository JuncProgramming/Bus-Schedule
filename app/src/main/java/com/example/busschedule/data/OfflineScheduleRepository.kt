package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

class OfflineScheduleRepository(private val scheduleDao: ScheduleDao) : ScheduleRepository {
    override fun getScheduleItemByStopName(stopName: String): Flow<List<ScheduleItem>> = scheduleDao.getScheduleItemByStopName(stopName)

    override fun getAllScheduleItems(): Flow<List<ScheduleItem>> = scheduleDao.getAllScheduleItems()
}