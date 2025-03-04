package me.zaksen.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import me.zaksen.NewGame

class LoadingScreen(
    private val game: NewGame,
    private val assetManager: AssetManager,
    private val batch: SpriteBatch
): ScreenAdapter() {
    override fun dispose() {

    }

    override fun show() {

    }

    override fun render(delta: Float) {
        if(assetManager.update()) {
            game.screen = MenuScreen(game, assetManager, batch)
        }

        ScreenUtils.clear(Color.DARK_GRAY)

        val progress: Float = assetManager.progress
        if(assetManager.isLoaded("monocraft.ttc")) {
            assetManager.get("monocraft.ttc", BitmapFont::class.java).draw(
                batch,
                "Loading assets: ${progress * 100}%",
                Gdx.app.graphics.width / 2f - 21 * 4,
                Gdx.app.graphics.height / 2f
            )
        }
    }

    override fun resize(p0: Int, p1: Int) {

    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun hide() {

    }
}
