package com.padc.padcfirebase.utils

import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Test

class UtilsTest {

    @Test
    fun formatWith959_normalNumber_prefixWith959() {
        val input = "787187298"
        assertThat(formatPhoneNumberWith959(input), `is`("959$input"))
    }

    @Test
    fun formatWith959_09PrefixNumber_prefixWith959Without09() {
        val input = "09787187298"
        assertThat(formatPhoneNumberWith959(input), `is`("959787187298"))
    }

    @Test
    fun formatWith959_959PrefixNumber_noChange() {
        val input = "959787187298"
        assertThat(formatPhoneNumberWith959(input), `is`("959787187298"))
    }

    @Test
    fun formatWith959_empty_null() {
        val input = ""
        assertThat(formatPhoneNumberWith959(input), `is`(nullValue()))
    }

    @Test
    fun formatWith959_characters_null() {
        val input = "Abdsf"
        assertThat(formatPhoneNumberWith959(input), `is`(nullValue()))
    }

    @Test
    fun formatWith959_charactersNumbers_null() {
        val input = "Abdsf839284978"
        assertThat(formatPhoneNumberWith959(input), `is`(nullValue()))
    }


}