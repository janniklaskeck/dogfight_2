package com.solusgames.screens.parts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Button {

    private static final Color NORMAL_COLOR = new Color(1f, 1f, 1f, 0.7f);
    private static final Color HOVER_COLOR = new Color(0f, 1f, 0f, 1f);

    private String caption = null;
    private BitmapFont font = null;
    private int x = 0;
    private int y = 0;
    private int width = 0;
    private int height = 0;
    private Rectangle bounds = null;
    private ButtonHandler handler = null;

    private TextureRegion reg_enabled;
    private TextureRegion reg_disabled;
    private boolean enabled = false;

    /**
     * Textbutton
     * 
     * @param caption
     * @param font
     * @param handler
     * @param x
     * @param y
     */
    public Button(String caption, BitmapFont font, ButtonHandler handler,
	    int x, int y) {
	this.caption = caption;
	this.font = font;
	this.x = x;
	this.y = y;
	this.handler = handler;
	calculateDimensions();
    }

    /**
     * Texturedbutton with two TextureRegions
     * 
     * @param x
     * @param y
     * @param handler
     * @param reg_enabled
     * @param reg_disabled
     */
    public Button(String caption, BitmapFont font, int x, int y,
	    TextureRegion reg_enabled, TextureRegion reg_disabled,
	    ButtonHandler handler) {
	this.x = x;
	this.y = y;
	this.caption = caption;
	this.font = font;
	this.handler = handler;
	this.reg_enabled = reg_enabled;
	this.reg_disabled = reg_disabled;
	calculateDimensions();
    }

    /**
     * Textbutton
     * 
     * @param caption
     * @param font
     * @param handler
     */
    public Button(String caption, BitmapFont font, ButtonHandler handler) {
	this(caption, font, handler, 0, 0);
    }

    public String getCaption() {
	return caption;
    }

    public void setCaption(String caption) {
	this.caption = caption;
	calculateDimensions();
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    /**
     * Sets Position and Bounds
     * 
     * @param x
     * @param y
     */
    public void setPos(int x, int y) {
	this.y = y;
	this.x = x;
	bounds.y = y - height;
	bounds.x = x;
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public void draw(SpriteBatch batch, Camera camera) {
	Vector3 cursorPosition = new Vector3(Gdx.input.getX(),
		Gdx.input.getY(), 0);
	camera.unproject(cursorPosition);
	boolean isIntersect = bounds.contains(cursorPosition.x,
		cursorPosition.y);
	if (font != null) {
	    Color originalColor = font.getColor();
	    font.setColor(isIntersect ? HOVER_COLOR : NORMAL_COLOR);
	    if (reg_enabled != null) {
		font.draw(batch, caption,
			x + reg_enabled.getRegionWidth() + 10, y);
	    } else {
		font.draw(batch, caption, x, y);
	    }
	    font.setColor(originalColor);
	}
	if (reg_enabled != null && reg_disabled != null) {
	    if (enabled) {
		batch.draw(reg_enabled, x, y - height, 0, 0, width, height, 1,
			1, 0);
	    } else {
		batch.draw(reg_disabled, x, y - height, 0, 0, width, height, 1,
			1, 0);
	    }
	}
	if (isIntersect && Gdx.input.isButtonPressed(Buttons.LEFT)) {
	    handler.onClick();
	} else if (!Gdx.input.isButtonPressed(Buttons.LEFT)) {
	    handler.onRelease();
	}
    }

    private void calculateDimensions() {
	if (font != null) {
	    TextBounds dimensions = font.getBounds(caption);
	    width = Math.round(dimensions.width);
	    height = Math.round(dimensions.height);
	    bounds = new Rectangle(x, y - height, width, height);
	}
	if (reg_enabled != null && reg_disabled != null) {
	    width = Math.round(reg_enabled.getRegionWidth());
	    height = Math.round(reg_enabled.getRegionHeight());
	    bounds = new Rectangle(x, y - height, width, height);
	}
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
	return enabled;
    }

    /**
     * @param enabled
     *            the enabled to set
     */
    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public ButtonHandler getHandler() {
	return handler;
    }

    public static interface ButtonHandler {

	public void onClick();

	public void onRelease();
    }

}
