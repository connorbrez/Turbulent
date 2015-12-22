package com.connorbrezinsky.turbulent.builder;


import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.TextField;

import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.object.Door;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.Character;

public class LevelBuilder {

	
	public static int TOGGLE_KEY = Input.KEY_L;
	static boolean isActive = true;
	public TextField width;
	public TextField height;
	
	static int p=0;
	Switch[] switches = new Switch[200];
	Door[] doors = new Door[200];
	
	private static UnicodeFont font = getNewFont("Arial", 16);
	
	public static List<Object> platforms = new ArrayList<>();
	
	public LevelBuilder(){
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static UnicodeFont getNewFont(String fontName, int fontSize) {
		UnicodeFont returnFont = new UnicodeFont(new Font(fontName, Font.PLAIN, fontSize));
		returnFont.addAsciiGlyphs();
		returnFont.getEffects().add(new ColorEffect(java.awt.Color.white));
		return (returnFont);
	}
	
	public static void addBuilder(Input i) throws SlickException{
		font.loadGlyphs();
		int mouseX = i.getMouseX()-25;
		int mouseY = i.getMouseY()-5;
		
		if(Main.getKeyPress(i, Input.KEY_L)){
			if(isActive){
				isActive=false;
			}else{
				isActive=true;
			}
		}
		
		if(isActive){
			if(i.isMousePressed(0)){
				placePlatform(mouseX,mouseY,50,10);
			}
		}
	}
	
	
	public static void openInputDialog(){
		
	}
	
	public static void addDialogInputListener(){
		
	}
	
	public static  void placePlatform(int x, int y, int w, int h){
		platforms.add(new Platform(x,y,w,h, Color.black));
	System.out.println("Platform obj" +p +" = new " +platforms.get(p));
		/*System.out.println("obj"+p+".render();");
		System.out.println("obj"+p+".addCollider();");*/


		p++;
		
		
	}
	
	public static void renderPlatforms(Graphics g){
		for(Object plat : platforms){
			plat.render(g);
		}
	        
	}
	
	public static void addColliders(Character p){
		for(Object plat : platforms){
			plat.addCollider(p);
		}
	}
	
	public void placeSwitch(int x, int y){
		
	}
	
	public void placeExit(int x, int y){
		
	}
	
	public void placeDoor(int x, int y){
		
	}
	
}
