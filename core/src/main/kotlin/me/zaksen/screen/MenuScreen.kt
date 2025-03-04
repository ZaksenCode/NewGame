package me.zaksen.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import me.zaksen.NewGame
import me.zaksen.draw.FontDrawer

class MenuScreen(
    private val game: NewGame,
    private val assetManager: AssetManager,
    private val batch: SpriteBatch
): ScreenAdapter() {

    private val fontDrawer = FontDrawer(assetManager, "monocraft.ttc")

    override fun render(delta: Float) {
        draw()
        input()
    }

    private fun draw() {
        ScreenUtils.clear(Color.DARK_GRAY)

        fontDrawer.draw(batch, "Example large message!", 0f, Gdx.app.graphics.height - 50f)
        fontDrawer.draw(batch, "Example large message!", fontDrawer.getWidth("Example large message!"), Gdx.app.graphics.height - 50f)
    }

    private fun input() {

    }
}
