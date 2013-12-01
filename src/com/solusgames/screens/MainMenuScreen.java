package com.solusgames.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.controls.Controls;
import com.solusgames.entities.Entity.EntityType;
import com.solusgames.entities.planes.Plane;
import com.solusgames.entities.planes.Planetype;
import com.solusgames.entities.planes.Planetype.PlaneTypes;
import com.solusgames.render.Camera;
import com.solusgames.screens.handler.ScreenSwitchHandler;
import com.solusgames.screens.parts.Button;
import com.solusgames.screens.parts.Button.ButtonHandler;
import com.solusgames.screens.parts.Label;

public class MainMenuScreen implements com.badlogic.gdx.Screen {

    private OrthographicCamera camera = null;
    private BitmapFont font = null;
    private Label headingLabel = null;
    private Button playButton = null;
    private Button planeButton_p1 = null;
    private Button planeButton_p2 = null;
    private Button optionsButton = null;
    private Button exitButton = null;
    private int lineHeight = 0;

    public MainMenuScreen() {
	create();

    }

    public void create() {
	Global.img_menu_bg = new Sprite(new Texture(
		Gdx.files.internal("assets/data/menu/f4u.jpg")));
	Global.img_menu_bg.setBounds(0, 0,
		(float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight());
	Global.control = new Controls();
	Global.batch = new SpriteBatch();
	font = new BitmapFont();
	lineHeight = Math.round(2.5f * font.getCapHeight());
	headingLabel = new Label("Dogfight 2", font);
	createButtons();
	createPlayers();
    }

    /**
     * Creates all Buttons used on this Screen
     */
    private void createButtons() {
	Texture t = new Texture(
		Gdx.files.internal("assets/data/menu/menu_start.png"));

	playButton = new Button(0, 0, new ScreenSwitchHandler(Screen.GAME),
		new TextureRegion(t, 0, 0, 161, 20), new TextureRegion(t, 0, 0,
			161, 20));
	planeButton_p1 = new Button("Player 1", font, new ScreenSwitchHandler(
		Screen.PLANE_P1));
	planeButton_p2 = new Button("Player 2", font, new ScreenSwitchHandler(
		Screen.PLANE_P2));
	optionsButton = new Button("Options", font, new ScreenSwitchHandler(
		Screen.OPTIONS));
	exitButton = new Button("Exit", font, new ButtonHandler() {
	    @Override
	    public void onClick() {
		Gdx.app.exit();
	    }

	    @Override
	    public void onRelease() {
		// TODO Auto-generated method stub

	    }
	});
    }

    /**
     * Creates players and cameras
     */
    private void createPlayers() {
	Global.camera_player1 = new Camera(new OrthographicCamera());
	Global.camera_player2 = new Camera(new OrthographicCamera());
	Global.camera_ui = new OrthographicCamera();
	Global.player1 = new Plane(Global.player1_respawn.x,
		Global.player1_respawn.y, 0, new Planetype(PlaneTypes.F35),
		EntityType.PLAYER1);
	Global.player2 = new Plane(Global.player2_respawn.x,
		Global.player2_respawn.y, 0, new Planetype(PlaneTypes.F35),
		EntityType.PLAYER2);
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1f);
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	Global.batch.begin();
	Global.img_menu_bg.draw(Global.batch);
	headingLabel.draw(Global.batch);
	playButton.draw(Global.batch, camera);
	planeButton_p1.draw(Global.batch, camera);
	planeButton_p2.draw(Global.batch, camera);
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
	headingLabel.setY(centerY + 3 * lineHeight);
	setButtons(width, height);
    }

    /**
     * Sets the correct positions of all Buttons in this Screen
     */
    private void setButtons(int width, int height) {
	int centerX = width / 2;
	int centerY = height / 2;
	playButton.setPos(centerX - playButton.getWidth() / 2, centerY + 2
		* lineHeight);
	planeButton_p1.setPos(centerX - planeButton_p1.getWidth() / 2, centerY
		+ 1 * lineHeight);
	planeButton_p2.setPos(centerX - planeButton_p2.getWidth() / 2, centerY
		+ 0 * lineHeight);
	optionsButton.setPos(centerX - optionsButton.getWidth() / 2, centerY
		- 1 * lineHeight);
	exitButton.setPos(centerX - exitButton.getWidth() / 2, centerY - 5
		* lineHeight);
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
