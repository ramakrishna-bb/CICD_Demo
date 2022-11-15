package com.learn.cicddemo.utils

import org.junit.Assert
import org.junit.Test

class DateUtilsTest {
    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }

    // this utility function used to convert the date string passed in the format MM/dd/yyyy [02/15/2021] to yyyy-MM-dd [2021-02-15]
    @Test
    fun convertToServiceDate_isCorrect() {
        val inputDate = "02/15/2021"
        val expectedOutputDate = "2021-02-15"
        val result = DateUtils.convertToServiceDate(inputDate);
        Assert.assertEquals(expectedOutputDate, result)
    }
}