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

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.ObjectSpawner;
import com.connorbrezinsky.turbulent.PhysicsObject;
import com.connorbrezinsky.turbulent.Platform;
import com.connorbrezinsky.turbulent.Switch;

public class LevelEight implements GameState {

	Color bg = Color.white;
	public Character player = new Character(40, Main.getMidY(20) + 200, 20, 20, Color.darkGray);
	public SpriteSheet aLoader;

	public Switch[] lSwitches = {};
	public PhysicsObject finishCube = new PhysicsObject(200, 600-20, 10, 10, bg);
	public ObjectSpawner fcSpawner; 
	
	public Switch finishSwitch = new Switch(Main.getMidX(40),600-5,40,5, Color.black);
	
	
	public LevelEight(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public int getID(){
		return 8;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{

		aLoader = new SpriteSheet(new Image("res/animations_20x60.png"), 20, 60);

		aLoader.startUse();
		Image[] iLevelFinish = { aLoader.getSubImage(0,0), aLoader.getSubImage(1,0), aLoader.getSubImage(2,0), aLoader.getSubImage(3,0),
				aLoader.getSubImage(4,0), aLoader.getSubImage(5,0), aLoader.getSubImage(6,0), aLoader.getSubImage(7,0), aLoader.getSubImage(8,0),
				aLoader.getSubImage(9,0), aLoader.getSubImage(1,1), aLoader.getSubImage(2,1) };
		aLoader.endUse();
		
		Image[] iPhysSpawner = { new Image("res/animation/physSpawner/physSpawner1.png"),
				new Image("res/animation/physSpawner/physSpawner2.png"),
				new Image("res/animation/physSpawner/physSpawner3.png"),
				new Image("res/animation/physSpawner/physSpawner4.png"),
				new Image("res/animation/physSpawner/physSpawner5.png"),
				new Image("res/animation/physSpawner/physSpawner6.png"), };
		
		fcSpawner = new ObjectSpawner(Level.aObjectSpawner, iPhysSpawner, Level.objSDuration);

		
		
		
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
		finishSwitch.render(g);
		
		player.render(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();
		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(Level.stage[9]);
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
