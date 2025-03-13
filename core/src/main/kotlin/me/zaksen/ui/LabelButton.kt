package me.zaksen.ui

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import me.zaksen.util.TriConsumer

class LabelButton(
    text: String,
    style: TextButtonStyle,
    action: TriConsumer<InputEvent?, Float, Float>
): TextButton(text, style) {

    init {
        this.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                action.accept(event, x, y)
            }
        })
    }
}
