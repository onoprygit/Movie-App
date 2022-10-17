package com.onopry.movieapp

import android.icu.text.SimpleDateFormat
import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDate

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val stringDate = "1993-10-09"
        val expectedDate = LocalDate.of(1993, 10, 9)
        val resultDate = LocalDate.parse(stringDate)


        assertEquals(expectedDate, resultDate)
    }
}