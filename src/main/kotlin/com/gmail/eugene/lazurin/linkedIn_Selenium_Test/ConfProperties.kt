package com.gmail.eugene.lazurin.linkedIn_Selenium_Test

import java.io.FileInputStream
import java.io.IOException
import java.util.*

object ConfProperties {
    private var fileInputStream: FileInputStream? = null
    private var PROPERTIES: Properties? = null
    fun getProperty(key: String?): String {
        return PROPERTIES!!.getProperty(key)
    }

    init {
        try {
            fileInputStream = FileInputStream("src/test/kotlin/conf.properties")
            PROPERTIES = Properties()
            PROPERTIES!!.load(fileInputStream)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (fileInputStream != null) try {
                fileInputStream!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}