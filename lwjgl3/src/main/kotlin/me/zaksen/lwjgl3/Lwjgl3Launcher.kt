@file:JvmName("Lwjgl3Launcher")

package me.zaksen.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import me.zaksen.NewGame

/** Launches the desktop (LWJGL3) application. */
fun main() {
    // This handles macOS support and helps on Windows.
    if (StartupHelper.startNewJvmIfRequired())
      return
    Lwjgl3Application(NewGame(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("NewGame")
        setMaximized(true)
        setResizable(true)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
