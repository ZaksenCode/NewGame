package me.zaksen.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.ScreenUtils
import me.zaksen.NewGame
import me.zaksen.draw.FontDrawer
import me.zaksen.ui.LabelButton

class MenuScreen(
    private val game: NewGame,
    private val assetManager: AssetManager,
    private val batch: SpriteBatch
): ScreenAdapter() {


    private val fontDrawer = FontDrawer(assetManager, "monocraft.ttc")

    private val stage by lazy {
        val stage = Stage()
        Gdx.input.inputProcessor = stage
        stage.addActor(table)
        stage
    }
    private val table by lazy {
        val table = Table()
        table.setFillParent(true)
        table.clip = true
        table.debug = false // Display debug lines

        // Add Widgets to table
        val labelStyle = LabelStyle()
        labelStyle.font = fontDrawer.font
        table.add(Label("New game", labelStyle)).height(60f)

        table.row()

        val buttonStyle = TextButtonStyle()
        buttonStyle.font = fontDrawer.font
        table.add(LabelButton("Play", buttonStyle) { _, _, _ ->
            // TODO - Go to game screen
        }).height(30f)
        table.row()
        table.add(LabelButton("Settings", buttonStyle) { _, _, _ ->
            // TODO - Go to settings screen
        }).height(30f)
        table.row()
        table.add(LabelButton("Quit", buttonStyle) { _, _, _ ->
            Gdx.app.exit()
        }).height(30f)

        // Return table
        table
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true);
    }

    override fun render(delta: Float) {
        super.render(delta)
        draw()
        input()
    }

    private fun draw() {
        ScreenUtils.clear(Color.DARK_GRAY)

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.deltaTime);
        stage.draw();
    }

    private fun input() {

    }

    override fun dispose() {
        stage.dispose();
    }
}
