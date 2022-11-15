package com.learn.cicddemo.utils

import android.text.format.DateUtils
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        // this utility function used to convert the date string passed in the format MM/dd/yyyy [02/15/2021] to yyyy-MM-dd [2021-02-15]
        fun convertToServiceDate(dateString: String?): String {
            var convertedDate = ""
            if (dateString.isNullOrEmpty())
                return convertedDate
            return try {
                val conversionPattern = "yyyy-MM-dd"
                val simpleDateFormat = SimpleDateFormat(conversionPattern, Locale.US)
                val inputPattern = "MM/dd/yyyy"
                val inputSimpleDateFormat = SimpleDateFormat(inputPattern, Locale.US)
                convertedDate =
                    inputSimpleDateFormat.parse(dateString)?.let { simpleDateFormat.format(it) }
                        .toString()
                println(convertedDate)
                convertedDate
            } catch (e: ParseException) {
                convertedDate
            }
        }

        // this function is used to convert the one date to another. source and destination format passed as the parameter.
        @Throws(ParseException::class)
        fun formatDate(
            inputDate: String?,
            initDateFormat: String?,
            endDateFormat: String?
        ): String? {
            val originalFormat: DateFormat = SimpleDateFormat(initDateFormat, Locale.US)
            val targetFormat: DateFormat = SimpleDateFormat(endDateFormat, Locale.US)
            val date: Date = originalFormat.parse(inputDate) as Date
            return targetFormat.format(date)
        }

        fun formatDate(dateString: String): String {
            var convertedDate = ""
            if (dateString.isEmpty()) {
                return convertedDate
            }
            return try {
                val conversionPattern = "yyyy-MM-dd"
                val simpleDateFormat = SimpleDateFormat(conversionPattern, Locale.US)
                val inputPattern = "MM/dd/yyyy"
                val inputSimpleDateFormat = SimpleDateFormat(inputPattern, Locale.US)
                convertedDate =
                    inputSimpleDateFormat.parse(dateString)?.let { simpleDateFormat.format(it) }
                        .toString()
                println(convertedDate)
                convertedDate
            } catch (e: ParseException) {
                convertedDate
            }
        }

        // this function is used to convert the one date format to another .
        // (ie. input format is "MMMM d, yyyy[July 12, 2007] in to EEEE, MMMM d, yyyy [ Saturday, July, 12, 2007]
        fun convertToDisplayDate(dateString: String?): String {
            if (dateString.isNullOrEmpty())
                return ""
            return try {
                val displayPattern = "EEEE: MMMM dd, yyyy"
                val simpleDateFormat = SimpleDateFormat(displayPattern, Locale.US)
                val inputPattern = "MMMM d, yyyy"
                val inputSimpleDateFormat = SimpleDateFormat(inputPattern, Locale.US)
                val date = simpleDateFormat.format(inputSimpleDateFormat.parse(dateString))
                date
            } catch (e: ParseException) {
                ""
            }
        }

        // this utility will return the given date is todays date or not.(given date is July 02, 2021 format)
        fun isToday(inputStrDate: String): Boolean {
            return try {
                val inputPattern = "MMMM d, yyyy"
                val inputSimpleDateFormat = SimpleDateFormat(inputPattern, Locale.US)
                DateUtils.isToday(inputSimpleDateFormat.parse(inputStrDate).time)
            } catch (e: ParseException) {
                false
            }
        }

        // this utility will return the given date is tomorrow date or not.(given date is July 02, 2021 format)
        fun isTomorrow(inputStrDate: String): Boolean {
            return try {
                val inputPattern = "MMMM d, yyyy"
                val inputSimpleDateFormat = SimpleDateFormat(inputPattern, Locale.US)
                DateUtils.isToday(
                    (inputSimpleDateFormat.parse(inputStrDate)?.time ?: 0) - (24 * 60 * 60 * 1000L)
                )
            } catch (e: ParseException) {
                false
            }
        }

        /*
         * To get the 24 hour format hour value from the input string
         * inputTime should be as "08:30 AM" or "04:30 PM"
         */
        fun getTwentyFourHourFormatTime(inputTime: String): String {
            var formattedTime = ""
            if (inputTime.isNotEmpty()) {
                try {
                    var hoursValue = 0
                    var minutesValue = ""
                    val inputTimeValues = inputTime.split(" ")
                    if (inputTimeValues.isNotEmpty() && inputTimeValues.size == 2) {
                        if (inputTimeValues[0].isNotEmpty() && inputTimeValues[0].split(":")
                                .isNotEmpty()
                        ) {
                            hoursValue = inputTimeValues[0].split(":")[0].toInt()
                            minutesValue = inputTimeValues[0].split(":")[1]
                        }
                        if (inputTimeValues[1].isNotEmpty() && inputTimeValues[1] == "PM" && hoursValue != 12) {
                            hoursValue += 12
                        }
                        formattedTime = "$hoursValue:$minutesValue"
                    }
                } catch (exception: Exception) {
                    return formattedTime
                }
            }
            return formattedTime
        }
    }
}