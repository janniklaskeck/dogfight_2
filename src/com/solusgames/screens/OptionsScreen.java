package com.solusgames.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.screens.handler.ScreenSwitchHandler;
import com.solusgames.screens.parts.Button;
import com.solusgames.screens.parts.Button.ButtonHandler;
import com.solusgames.screens.parts.Label;

public class OptionsScreen implements com.badlogic.gdx.Screen {

    private Button backButton = null;
    private Button fullscreenButton = null;
    private Button vsyncButton = null;
    private Button planeCollissionButton = null;
    private Button singleplayerButton = null;
    private Button verticalSplitButton = null;

    private OrthographicCamera camera = null;
    private BitmapFont font = null;
    private Label headingLabel = null;
    private int lineHeight = 0;

    /**
     * Creates all Buttons used on this Screen
     */
    private void createButtons() {
	headingLabel = new Label("Options", font);
	backButton = new Button("Back", font, new ScreenSwitchHandler(
		Screen.MAIN_MENU));

	Texture onOff = new Texture(
		Gdx.files.internal("assets/data/menu/buttons.png"));

	fullscreenButton = new Button("Fullscreen", font, 0, 0,
		new TextureRegion(onOff, 32, 0, 32, 32), new TextureRegion(
			onOff, 0, 0, 32, 32), new ButtonHandler() {
		    boolean changed = false;

		    @Override
		    public void onRelease() {
			changed = false;
		    }

		    @Override
		    public void onClick() {
			if (!changed) {
			    Gdx.graphics.setDisplayMode(
				    Gdx.graphics.getWidth(),
				    Gdx.graphics.getHeight(),
				    !Global.fullscreen);
			    Global.fullscreen = !Global.fullscreen;
			    fullscreenButton.setEnabled(Global.fullscreen);
			}
			changed = true;
		    }
		});
	vsyncButton = new Button("VSync: ", font, 0, 0, new TextureRegion(
		onOff, 32, 0, 32, 32), new TextureRegion(onOff, 0, 0, 32, 32),
		new ButtonHandler() {
		    boolean changed = false;

		    @Override
		    public void onRelease() {
			changed = false;
		    }

		    @Override
		    public void onClick() {
			if (!changed) {
			    Gdx.graphics.setVSync(!Global.vsync);
			    Global.vsync = !Global.vsync;
			    vsyncButton.setEnabled(Global.vsync);
			}
			changed = true;
		    }
		});
	planeCollissionButton = new Button("Plane Collision: ", font, 0, 0,
		new TextureRegion(onOff, 32, 0, 32, 32), new TextureRegion(
			onOff, 0, 0, 32, 32), new ButtonHandler() {
		    boolean changed = false;

		    @Override
		    public void onRelease() {
			changed = false;
		    }

		    @Override
		    public void onClick() {
			if (!changed) {
			    Global.plane_collision = !Global.plane_collision;
			    planeCollissionButton
				    .setEnabled(Global.plane_collision);
			}
			changed = true;
		    }
		});
	singleplayerButton = new Button("SinglePlayer: ", font, 0, 0,
		new TextureRegion(onOff, 32, 0, 32, 32), new TextureRegion(
			onOff, 0, 0, 32, 32), new ButtonHandler() {
		    boolean changed = false;

		    @Override
		    public void onRelease() {
			changed = false;
		    }

		    @Override
		    public void onClick() {
			if (!changed) {
			    Global.singlePlayer = !Global.singlePlayer;
			    singleplayerButton.setEnabled(Global.singlePlayer);
			}
			changed = true;
		    }
		});
	verticalSplitButton = new Button("Vertical Display Split: ", font, 0,
		0, new TextureRegion(onOff, 32, 0, 32, 32), new TextureRegion(
			onOff, 0, 0, 32, 32), new ButtonHandler() {
		    boolean changed = false;

		    @Override
		    public void onRelease() {
			changed = false;
		    }

		    @Override
		    public void onClick() {
			if (!changed) {
			    Global.vertical_split = !Global.vertical_split;
			    verticalSplitButton
				    .setEnabled(Global.vertical_split);
			}
			changed = true;
		    }
		});
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1f);
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	Global.batch.begin();
	Global.img_menu_bg.draw(Global.batch);
	headingLabel.draw(Global.batch);
	backButton.draw(Global.batch, camera);
	backButton.draw(Global.batch, camera);
	fullscreenButton.draw(Global.batch, camera);
	vsyncButton.draw(Global.batch, camera);
	planeCollissionButton.draw(Global.batch, camera);
	singleplayerButton.draw(Global.batch, camera);
	verticalSplitButton.draw(Global.batch, camera);

	Global.batch.end();

    }

    @Override
    public void resize(int width, int height) {
	camera = new OrthographicCamera();
	camera.setToOrtho(false, width, height);
	Global.batch.setProjectionMatrix(camera.combined);
	setButtons(width, height);
    }

    /**
     * Sets the correct positions of all Buttons in this Screen
     */
    private void setButtons(int width, int height) {
	int centerX = width / 2;
	int centerY = height / 2;
	headingLabel.setPos(centerX - headingLabel.getWidth() / 2, centerY + 6
		* lineHeight);

	backButton.setPos(centerX - backButton.getWidth() / 2, centerY - 2
		* lineHeight);

	fullscreenButton.setPos(centerX - fullscreenButton.getWidth() / 2,
		centerY + 4 * lineHeight);
	vsyncButton.setPos(centerX - vsyncButton.getWidth() / 2, centerY + 3
		* lineHeight);
	planeCollissionButton.setPos(centerX - planeCollissionButton.getWidth()
		/ 2, centerY + 2 * lineHeight);
	singleplayerButton.setPos(centerX - singleplayerButton.getWidth() / 2,
		centerY + 1 * lineHeight);
	verticalSplitButton.setPos(
		centerX - verticalSplitButton.getWidth() / 2, centerY - 0
			* lineHeight);
    }

    @Override
    public void show() {
	font = new BitmapFont();
	lineHeight = Math.round(2.5f * 16);
	createButtons();

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
