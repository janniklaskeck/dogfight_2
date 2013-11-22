package com.solusgames.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.screens.handler.ScreenSwitchHandler;
import com.solusgames.screens.parts.Button;
import com.solusgames.screens.parts.Label;

public class PlaneScreen implements com.badlogic.gdx.Screen {

    private Button backButton = null;
    private OrthographicCamera camera = null;
    private BitmapFont font = null;
    private Label headingLabel = null;
    private int lineHeight = 0;
    private boolean isPlayer1 = false;

    public PlaneScreen(boolean isPlayer1) {
	this.isPlayer1 = isPlayer1;
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1f);
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	Global.batch.begin();
	Global.img_menu_bg.draw(Global.batch);
	headingLabel.draw(Global.batch);
	backButton.draw(Global.batch, camera);
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
	backButton.setX(centerX - backButton.getWidth() / 2);
	backButton.setY(centerY - lineHeight * 2);

    }

    @Override
    public void show() {
	font = new BitmapFont();
	lineHeight = Math.round(2.5f * font.getCapHeight());
	headingLabel = new Label(isPlayer1 ? "Player 1 Plane" : "Player 2 Plane", font);
	backButton = new Button("Back", font, new ScreenSwitchHandler(
		Screen.MAIN_MENU));

    }

    @Override
    public void hide() {
	// TODO Auto-generated method stub

    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub

    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
	font.dispose();

    }

}
