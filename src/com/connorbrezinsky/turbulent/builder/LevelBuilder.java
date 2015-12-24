package com.connorbrezinsky.turbulent.builder;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.TextField;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.gui.Gui;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;

public class LevelBuilder {

	static int toolActive = 0;

	static final int TOOL_PLATFORM = 0;
	static final int TOOL_SWITCH = 1;

	public static int TOGGLE_KEY = Input.KEY_L;
	static boolean isActive = true;
	public static TextField width;
	public static TextField height;

	static int p = 0;


	private static UnicodeFont font = getNewFont("Arial", 16);

	public static List<Object> objects = new ArrayList<>();
	public static Gui guiTest = new Gui(0,0,800,600);

	public LevelBuilder() {

	}

	@SuppressWarnings("unchecked")
	public static UnicodeFont getNewFont(String fontName, int fontSize){
		UnicodeFont returnFont = new UnicodeFont(new Font(fontName, Font.PLAIN, fontSize));
		returnFont.addAsciiGlyphs();
		returnFont.getEffects().add(new ColorEffect(java.awt.Color.white));
		return (returnFont);
	}

	public static void addBuilder(Input i) throws SlickException{
		int mouseX = i.getMouseX();
		int mouseY = i.getMouseY();

		if(Main.getKeyPress(i, Input.KEY_L)) {
			if(isActive) {
				isActive = false;
			}else{
				isActive = true;
			}
		}
		
		

		if(isActive) {
			if(i.isMousePressed(0)) {
				
				
				
				
				switch(toolActive){

				case TOOL_PLATFORM:
					placeObject(mouseX - 25, mouseY - 5, 50, 10);
					break;
				case TOOL_SWITCH:
					placeSwitch(mouseX - 10, mouseY - 10, 20, 20);
					break;

				}
			}
		}
	}

	// TODO implement gui classes / finish gui classes

	public static void initGui(GameContainer arg0) throws SlickException{
		font.loadGlyphs();
		width = new TextField(arg0, font, 5, 300, 30, 20);
		height = new TextField(arg0, font, 40, 300, 30, 20);
	}

	public static void renderGui(GameContainer arg0, Graphics g){
		g.fillRect(0, 200, 80, 200);

		if(toolActive == TOOL_PLATFORM) {
			g.setColor(Color.white);
			g.drawString("Switch", 5, 240);
			g.setColor(Color.green);
			g.drawString("Platform", 5, 220);

			width.setBorderColor(Color.orange);
			height.setBorderColor(Color.orange);
			g.setColor(Color.white);
			height.setBackgroundColor(Color.white);
			width.setBackgroundColor(Color.white);
			width.render(arg0, g);
			height.render(arg0, g);
		}else if(toolActive == TOOL_SWITCH) {
			g.setColor(Color.white);
			g.drawString("Platform", 5, 220);
			g.setColor(Color.green);
			g.drawString("Switch", 5, 240);
		}
	}

	public static void guiListener(Input i){
		int mx = i.getAbsoluteMouseX();
		int my = i.getAbsoluteMouseY();

		width.addListener(new ComponentListener(){

			@Override
			public void componentActivated(AbstractComponent source){
				System.out.println("width");
			}

		});

		if(mx < 80 && my > 200 && my < 200 + 200) {
			isActive = false;
		}else{
			isActive = true;
		}

		if(mx > 5 && mx < 80 && my > 210 && my < 240) {
			if(i.isMousePressed(0)) {
				toolActive = TOOL_PLATFORM;
			}
		}else if(mx > 5 && mx < 80 && my > 230 && my < 260) {
			if(i.isMousePressed(0)) {
				toolActive = TOOL_SWITCH;
			}
		}
	}

	public static void placeObject(int x, int y, int w, int h){
		objects.add(new Platform(x, y, w, h, Color.black));
		System.out.println("Platform obj" + p + " = new " + objects.get(p));
		/*
		 * System.out.println("obj"+p+".render();");
		 * System.out.println("obj"+p+".addCollider();");
		 */

		p++;

	}

	public static void placeSwitch(int x, int y, int w, int h){
		objects.add(new Switch(x, y, w, h, Color.black));
		System.out.println("Switch sw" + p + " = new " + objects.get(p));
		p++;

	}

	public static void renderObjects(Graphics g){
		for(Object obj : objects){
			obj.render(g);
		}

	}

	public static void addColliders(Character p){
		for(Object obj : objects){
			obj.addCollider(p);
		}
	}

	public static void showObjectOutline(Graphics g, Input i){
		int mx = i.getAbsoluteMouseX();
		int my = i.getAbsoluteMouseY();

		switch(toolActive){
		case TOOL_PLATFORM:
			g.setColor(Color.black);
			g.drawRect(mx - 25, my - 5, 50, 10);
			break;
		case TOOL_SWITCH:
			g.setColor(Color.black);
			g.drawRect(mx - 10, my - 10, 20, 20);
			break;
		}
	}

	public void placeSwitch(int x, int y){

	}

	public void placeExit(int x, int y){

	}

	public void placeDoor(int x, int y){

	}

}
