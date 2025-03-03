package me.zaksen.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import me.zaksen.NewGame

class MenuScreen(
    private val game: NewGame,
    private val assetManager: AssetManager,
    private val batch: SpriteBatch
): ScreenAdapter() {
    override fun render(delta: Float) {
        draw()
        input()
    }

    private fun draw() {
        assetManager.get("monocraft.ttc", BitmapFont::class.java).draw(
            batch,
            "New game!",
            100f,
            Gdx.app.graphics.height - 100f
        )
    }

    private fun input() {

    }
}
