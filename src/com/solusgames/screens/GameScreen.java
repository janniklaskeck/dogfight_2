package com.solusgames.screens;

import com.badlogic.gdx.Screen;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity.EntityType;
import com.solusgames.entities.planes.Plane;
import com.solusgames.map.Map;
import com.solusgames.render.Render;

public class GameScreen implements Screen {
    Render r = new Render();

    public GameScreen() {

    }

    @Override
    public void dispose() {
	r.dispose();
	Global.currentMap.dispose();
	Global.player1.dispose();
	Global.player2.dispose();

    }

    @Override
    public void hide() {
	// TODO Auto-generated method stub

    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub

    }

    /**
     * Update method
     */
    public void update(float delta) {
	Global.camera_ui.setToOrtho(false, Global.current_dim.width,
		Global.current_dim.height);
	Global.camera_ui.position.set(0, 0, 0);
	Global.camera_ui.update();
	Global.player1.update(delta);
	Global.camera_player1.centerOn(Global.player1);
	Global.player2.update(delta);
	Global.camera_player2.centerOn(Global.player2);
	checkPlayerDistance();

    }

    /**
     * Checks if players are close enough for a camera merge
     */
    private void checkPlayerDistance() {
	if (getYDistance() < (Global.current_dim.getHeight() / 2)
		* (Global.current_dim.getHeight() / 2)
		&& getXDistance() < (Global.current_dim.getWidth() / 2)
			* (Global.current_dim.getWidth() / 2)) {
	    Global.camCombined = true;
	} else {
	    Global.camCombined = false;
	}
    }

    @Override
    public void render(float delta) {
	update(delta * 100);
	r.render(delta);

    }

    @Override
    public void resize(int width, int height) {
	// TODO Auto-generated method stub

    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }

    @Override
    public void show() {
	OnStartUp();
    }

    /**
     * First initialisation
     */
    public void OnStartUp() {
	Global.currentMap = new Map("map2.tmx");
	Global.player1 = new Plane(Global.player1_respawn.x,
		Global.player1_respawn.y, 0, Global.player1.getType(),
		EntityType.PLAYER1);
	Global.player2 = new Plane(Global.player2_respawn.x,
		Global.player2_respawn.y, 0, Global.player2.getType(),
		EntityType.PLAYER2);

    }

    /**
     * Returns vertical distance between player 1 and player 2
     * 
     * @return distance
     */
    public static float getYDistance() {
	float d_y = (Global.player1.getYpos() - Global.player2.getYpos());
	return (d_y * d_y);
    }

    /**
     * Returns horizontal distance between player 1 and player 2
     * 
     * @return distance
     */
    public static float getXDistance() {
	float d_x = (Global.player1.getXpos() - Global.player2.getXpos());
	return (d_x * d_x);
    }
}
