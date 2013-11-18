package com.solusgames.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.screens.Screen;
import com.solusgames.screens.ScreenManager;

public class Controls implements InputProcessor {

    @Override
    public boolean keyDown(int keycode) {
	if (!Global.paused) {
	    /**
	     * Player One Controls
	     */
	    if (keycode == Keys.W) {
		Global.player1.setThrottleUp(true);
	    }
	    if (keycode == Keys.A) {
		Global.player1.setTurnUp(true);
	    }
	    if (keycode == Keys.S) {
		Global.player1.setThrottleDown(true);
	    }
	    if (keycode == Keys.D) {
		Global.player1.setTurnDown(true);
	    }
	    if (keycode == Keys.NUM_1) {
		Global.player1.setSlot1_fire(true);
	    }
	    if (keycode == Keys.NUM_2) {
		Global.player1.setSlot2_fire(true);
	    }
	    if (keycode == Keys.NUM_3) {
		Global.player1.setSlot3_fire(true);
	    }
	    if (keycode == Keys.NUM_4) {
		Global.player1.setSlot4_fire(true);
	    }
	    /**
	     * Player Two Controls
	     */
	    if (keycode == Keys.UP) {
		Global.player2.setThrottleUp(true);
	    }
	    if (keycode == Keys.LEFT) {
		Global.player2.setTurnUp(true);
	    }
	    if (keycode == Keys.DOWN) {
		Global.player2.setThrottleDown(true);
	    }
	    if (keycode == Keys.RIGHT) {
		Global.player2.setTurnDown(true);
	    }
	    if (keycode == Keys.NUM_1) {

	    }
	    if (keycode == Keys.NUM_2) {

	    }
	    if (keycode == Keys.NUM_3) {

	    }
	    if (keycode == Keys.NUM_4) {

	    }
	    if (keycode == Keys.ESCAPE) {
		Gdx.input.setInputProcessor(null);
		ScreenManager.getInstance().show(Screen.MAIN_MENU);
		Global.paused = true;
		// Enter Paused Mode

	    }
	} else {
	    if (keycode == Keys.ESCAPE) {
		Global.paused = true;
		// Enter Paused Mode

	    }
	}
	return true;
    }

    @Override
    public boolean keyUp(int keycode) {
	if (!Global.paused) {
	    /**
	     * Player One Controls
	     */
	    if (keycode == Keys.W) {
		Global.player1.setThrottleUp(false);
	    }
	    if (keycode == Keys.A) {
		Global.player1.setTurnUp(false);
	    }
	    if (keycode == Keys.S) {
		Global.player1.setThrottleDown(false);
	    }
	    if (keycode == Keys.D) {
		Global.player1.setTurnDown(false);
	    }
	    if (keycode == Keys.NUM_1) {
		Global.player1.setSlot1_fire(false);
	    }
	    if (keycode == Keys.NUM_2) {
		Global.player1.setSlot2_fire(false);
	    }
	    if (keycode == Keys.NUM_3) {
		Global.player1.setSlot3_fire(false);
	    }
	    if (keycode == Keys.NUM_4) {
		Global.player1.setSlot4_fire(false);
	    }
	    /**
	     * Player Two Controls
	     */
	    if (keycode == Keys.UP) {
		Global.player2.setThrottleUp(false);
	    }
	    if (keycode == Keys.LEFT) {
		Global.player2.setTurnUp(false);
	    }
	    if (keycode == Keys.DOWN) {
		Global.player2.setThrottleDown(false);
	    }
	    if (keycode == Keys.RIGHT) {
		Global.player2.setTurnDown(false);
	    }
	    if (keycode == Keys.NUM_1) {

	    }
	    if (keycode == Keys.NUM_2) {

	    }
	    if (keycode == Keys.NUM_3) {

	    }
	    if (keycode == Keys.NUM_4) {

	    }
	    // pause
	    if (keycode == Keys.ESCAPE) {
		Global.paused = true;
		// Enter Paused Mode

	    }
	} else {
	    if (keycode == Keys.ESCAPE) {
		Global.paused = true;
		// Enter Paused Mode

	    }
	}
	return true;
    }

    @Override
    public boolean keyTyped(char character) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean scrolled(int amount) {
	// TODO Auto-generated method stub
	return false;
    }
}
