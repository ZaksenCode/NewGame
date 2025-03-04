package me.zaksen.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
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
        ScreenUtils.clear(Color.DARK_GRAY)

        assetManager.get("monocraft.ttc", BitmapFont::class.java).draw(
            batch,
            "New game!",
            Gdx.app.graphics.width / 2f,
            Gdx.app.graphics.height / 2f
        )
    }

    private fun input() {

    }
}
