package com.solusgames.entities.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity;

public class Weapon extends Entity {

    private Weapontype type;
    private boolean alive;
    

    public Weapon(float x, float y, float angle, Weapontype type) {
	super(x, y, angle, 0, EntityType.WEAPON);
	alive = true;
	this.type = type;
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

    /**
     * @return the type
     */
    public Weapontype getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Weapontype type) {
        this.type = type;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
