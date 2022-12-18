package com.doubleclick.sqlitekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform