package com.cachesweeper

import android.widget.Toast
import java.io.File
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

class CacheSweeperModule(private val reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return NAME
    }

    @ReactMethod
    fun clearCache(promise: Promise) {
        try {
            val cache = reactContext.cacheDir
            val appDir = cache.parentFile
            appDir.listFiles()?.forEach { file: File ->
                if (file.name != "lib" && !deleteDir(file)) {
                    promise.reject("Cache Clear Error", "Failed to delete directory: ${file.absolutePath}")
                    return@forEach 
                }
            }
            promise.resolve(null)
            Toast.makeText(reactContext, "Cache cleared successfully!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            promise.reject("Cache Clear Error", e)
            Toast.makeText(reactContext, "Failed to clear cache.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteDir(dir: File?): Boolean {
        dir?.listFiles()?.forEach { file ->
            if (file.isDirectory) {
                if (!deleteDir(file)) {
                    return false
                }
            } else {
                if (!file.delete()) {
                    return false
                }
            }
        }
        return dir?.delete() ?: false
    }

    companion object {
        const val NAME = "CacheSweeper"
    }
}
