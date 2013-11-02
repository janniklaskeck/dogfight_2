package com.solusgames.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.solusgames.Dogfight_2.Global;

public class Controls {

    public void input() {
	if (!Global.paused) {
	    /**
	     * Player One Controls
	     */
	    if (Gdx.input.isKeyPressed(Keys.W)) {
		Global.player1.setThrottleUp(true);
	    } else {
		Global.player1.setThrottleUp(false);
	    }
	    if (Gdx.input.isKeyPressed(Keys.S)) {
		Global.player1.setThrottleDown(true);
	    } else {
		Global.player1.setThrottleDown(false);
	    }
	    if (Gdx.input.isKeyPressed(Keys.A)) {
		Global.player1.setTurnUp(true);
	    } else {
		Global.player1.setTurnUp(false);
	    }
	    if (Gdx.input.isKeyPressed(Keys.D)) {
		Global.player1.setTurnDown(true);
	    } else {
		Global.player1.setTurnDown(false);
	    }
	    if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
		// player 1 fire weapon slot 1
	    }
	    if (Gdx.input.isKeyPressed(Keys.NUM_2)) {
		// player 1 fire weapon slot 2
	    }
	    if (Gdx.input.isKeyPressed(Keys.NUM_3)) {
		// player 1 fire weapon slot 3
	    }
	    if (Gdx.input.isKeyPressed(Keys.NUM_4)) {
		// player 1 fire weapon slot 4
	    }
	    if (Gdx.input.isKeyPressed(Keys.NUM_5)) {
		// player 1 fire all weapon slots
	    }
	    
	    /**
	     * Player Two Controls
	     */
	    
	    if (Gdx.input.isKeyPressed(Keys.W)) {
		// player 1 accel true
	    } else {
		// player 1 accel false
	    }
	    if (Gdx.input.isKeyPressed(Keys.S)) {
		// player 1 throttle true
	    } else {
		// player 1 throttle false
	    }
	    if (Gdx.input.isKeyPressed(Keys.A)) {
	    }
	    if (Gdx.input.isKeyPressed(Keys.D)) {
	    }
	    if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
		// player 1 fire weapon slot 1
	    }
	    if (Gdx.input.isKeyPressed(Keys.NUM_2)) {
		// player 1 fire weapon slot 2
	    }
	    if (Gdx.input.isKeyPressed(Keys.NUM_3)) {
		// player 1 fire weapon slot 3
	    }
	    if (Gdx.input.isKeyPressed(Keys.NUM_4)) {
		// player 1 fire weapon slot 4
	    }
	    if (Gdx.input.isKeyPressed(Keys.NUM_5)) {
		// player 1 fire all weapon slots
	    }
	    
	    /**
	     * Misc. Controls
	     */
	    
	    if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
		Gdx.app.exit();
		Global.paused = true;
		// Enter Paused Mode
		
	    }
	} else {
	    if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
		Global.paused = false;
		// Leave Paused Mode
	    }
	}
    }
}
