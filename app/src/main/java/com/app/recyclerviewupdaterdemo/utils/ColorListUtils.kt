package com.app.recyclerviewupdaterdemo.utils

import android.content.Context
import android.graphics.Color
import androidx.core.graphics.ColorUtils
import com.app.recyclerviewupdaterdemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader

object ColorListUtils {

    private const val TAG = "ColorListUtils"

    suspend fun getColorList(context: Context) = withContext(Dispatchers.IO) {
        val inputStream = context.resources.openRawResource(R.raw.color_list)
        val bufferedReader = BufferedReader(inputStream.reader())
        val list = mutableListOf<Triple<String, String, Int>>()
        val hexRegex = "(#+......)".toRegex()
        val wordRegex = "\"(.*?)\":".toRegex()
        bufferedReader.use { reader ->
            var line = reader.readLine()
            while (line != null) {
                val colorHex = hexRegex.find(line)?.value
                val name = wordRegex.find(line)?.value?.replace("([\":])".toRegex(), "")
                if (colorHex != null && name != null) {
                    val parsed = Color.parseColor(colorHex)

                    list.add(Triple(name, colorHex, generateTextColorByBackgroundColor(parsed)))
                }
                line = reader.readLine()
            }
        }
        list
    }

    fun generateTextColorByBackgroundColor(backgroundColor: Int): Int {
        val isLightColor = ColorUtils.calculateLuminance(backgroundColor) > 0.5f
        return if (isLightColor) Color.BLACK else Color.WHITE
    }


}