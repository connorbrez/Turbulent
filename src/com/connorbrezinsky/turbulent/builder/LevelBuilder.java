package com.connorbrezinsky.turbulent.builder;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
import com.connorbrezinsky.turbulent.object.Door;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;

public class LevelBuilder {

	static int toolActive = 1;

	static final int TOOL_REMOVE = 0;
	static final int TOOL_PLATFORM = 1;
	static final int TOOL_SWITCH = 2;
	static final int TOOL_DOOR = 3;

	public static int TOGGLE_KEY = Input.KEY_L;
	public boolean isActive = true;
	public static TextField tfWidth;
	public static TextField tfHeight;

	static int p = 0;

	public float objWidth = 50;
	public float objHeight = 10;
	public Color objColor = Color.white;

	static List<Object> objects = new ArrayList<>();
	Gui toolSelection = new Gui(0, 200, 90, 200, Color.gray);
	Gui colorGui = new Gui(0, 0, 0, 0, Color.transparent);

	GuiButton toolRemove = new GuiButton(toolSelection, 5, 220, 80, 20).setText("Remove");
	GuiButton toolPlatform = new GuiButton(toolSelection, 5, 245, 80, 20).setText("Platform");
	GuiButton toolSwitch = new GuiButton(toolSelection, 5, 270, 80, 20).setText("Switch");
	GuiButton toolDoor = new GuiButton(toolSelection, 5, 295, 80, 20).setText("Door");
	GuiButton hideGui = new GuiButton(0, 200, 15, 15).setText("-");

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
					placeObject(mx - (objWidth / 2), my - (objHeight / 2), objWidth, objHeight);
					break;
				case TOOL_SWITCH:
					placeSwitch(mx - 10, my - 10, 20, 20);
					break;

				case TOOL_DOOR:
					placeDoor(mx - (objWidth / 2), my - (objHeight / 2), objWidth, objHeight);
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
					objHeight = Float.parseFloat(tfHeight.getText());
				}
			}
		});

		tfWidth.addListener(new ComponentListener(){

			@Override
			public void componentActivated(AbstractComponent source){
				if(!Float.isNaN(Float.parseFloat(tfWidth.getText()))){
					objWidth = Float.parseFloat(tfWidth.getText());
				}
			}
		});

	}

	public void renderGui(GameContainer arg0, Graphics g){
		toolSelection.render(g);
		hideGui.render(g);
		if(toolSelection.isVisible){
			if(toolActive == TOOL_PLATFORM || toolActive == TOOL_DOOR){

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
	}

	public void guiListener(Input i) throws SlickException{
		int mx = i.getAbsoluteMouseX();
		int my = i.getAbsoluteMouseY();

		if(mx < 80 && my > 200 && my < 200 + 200 && toolSelection.isVisible){
			isActive = false;
		}else if(mx > 0 && mx < 15 && my > 200 && my < 215){
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
		}else if(toolDoor.getClick(i)){
			toolActive = TOOL_DOOR;
		}else if(hideGui.getClick(i)){
			if(toolSelection.isVisible){
				toolSelection.hide();
				hideGui.setText("+");
			}else{
				toolSelection.unHide();
				hideGui.setText("-");
			}
		}

		tfListener(i);

	}

	int activeTf = 0;

	public void tfListener(Input i){

		final int WIDTH = 1;
		final int HEIGHT = 2;
		if(toolSelection.isVisible){
			if(Main.getClick(i, tfWidth)){
				activeTf = WIDTH;
			}else if(Main.getClick(i, tfHeight)){
				activeTf = HEIGHT;
			}

			if(activeTf == WIDTH){
				tfWidth.setFocus(true);
			}else if(activeTf == HEIGHT){
				tfHeight.setFocus(true);
			}
		}
	}

	int o = 0;

	public void placeObject(float x, float y, float w, float h){
		objects.add(new Platform(x, y, w, h, objColor));

		try{
			FileUtils.writeStringToFile(new File(this.getClass()+"platforms.txt"), "Platform obj" + o + " = new " + objects.get(p)+"\n", true);
			FileUtils.writeStringToFile(new File("platforms_render.txt"), "obj" + o + ".render();\n", true);
			FileUtils.writeStringToFile(new File("platforms_collider.txt"), "obj" + o + ".addCollider();\n", true);
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("Platform obj" + o + " = new " + objects.get(p));
		p++;
		o++;
	}

	int s = 0;

	public void placeSwitch(float x, float y, float w, float h){
		objects.add(new Switch(x, y, w, h, objColor));
		try{
			FileUtils.writeStringToFile(new File("switch.txt"), "Switch sw" + o + " = new " + objects.get(p)+"\n", true);
			FileUtils.writeStringToFile(new File("switch_render.txt"), "sw" + o + ".render();\n", true);
			FileUtils.writeStringToFile(new File("switch_collider.txt"), "sw" + o + ".addCollider();\n", true);
		}catch(IOException e){
			e.printStackTrace();
		}
		p++;
		s++;
	}

	int d = 0;

	public void placeDoor(float x, float y, float w, float h){
		objects.add(new Door(x, y, w, h, objColor));
		try{
			
			
			FileUtils.writeStringToFile(new File("door.txt"), "Platform dr" + o + " = new " + objects.get(p)+"\n", true);
			FileUtils.writeStringToFile(new File("door_render.txt"), "dr" + o + ".render();\n", true);
			FileUtils.writeStringToFile(new File("door_collider.txt"), "dr" + o + ".addCollider();\n", true);
		}catch(IOException e){
			e.printStackTrace();
		}
		p++;
		d++;
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

	public void showObjectOutline(Graphics g, Input i, Color c){
		int mx = i.getAbsoluteMouseX();
		int my = i.getAbsoluteMouseY();

		switch(toolActive){
		case TOOL_PLATFORM:
			g.setColor(c);
			g.drawRect(mx - (objWidth / 2), my - (objHeight / 2), objWidth, objHeight);
			break;
		case TOOL_SWITCH:
			g.setColor(c);
			g.drawRect(mx - 10, my - 10, 20, 20);
			break;
		case TOOL_DOOR:
			g.setColor(c);
			g.drawRect(mx - (objWidth / 2), my - (objHeight / 2), objWidth, objHeight);
			break;
		}
	}

}
