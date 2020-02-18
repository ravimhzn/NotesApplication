package com.ravimhzn.mynotes.utils

import com.ravimhzn.mynotes.utils.DateUtils.Companion.getMonthFromNumber
import com.ravimhzn.mynotes.utils.DateUtils.Companion.monthNumbers
import com.ravimhzn.mynotes.utils.DateUtils.Companion.months
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.TestReporter
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DateUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
    internal fun getMonthFromNumber_returnSuccess(
        m: Int,
        testInfo: TestInfo,
        testReporter: TestReporter
    ) {
        assertEquals(months[m], getMonthFromNumber(monthNumbers[m]))
        println("Success")
        println("${monthNumbers[m]} : ${months[m]}")
    }
}