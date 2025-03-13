package me.zaksen

import com.badlogic.gdx.Game
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
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ExtendViewport
import me.zaksen.screen.LoadingScreen

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
class NewGame : Game() {
    private val assetManager by lazy { AssetManager() }
    private val batch by lazy { SpriteBatch() }
    private val camera by lazy { OrthographicCamera() }
    private val viewport by lazy {
        val view = ExtendViewport(640f, 480f, camera)
        view.setScaling(Scaling.contain)
        view
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
        super.resize(width, height)
        viewport.update(width, height, true)
    }

    override fun render() {
        viewport.apply()
        batch.projectionMatrix = viewport.camera.combined
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
