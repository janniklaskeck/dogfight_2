package com.solusgames.entities.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity;

public class Weapon extends Entity {

    private Weapontype type;
    private boolean alive;

    public Weapon(float x, float y, float angle, Weapontype type) {
	super(x, y, angle, 0);
	alive = true;
    }

    public void render(SpriteBatch batch) {
	batch.draw(type.getTexture(), xpos, ypos, xpos, ypos, (float) type
		.getTexture().getWidth(),
		(float) type.getTexture().getHeight(), 1f, 1f, angle,
		(int) xpos, (int) ypos, type.getTexture().getWidth(), type
			.getTexture().getHeight(), false, false);
    }

    public void update() {
	if (alive) {

	} else {

	}
    }

    public void playSound() {
	type.getSound().play(Global.sounds_volume);
    }

}
