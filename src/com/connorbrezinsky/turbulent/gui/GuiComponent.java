package com.connorbrezinsky.turbulent.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class GuiComponent {

	int x, y, width, height;
	String text = "";

	boolean isActive = false;

	Color color, tColor, bColor;
	Image i;

	public GuiComponent(Gui gui, int _x, int _y, int w, int h, Color c) {
		gui.components.add(this);
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
		tColor = Color.black;
	}

	public GuiComponent(int _x, int _y, int w, int h, Color c) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
		tColor = Color.black;
	}

	public GuiComponent(Gui gui, int _x, int _y, int w, int h) {
		gui.components.add(this);
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = Color.white;
		tColor = Color.black;
	}

	public GuiComponent(int _x, int _y, int w, int h) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = Color.white;
		tColor = Color.black;
	}

	public GuiComponent setText(String s){
		text = s;
		return this;
	}

	public void addSprite(Image s){
		i = s;
	}

	public void render(Graphics g){
		if(i == null) {
			g.setColor(color);
			g.fillRect(x, y, width, height);
			g.setColor(tColor);
			g.drawString(text, x + ((width / 2) - ((text.length() * 5))), y + 4);
		}else{
			i.draw(x, y, width, height);
			g.setColor(tColor);
			g.drawString(text, x + ((width / 2) - ((text.length() * 5))), y + 4);
		}
	}

	public void changeColor(Color c){
		tColor = c;
	}

	public void changeBackgroundColor(Color c){
		color = c;
	}

	public void setBorderColor(Color c){
		bColor = c;
	}

	public void setActive(){
		isActive=true;
	}
	
	public void setActive(boolean a){
		isActive=a;
	}

	public boolean getClick(Input i){
		if(i.getMouseX() > x && i.getMouseX() < x + width && i.getMouseY() > y && i.getMouseY() < y + height
				&& i.isMousePressed(0)) {
			return true;
		}else{
			return false;
		}

	}

}
