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
import com.connorbrezinsky.turbulent.gui.GuiButton;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;

public class LevelBuilder {

	static int toolActive = 1;

	static final int TOOL_REMOVE = 0;
	static final int TOOL_PLATFORM = 1;
	static final int TOOL_SWITCH = 2;

	public static int TOGGLE_KEY = Input.KEY_L;
	public boolean isActive = true;
	public static TextField tfWidth;
	public static TextField tfHeight;

	static int p = 0;

	public float platWidth = 50;
	public float platHeight = 10;
	
	public static List<Object> objects = new ArrayList<>();
	public static Gui toolSelection = new Gui(0, 200, 90, 200, Color.gray);
	public static GuiButton toolRemove = new GuiButton(toolSelection, 5, 220, 80, 20).setText("Remove");
	public static GuiButton toolPlatform = new GuiButton(toolSelection, 5, 245, 80, 20).setText("Platform");
	public static GuiButton toolSwitch = new GuiButton(toolSelection, 5, 270, 80, 20).setText("Switch");

	public LevelBuilder() {

	}

	@SuppressWarnings("unchecked")
	public static UnicodeFont getNewFont(String fontName, int fontSize){
		UnicodeFont returnFont = new UnicodeFont(new Font(fontName, Font.PLAIN, fontSize));
		returnFont.addAsciiGlyphs();
		returnFont.getEffects().add(new ColorEffect(java.awt.Color.black));
		return (returnFont);
	}

	public void addBuilder(Input i) throws SlickException{
		int mx = i.getMouseX();
		int my = i.getMouseY();

		if(Main.getKeyPress(i, Input.KEY_L)){
			if(isActive){
				isActive = false;
			}else{
				isActive = true;
			}
		}

		if(isActive){
			if(i.isMousePressed(0)){
				switch(toolActive){

				case TOOL_REMOVE:
					System.out.println("Clicked for Remove");
					for(Object obj : objects){
						if(Main.getClick(i, obj, null)){
							System.out.println("Removing obj: " + obj.toString());
							try{
								objects.remove(obj);
							}catch(Exception e){
								System.out.println("Error removing obj " + obj.toString());
								e.printStackTrace();
							}
							break;
						}
					}
					break;

				case TOOL_PLATFORM:
					placeObject(mx - (platWidth/2), my - (platHeight/2), platWidth, platHeight);
					break;
				case TOOL_SWITCH:
					placeSwitch(mx - 10, my - 10, 20, 20);
					break;

				}
			}
		}
	}

	public void initGui(GameContainer arg0) throws SlickException{

		tfWidth = new TextField(arg0, arg0.getDefaultFont(), 5, 350, 30, 20);
		tfHeight = new TextField(arg0, arg0.getDefaultFont(), 40, 350, 30, 20);
		tfHeight.setMaxLength(3);
		tfWidth.setMaxLength(3);

		tfHeight.addListener(new ComponentListener(){

			@Override
			public void componentActivated(AbstractComponent source){
				if(!Float.isNaN(Float.parseFloat(tfHeight.getText()))){
					platHeight=Float.parseFloat(tfHeight.getText());
				}
			}
		});

		tfWidth.addListener(new ComponentListener(){

			@Override
			public void componentActivated(AbstractComponent source){
				if(!Float.isNaN(Float.parseFloat(tfWidth.getText()))){
					platWidth=Float.parseFloat(tfWidth.getText());
				}
			}

		});

	}

	public void renderGui(GameContainer arg0, Graphics g){
		toolSelection.render(g);

		if(toolActive == TOOL_PLATFORM){

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

	public void guiListener(Input i) throws SlickException{
		int mx = i.getAbsoluteMouseX();
		int my = i.getAbsoluteMouseY();

		if(mx < 80 && my > 200 && my < 200 + 200){
			isActive = false;
		}else{
			isActive = true;
		}

		if(toolRemove.getClick(i)){
			toolActive = TOOL_REMOVE;
		}else if(toolPlatform.getClick(i)){
			toolActive = TOOL_PLATFORM;
		}else if(toolSwitch.getClick(i)){
			toolActive = TOOL_SWITCH;
		}

		tfListener(i);

	}

	int activeTf = 0;

	public void tfListener(Input i){

		final int WIDTH = 1;
		final int HEIGHT = 2;

		if(Main.getClick(i, tfWidth)){
			activeTf = WIDTH;
		}else if(Main.getClick(i, tfHeight)){
			System.out.println("height");
			activeTf = HEIGHT;
		}

		System.out.println(activeTf);

		if(activeTf == WIDTH){
			tfWidth.setFocus(true);
		}else if(activeTf == HEIGHT){
			tfHeight.setFocus(true);
		}
	}

	public void placeObject(float x, float y, float w, float h){
		objects.add(new Platform(x, y, w, h, Color.white));
		System.out.println("Platform obj" + p + " = new " + objects.get(p));

		p++;

	}

	public void placeSwitch(int x, int y, int w, int h){
		objects.add(new Switch(x, y, w, h, Color.white));
		System.out.println("Switch sw" + p + " = new " + objects.get(p));
		p++;

	}

	public void renderObjects(Graphics g){
		for(Object obj : objects){
			obj.render(g);
		}

	}

	public void addColliders(Character p){
		for(Object obj : objects){
			obj.addCollider(p);
		}
	}

	public void showObjectOutline(Graphics g, Input i){
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
