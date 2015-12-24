package com.connorbrezinsky.turbulent.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class GuiComponent {

	int x, y, width, height;

	Color color;
	Image i;

	public GuiComponent(Gui gui, int _x, int _y, int w, int h, Color c) {
		gui.components.add(this);
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
	}

	public GuiComponent(int _x, int _y, int w, int h, Color c) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
	}

	public GuiComponent(Gui gui, int _x, int _y, int w, int h) {
		gui.components.add(this);
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = Color.white;
	}

	public GuiComponent(int _x, int _y, int w, int h) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = Color.white;
	}

	public void addText(String s){

	}

	public void addSprite(Image s){
		i = s;
	}

	public void render(Graphics g){
		if(i == null) {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}else{
			i.draw(x,y,width,height);
		}
	}

	public void addListener(){

	}

}
