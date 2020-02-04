package com.ravimhzn.mynotes.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        var monthNumbers =
            listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12")
        val months = listOf(
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "May",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec"
        )
        var GET_MONTH_ERROR: String = "Error. Invalid month number."
        var DATE_FORMAT: String = "MM-yyyy"

        fun getMonthFromNumber(monthNumber: String): String {
            return when (monthNumber) {
                "01" -> {
                    months[0]
                }
                "02" -> {
                    months[1]
                }
                "03" -> {
                    months[2]
                }
                "04" -> {
                    months[3]
                }
                "05" -> {
                    months[4]
                }
                "06" -> {
                    months[5]
                }
                "07" -> {
                    months[6]
                }
                "08" -> {
                    months[7]
                }
                "09" -> {
                    months[8]
                }
                "10" -> {
                    months[9]
                }
                "11" -> {
                    months[10]
                }
                "12" -> {
                    months[11]
                }
                else -> {
                    GET_MONTH_ERROR
                }
            }
        }

        fun getCurrentTimeStamp(): String {
            val dateFormat =
                SimpleDateFormat(DATE_FORMAT) //MUST USE LOWERCASE 'y'. API 23- can't use uppercase

            return dateFormat.format(Date()) // Find todays date
        }
    }
}