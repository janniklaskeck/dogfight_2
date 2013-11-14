package com.solusgames.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.solusgames.controls.Controls;

public class MainMenuScreen implements Screen {

    Skin skin;
    Stage stage;

    Game g;

    public MainMenuScreen(Game g) {
	create();
	this.g = g;
    }

    public MainMenuScreen() {
	create();
    }

    public void create() {

	stage = new Stage();
	Gdx.input.setInputProcessor(stage);

	// A skin can be loaded via JSON or defined programmatically, either is
	// fine. Using a skin is optional but strongly
	// recommended solely for the convenience of getting a texture, region,
	// etc as a drawable, tinted drawable, etc.
	skin = new Skin();
	// Generate a 100x100 white texture and store it in the skin named
	// "white".
	Pixmap pixmap = new Pixmap(100, 100, Format.RGBA8888);
	pixmap.setColor(Color.WHITE);
	pixmap.fill();

	skin.add("white", new Texture(pixmap));

	// Store the default libgdx font under the name "default".
	BitmapFont bfont = new BitmapFont();
	bfont.scale(1);
	skin.add("default", bfont);

	// Configure a TextButtonStyle and name it "default". Skin resources are
	// stored by type, so this doesn't overwrite the font.
	TextButtonStyle textButtonStyle = new TextButtonStyle();
	textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
	textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
	textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
	textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);

	textButtonStyle.font = skin.getFont("default");

	skin.add("default", textButtonStyle);

	final TextButton playButton = new TextButton("PLAY", textButtonStyle);
	playButton.setWidth(300);
	playButton.setHeight(100);
	playButton.setPosition(
		Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2, 300);

	stage.addActor(playButton);

	final TextButton optionsButton = new TextButton("OPTIONS",
		textButtonStyle);
	optionsButton.setWidth(300);
	optionsButton.setHeight(100);
	optionsButton
		.setPosition(
			Gdx.graphics.getWidth() / 2 - optionsButton.getWidth()
				/ 2, 200);

	stage.addActor(optionsButton);

	final TextButton exitButton = new TextButton("EXIT", textButtonStyle);
	exitButton.setWidth(300);
	exitButton.setHeight(100);
	exitButton.setPosition(
		Gdx.graphics.getWidth() / 2 - exitButton.getWidth() / 2, 100);

	stage.addActor(exitButton);

	playButton.addListener(new ChangeListener() {
	    public void changed(ChangeEvent event, Actor actor) {
		g.setScreen(new GameScreen());
		Gdx.input.setInputProcessor(new Controls());
	    }
	});

	optionsButton.addListener(new ChangeListener() {
	    public void changed(ChangeEvent event, Actor actor) {
		g.setScreen(new OptionsScreen());
		Gdx.input.setInputProcessor(null);
	    }
	});

	exitButton.addListener(new ChangeListener() {
	    public void changed(ChangeEvent event, Actor actor) {
		dispose();
		g.dispose();
	    }
	});
    }

    public void render(float delta) {
	Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

	stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
	stage.draw();
	Table.drawDebug(stage);
    }

    @Override
    public void resize(int width, int height) {
	// stage.setViewport(width, height, false);
    }

    @Override
    public void dispose() {
	stage.dispose();
	skin.dispose();
    }

    @Override
    public void show() {
	// TODO Auto-generated method stub

    }

    @Override
    public void hide() {
	dispose();

    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub

    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }
}
