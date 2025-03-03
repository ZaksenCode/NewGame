package me.zaksen

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.FileHandleResolver
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.FreeTypeFontLoaderParameter
import com.badlogic.gdx.utils.viewport.FitViewport
import me.zaksen.screen.LoadingScreen


/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
class NewGame : Game() {
    private val assetManager by lazy { AssetManager() }
    private val batch by lazy { SpriteBatch() }
    private val camera by lazy { OrthographicCamera() }
    private val viewport by lazy {
        FitViewport(Gdx.app.graphics.width.toFloat(), Gdx.app.graphics.height.toFloat(), camera)
    }

    override fun create() {
        val resolver: FileHandleResolver = InternalFileHandleResolver()
        assetManager.setLoader(FreeTypeFontGenerator::class.java, FreeTypeFontGeneratorLoader(resolver))
        assetManager.setLoader(BitmapFont::class.java, ".ttc", FreetypeFontLoader(resolver))

        val sizeParams = FreeTypeFontLoaderParameter()
        sizeParams.fontFileName = "fonts/monocraft.ttc"
        sizeParams.fontParameters.size = 14
        assetManager.load("monocraft.ttc", BitmapFont::class.java, sizeParams)

        setScreen(LoadingScreen(this, assetManager, batch))
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
        super.resize(width, height)
    }

    override fun render() {
        batch.begin()
        super.render()
        batch.end()
    }

    override fun dispose() {
        super.dispose()
        assetManager.dispose()
        batch.dispose()
    }
}
