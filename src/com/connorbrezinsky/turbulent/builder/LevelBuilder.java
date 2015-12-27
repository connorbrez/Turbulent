package com.connorbrezinsky.turbulent.builder;

import java.awt.Font;
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
import com.connorbrezinsky.turbulent.gui.GuiComponent;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;

public class LevelBuilder {

	static int toolActive = 0;

	static final int TOOL_PLATFORM = 0;
	static final int TOOL_SWITCH = 1;

	public static int TOGGLE_KEY = Input.KEY_L;
	public static boolean isActive = true;
	public static TextField tfWidth;
	public static TextField tfHeight;

	static int p = 0;


	public static List<Object> objects = new ArrayList<>();
	public static Gui toolSelection = new Gui(0, 200, 90, 200, Color.black);
	public static GuiComponent toolPlatform = new GuiComponent(toolSelection, 5, 220, 80, 20).setText("Platform");
	public static GuiComponent toolSwitch = new GuiComponent(toolSelection, 5, 245, 80, 20).setText("Switch");

	public LevelBuilder() {

	}

	@SuppressWarnings("unchecked")
	public static UnicodeFont getNewFont(String fontName, int fontSize){
		UnicodeFont returnFont = new UnicodeFont(new Font(fontName, Font.PLAIN, fontSize));
		returnFont.addAsciiGlyphs();
		returnFont.getEffects().add(new ColorEffect(java.awt.Color.black));
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

	public static void initGui(GameContainer arg0) throws SlickException{
	
		tfWidth = new TextField(arg0, arg0.getDefaultFont(), 5, 300, 30, 20);
		tfHeight = new TextField(arg0, arg0.getDefaultFont(), 40, 300, 30, 20);
		tfHeight.setMaxLength(3);
		tfWidth.setMaxLength(3);
		tfWidth.setFocus(true);
		tfHeight.setFocus(true);
		
 		
		tfHeight.addListener(new ComponentListener(){

			@Override
			public void componentActivated(AbstractComponent source){
				tfHeight.setFocus(true);
				System.out.println("height: " + tfHeight.getText());
			}

		});
		
		
		tfWidth.addListener(new ComponentListener(){

			@Override
			public void componentActivated(AbstractComponent source){
				tfWidth.setFocus(true);
				System.out.println("width: " + tfWidth.getText());				
			}
			
		});

	}

	public static void renderGui(GameContainer arg0, Graphics g){
		toolSelection.render(g);

		if(toolActive == TOOL_PLATFORM) {

			tfWidth.setBorderColor(Color.orange);
			tfHeight.setBorderColor(Color.orange);
			g.setColor(Color.white);
			tfHeight.setBackgroundColor(Color.white);
			tfWidth.setBackgroundColor(Color.white);
			tfHeight.setTextColor(Color.black);
			tfWidth.setTextColor(Color.black);
			tfWidth.render(arg0, g);
			tfHeight.render(arg0, g);
		}
	}

	public static void guiListener(Input i) throws SlickException{
		final int mx = i.getAbsoluteMouseX();
		final int my = i.getAbsoluteMouseY();
		
	
		
		
		if(mx < 80 && my > 200 && my < 200 + 200) {
			isActive = false;
		}else{
			isActive = true;
		}

		if(toolPlatform.getClick(i)) {
			toolActive = TOOL_PLATFORM;
		}else if(toolSwitch.getClick(i)) {
			toolActive = TOOL_SWITCH;
		}
	}

	public static void placeObject(int x, int y, int w, int h){
		objects.add(new Platform(x, y, w, h, Color.black));
		System.out.println("Platform obj" + p + " = new " + objects.get(p));

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
