package com.solusgames.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.planes.Planetype;
import com.solusgames.entities.planes.Planetype.PlaneTypes;
import com.solusgames.screens.handler.ScreenSwitchHandler;
import com.solusgames.screens.parts.Button;
import com.solusgames.screens.parts.Button.ButtonHandler;
import com.solusgames.screens.parts.Label;

public class PlaneScreen implements com.badlogic.gdx.Screen {

    private Button backButton = null;

    private Button plane_forward = null;
    private Button plane_back = null;
    private Button wep1_forward = null;
    private Button wep1_back = null;
    private Button wep2_forward = null;
    private Button wep2_back = null;
    private Button wep3_forward = null;
    private Button wep3_back = null;
    private Button wep4_forward = null;
    private Button wep4_back = null;

    private OrthographicCamera camera = null;
    private BitmapFont font = null;
    private Label headingLabel = null;
    private Label planeLabel = null;
    private int lineHeight = 0;
    private boolean isPlayer1 = false;
    private ArrayList<PlaneTypes> planeList;

    private int index_player1 = 0;
    private int index_player2 = 0;

    /**
     * Check to choose which Player is currently choosing
     * 
     * @param isPlayer1
     */
    public PlaneScreen(boolean isPlayer1) {
	this.isPlayer1 = isPlayer1;
	planeList = new ArrayList<>();
	for (PlaneTypes t : PlaneTypes.values()) {
	    planeList.add(t);
	}
    }

    /**
     * Contains menu logic
     */
    private void update() {
	Global.player1.setType(new Planetype(planeList.get(index_player1)));
	Global.player2.setType(new Planetype(planeList.get(index_player2)));

    }

    @Override
    public void render(float delta) {
	update();
	Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1f);
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	Global.batch.begin();
	Global.img_menu_bg.draw(Global.batch);
	headingLabel.draw(Global.batch);
	backButton.draw(Global.batch, camera);
	plane_forward.draw(Global.batch, camera);
	planeLabel.setCaption(isPlayer1 ? Global.player1.getType().getName()
		: Global.player2.getType().getName());
	planeLabel.draw(Global.batch);
	plane_back.draw(Global.batch, camera);
	wep1_forward.draw(Global.batch, camera);
	wep1_back.draw(Global.batch, camera);
	wep2_forward.draw(Global.batch, camera);
	wep2_back.draw(Global.batch, camera);
	wep3_forward.draw(Global.batch, camera);
	wep3_back.draw(Global.batch, camera);
	wep4_forward.draw(Global.batch, camera);
	wep4_back.draw(Global.batch, camera);
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

	plane_forward.setPos(centerX - 250, centerY - 5 * lineHeight);

	planeLabel.setPos(centerX - 400, centerY - 5 * lineHeight);
	plane_back.setPos(centerX - 550, centerY - 5 * lineHeight);
	wep1_forward.setPos(0, 0);
	wep1_back.setPos(0, 0);
	wep2_forward.setPos(0, 0);
	wep2_back.setPos(0, 0);
	wep3_forward.setPos(0, 0);
	wep3_back.setPos(0, 0);
	wep4_forward.setPos(0, 0);
	wep4_back.setPos(0, 0);

	backButton.setX(centerX - backButton.getWidth() / 2);
	backButton.setY(centerY - lineHeight * 2);

    }

    @Override
    public void show() {
	font = new BitmapFont();
	lineHeight = Math.round(2.5f * font.getCapHeight());
	headingLabel = new Label(isPlayer1 ? "Player 1 Plane"
		: "Player 2 Plane", font);
	backButton = new Button("Back", font, new ScreenSwitchHandler(
		Screen.MAIN_MENU));

	plane_forward = new Button("Next Plane", font, new ButtonHandler() {
	    public void onClick() {
		if (isPlayer1) {
		    if (index_player1 - 1 < 0) {
			index_player1 = planeList.size() - 1;
		    } else {
			index_player1--;
		    }
		} else if (!isPlayer1) {
		    if (index_player2 - 1 < 0) {
			index_player2 = planeList.size() - 1;
		    } else {
			index_player2--;
		    }
		}
	    }
	});
	planeLabel = new Label("", font);
	plane_back = new Button("Last Plane", font, new ButtonHandler() {
	    public void onClick() {
		if (isPlayer1) {
		    if (index_player1 + 1 > planeList.size() - 1) {
			index_player1 = 0;
		    } else {
			index_player1++;
		    }
		} else if (!isPlayer1) {
		    if (index_player2 + 1 > planeList.size() - 1) {
			index_player2 = 0;
		    } else {
			index_player2++;
		    }
		}
	    }
	});
	wep1_forward = new Button("Next Weapon1", font, new ButtonHandler() {
	    public void onClick() {

	    }
	});
	wep1_back = new Button("Last Weapon1", font, new ButtonHandler() {
	    public void onClick() {

	    }
	});
	wep2_forward = new Button("Next Weapon2", font, new ButtonHandler() {
	    public void onClick() {

	    }
	});
	wep2_back = new Button("Last Weapon2", font, new ButtonHandler() {
	    public void onClick() {

	    }
	});
	wep3_forward = new Button("Next Weapon3", font, new ButtonHandler() {
	    public void onClick() {

	    }
	});
	wep3_back = new Button("Last Weapon3", font, new ButtonHandler() {
	    public void onClick() {

	    }
	});
	wep4_forward = new Button("Next Weapon4", font, new ButtonHandler() {
	    public void onClick() {

	    }
	});
	wep4_back = new Button("Last Weapon4", font, new ButtonHandler() {
	    public void onClick() {

	    }
	});
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
