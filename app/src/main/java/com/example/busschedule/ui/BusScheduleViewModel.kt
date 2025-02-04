/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.busschedule.ScheduleApplication
import com.example.busschedule.data.ScheduleDao
import com.example.busschedule.data.ScheduleItem
import kotlinx.coroutines.flow.Flow

class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {

    // Get example bus schedule
    fun getFullSchedule(): Flow<List<ScheduleItem>> = scheduleDao.getAllScheduleItems()

    // Get example bus schedule by stop
    fun getScheduleFor(stopName: String): Flow<List<ScheduleItem>> = scheduleDao.getScheduleItemByStopName(stopName)

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[AndroidViewModelFactory.APPLICATION_KEY] as ScheduleApplication)
                BusScheduleViewModel(application.container.database.scheduleDao())
            }
        }
    }
}