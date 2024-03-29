package me.robertjan.sdpr1.models;

import java.util.Random;

/**
 * Software Development Praktijk 1
 *
 * @author Robert-Jan van der Elst
 * @since 02-12-2019
 */
public class Sticker extends Placeable {

    private Drawable currentDrawable;

    public Sticker(Integer id) {
        super(id);
        this.randomSticker();
    }

    public int getSticker() {
        return this.currentDrawable.id;
    }

    public Integer getWidth() {
        return (this.width / 100) * this.zoom;
    }

    public Integer getHeight() {
        return (this.height / 100) * this.zoom;
    }

    public void nextSticker() {
        int index = this.currentDrawable.ordinal();
        int nextIndex = index + 1;
        Drawable[] drawables = Drawable.values();
        nextIndex %= drawables.length;

        this.currentDrawable = drawables[nextIndex];
        this.setDimensions();
    }

    private void randomSticker() {
        Drawable[] drawables = Drawable.values();
        int index = (new Random()).nextInt(drawables.length);

        this.currentDrawable = drawables[index];
        this.setDimensions();
    }

    private void setDimensions() {
        this.width = this.currentDrawable.width;
        this.height = this.currentDrawable.height;
    }
}
