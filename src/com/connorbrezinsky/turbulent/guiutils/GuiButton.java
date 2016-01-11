package com.connorbrezinsky.turbulent.guiutils;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class GuiButton extends GuiComponent {

	public GuiButton(Gui gui, int _x, int _y, int w, int h) {
		super(gui, _x, _y, w, h);
	}

	public GuiButton(int _x, int _y, int w, int h) {
		super(_x, _y, w, h);
	}

	public GuiButton(Gui gui, int _x, int _y, int w, int h, Color c) {
		super(gui, _x, _y, w, h, c);
	}

	public GuiButton(int _x, int _y, int w, int h, Color c) {
		super(_x, _y, w, h, c);
	}

	public GuiButton addSprite(Image s) {
		i = s;
		return this;
	}

	public GuiButton setText(String s) {
		text = s;
		return this;
	}

	public void setColor(Color c) {
		tColor = c;
	}

	public GuiButton setBorderColor(Color c) {
		bColor = c;
		return this;
	}

}
