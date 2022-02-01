package com.example.newsapp

import androidx.room.TypeConverter
import java.time.Instant

class Converters {

    companion object {
        @TypeConverter
        @JvmStatic
        fun fromInstant(value: Instant): Long {
            return value.toEpochMilli()
        }

        @TypeConverter
        @JvmStatic
        fun toInstant(value: Long): Instant {
            return Instant.ofEpochMilli(value)
        }
    }

}