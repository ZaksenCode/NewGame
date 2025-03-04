package me.zaksen.draw

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.BitmapFont
import me.zaksen.util.getWidth

class FontDrawer(
    private val assetManager: AssetManager,
    private val fontName: String
) {
    val font: BitmapFont by lazy {
        assetManager.get(fontName, BitmapFont::class.java)
    }

    fun draw(batch: Batch, literal: CharSequence, x: Float, y: Float) {
        font.draw(batch, literal, x, y)
    }

    fun draw(batch: Batch, literal: CharSequence, x: Int, y: Int) {
        draw(batch, literal, x.toFloat(), y.toFloat())
    }

    fun getWidth(literal: CharSequence): Float {
        return font.getWidth(literal)
    }
}
