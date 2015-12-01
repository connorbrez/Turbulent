package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.Platform;
import com.connorbrezinsky.turbulent.Trigger;
import com.connorbrezinsky.turbulent.Character;

public class LevelTwo implements GameState {

	Color bg = Color.black;
	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);
	Image space_key;

	public Platform obj_1 = new Platform(350 - 20, 600 - 30, 20, 30, Color.lightGray, Platform.NORMAL);
	public Platform obj_2 = new Platform(400 - 20, 600 - 50, 20, 50, Color.darkGray, Platform.NORMAL);
	public Platform obj_3 = new Platform(450 - 20, 600 - 30, 20, 30, Color.lightGray, Platform.NORMAL);
	public Trigger obj2ColorTrigger = new Trigger(400 - 40, 0, 60, 600, Trigger.AREA);

	public LevelTwo(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		
	}

	@Override
	public int getID(){
				return 2;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		space_key = new Image("res/space.png");

		Level.aLoader = new SpriteSheet(new Image("res/animations_20x60.png"), 20, 60);

		Level.aLoader.startUse();
		Image[] iLevelFinish = { Level.aLoader.getSubImage(0,0), Level.aLoader.getSubImage(1,0), Level.aLoader.getSubImage(2,0), Level.aLoader.getSubImage(3,0),
				Level.aLoader.getSubImage(4,0), Level.aLoader.getSubImage(5,0), Level.aLoader.getSubImage(6,0), Level.aLoader.getSubImage(7,0), Level.aLoader.getSubImage(8,0),
				Level.aLoader.getSubImage(9,0), Level.aLoader.getSubImage(1,1), Level.aLoader.getSubImage(2,1) };
		Level.aLoader.endUse();

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, Platform.FINISH, Level.aLevelFinish, iLevelFinish,
				Level.duration);
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);
		Level.levelFinish.render(g);
		obj_1.render(g);
		obj_2.render(g);
		obj_3.render(g);


		space_key.draw(10, 400);

		player.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		Level.levelFinish.setNextLevel(Level.stage[3]);
		Level.levelFinish.addCollider(player);

		obj_1.addCollider(player);
		obj_2.addCollider(player);
		obj_3.addCollider(player);

		obj2ColorTrigger.addBasicCollider(player);

		if(obj2ColorTrigger.isTriggered) {
			player.setColor(Color.lightGray);
		}else{
			player.setColor(Color.darkGray);
		}

		if(Level.levelFinish.isFinished(player)) {
			Level.levelFinish.goToNextLevel(arg1);
		}

		Level.goToLevel(i, arg1);
	}

	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3){
		
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3){
		
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3){
		
	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2){
		
	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2){
		
	}

	@Override
	public void mouseWheelMoved(int arg0){
		
	}

	@Override
	public void inputEnded(){
		
	}

	@Override
	public void inputStarted(){
		
	}

	@Override
	public boolean isAcceptingInput(){
				return false;
	}

	@Override
	public void setInput(Input arg0){
		
	}

	@Override
	public void keyPressed(int arg0, char arg1){
		
	}

	@Override
	public void keyReleased(int arg0, char arg1){
		
	}

	@Override
	public void controllerButtonPressed(int arg0, int arg1){
		
	}

	@Override
	public void controllerButtonReleased(int arg0, int arg1){
		
	}

	@Override
	public void controllerDownPressed(int arg0){
		
	}

	@Override
	public void controllerDownReleased(int arg0){
		
	}

	@Override
	public void controllerLeftPressed(int arg0){
		
	}

	@Override
	public void controllerLeftReleased(int arg0){
		
	}

	@Override
	public void controllerRightPressed(int arg0){
		
	}

	@Override
	public void controllerRightReleased(int arg0){
		
	}

	@Override
	public void controllerUpPressed(int arg0){
		
	}

	@Override
	public void controllerUpReleased(int arg0){
		
	}

}
