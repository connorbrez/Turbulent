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
import com.connorbrezinsky.turbulent.Door;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.ObjectSpawner;
import com.connorbrezinsky.turbulent.PhysicsObject;
import com.connorbrezinsky.turbulent.Platform;
import com.connorbrezinsky.turbulent.SpriteLoader;
import com.connorbrezinsky.turbulent.Switch;

public class LevelSix implements GameState {

	Color bg = Color.black;
	public Character player = new Character(40, Main.getMidY(20) + 200, 20, 20, Color.darkGray);
	public Door finishDoor = new Door(650, 600 - 100, 10, 100, Color.blue);

	
	public Platform obj0 = new Platform(0, 0, 800, 200);
	public Platform obj00 = new Platform(600, 0, 300, 500);
	SpriteLoader sLoader;
	
	Switch pressureSwitch = new Switch(400,600-5,20,5,Color.black);
	
	Image pickup;
	Image downarrow;
	

	Platform finish = Level.levelFinish;

	public ObjectSpawner objSpawner;
	public PhysicsObject cube = new PhysicsObject(200, 600 - 20, 10, 10, Color.blue, true);
	float sx;
	public LevelSix(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public int getID(){
		return 6;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		Image[] iLevelFinish = { new Image("res/animation/finish/phase1.png"),
				new Image("res/animation/finish/phase2.png"), new Image("res/animation/finish/phase3.png"),
				new Image("res/animation/finish/phase4.png"), new Image("res/animation/finish/phase5.png"),
				new Image("res/animation/finish/phase6.png"), new Image("res/animation/finish/phase7.png"),
				new Image("res/animation/finish/phase8.png"), new Image("res/animation/finish/phase9.png"),
				new Image("res/animation/finish/phase10.png"), new Image("res/animation/finish/phase11.png"),
				new Image("res/animation/finish/phase12.png") };

		Image[] iPhysSpawner = { new Image("res/animation/physSpawner/physSpawner1.png"),
				new Image("res/animation/physSpawner/physSpawner2.png"),
				new Image("res/animation/physSpawner/physSpawner3.png"),
				new Image("res/animation/physSpawner/physSpawner4.png"),
				new Image("res/animation/physSpawner/physSpawner5.png"),
				new Image("res/animation/physSpawner/physSpawner6.png"), };
		
		downarrow = new Image("res/downarrow.png");
		pickup = new Image("res/pickup.png");
		
		SpriteSheet spritesheet = new SpriteSheet(new Image("res/sprites.png"), 20, 20);
		sLoader = new SpriteLoader(spritesheet);
		objSpawner = new ObjectSpawner(Level.aObjectSpawner, iPhysSpawner, Level.objSDuration);
		sx = cube.getX()-10;
		
		
		
		obj0.addImage(sLoader.getImage(0));
		obj00.addImage(sLoader.getImage(0));

		finish = new Platform(700, 600 - 60, 20, 60, Platform.FINISH, Level.aLevelFinish, iLevelFinish, Level.duration);
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);
		finish.render(g);
		obj0.render(g);
		obj00.render(g);
		finishDoor.render(g);
		
		g.setColor(Color.white);
		g.fillRect(100,490,75,50);
		pickup.draw(105,500);
		
		g.fillRect(pressureSwitch.x-10, 600-60, 40, 60);
		downarrow.draw(pressureSwitch.x-2,600-50);
		pressureSwitch.render(g);
		
		cube.setSpawnerPos(sx, 600-50);
		cube.render(g, objSpawner);
		
		player.render(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();
		obj0.addCollider(player);
		obj00.addCollider(player);

	
		pressureSwitch.init(player, cube, Switch.PRESSURE, i);
		pressureSwitch.addCollider(player);
		pressureSwitch.addCollider(cube);
		cube.addPhysics();
		cube.init(i, player);

		obj0.addCollider(player, cube);
		obj00.addCollider(player,cube);
		finishDoor.addCollider(player);
		cube.addPlayerCollider(player);
		
		finish.addCollider(player);
		finish.setNextLevel(Level.stage[7]);
		if(finish.isFinished(player)) {
			finish.goToNextLevel(arg1);
		}
		
		if(pressureSwitch.isTriggered()){
			finishDoor.open();
		}else{
			finishDoor.close();
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
