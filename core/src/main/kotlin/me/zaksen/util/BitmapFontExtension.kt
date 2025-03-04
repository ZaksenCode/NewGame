package me.zaksen.util

import com.badlogic.gdx.graphics.g2d.BitmapFont

/**
 * @return width of string literal
 */
fun BitmapFont.getWidth(literal: CharSequence): Float {
    var result = 0f

    for(char in literal) {
        if (char == ' ') {
            result += spaceXadvance
            continue
        }
        val glyph = data.getGlyph(char)
        result += glyph.xadvance
    }

    return result
}
