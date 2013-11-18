package com.solusgames.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.controls.Controls;
import com.solusgames.screens.handler.ScreenSwitchHandler;
import com.solusgames.screens.parts.Button;
import com.solusgames.screens.parts.Button.ButtonHandler;
import com.solusgames.screens.parts.Label;

public class MainMenuScreen implements com.badlogic.gdx.Screen {

    private OrthographicCamera camera = null;
    private BitmapFont font = null;
    private Label headingLabel = null;
    private Button playButton = null;
    private Button optionsButton = null;
    private Button exitButton = null;
    private int lineHeight = 0;

    public MainMenuScreen() {
	create();

    }

    public void create() {
	Global.control = new Controls();
	
	Global.batch = new SpriteBatch();
	font = new BitmapFont();
	lineHeight = Math.round(2.5f * font.getCapHeight());
	headingLabel = new Label("Screen Manager Demo", font);
	playButton = new Button("Play", font, new ScreenSwitchHandler(
		Screen.GAME));
	optionsButton = new Button("Credits", font, new ScreenSwitchHandler(
		Screen.OPTIONS));
	exitButton = new Button("Exit", font, new ButtonHandler() {
	    @Override
	    public void onClick() {
		Gdx.app.exit();
	    }
	});

    }

    public void render(float delta) {
	Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1f);
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	Global.batch.begin();
	headingLabel.draw(Global.batch);
	playButton.draw(Global.batch, camera);
	optionsButton.draw(Global.batch, camera);
	exitButton.draw(Global.batch, camera);
	Global.batch.end();
    }

    @Override
    public void resize(int width, int height) {
	camera = new OrthographicCamera();
	camera.setToOrtho(false, width, height);
	Global.batch.setProjectionMatrix(camera.combined);
	int centerX = width / 2;
	int centerY = height / 2;
	headingLabel.setX(centerX - headingLabel.getWidth() / 2);
	headingLabel.setY(centerY + 2 * lineHeight);
	playButton.setX(centerX - playButton.getWidth() / 2);
	playButton.setY(centerY + lineHeight);
	optionsButton.setX(centerX - optionsButton.getWidth() / 2);
	optionsButton.setY(centerY);
	exitButton.setX(centerX - exitButton.getWidth() / 2);
	exitButton.setY(centerY - lineHeight);
    }

    @Override
    public void dispose() {
	font.dispose();
	
    }

    @Override
    public void show() {
	// TODO Auto-generated method stub

    }

    @Override
    public void hide() {

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
