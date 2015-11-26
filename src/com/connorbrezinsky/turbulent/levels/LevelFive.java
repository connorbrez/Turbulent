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
import com.connorbrezinsky.turbulent.Platform;
import com.connorbrezinsky.turbulent.SpriteLoader;
import com.connorbrezinsky.turbulent.Switch;


public class LevelFive implements GameState {

	Color bg = Color.black;
	Image e_key;

	Color objColor = Color.green;

	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);

	SpriteLoader sLoader;
	
	public Door finishDoor = new Door(650, 600 - 100, 10, 100, Color.green);
	public Door door0 = new Door(650, 205, 10, 50, Color.red);

	public Platform obj1 = new Platform(Main.getMidX(50), 520, 50, 10, Color.green, Platform.NORMAL);

	public Platform obj2 = new Platform(260, 480, 30, 10, Color.white, Platform.NORMAL);
	public Platform obj3 = new Platform(320, 400, 30, 10, Color.white, Platform.NORMAL);
	public Platform obj4 = new Platform(350, 350, 30, 10, Color.white, Platform.NORMAL);
	public Platform obj5 = new Platform(420, 280, 100, 10, Color.white, Platform.NORMAL);

	public Platform obj6 = new Platform(420, 480, 30, 10, Color.black, Platform.NORMAL);
	public Platform obj7 = new Platform(480, 420, 30, 10, Color.black, Platform.NORMAL);
	public Platform obj8 = new Platform(430, 370, 30, 10, Color.black, Platform.NORMAL);
	public Platform obj9 = new Platform(360, 310, 30, 10, Color.black, Platform.NORMAL);
	public Platform obj10 = new Platform(230, 250, 100, 10, Color.black, Platform.NORMAL);
	public Platform obj11 = new Platform(150, 250, 20, 10, Color.black, Platform.NORMAL);
	public Platform obj12 = new Platform(100, 250, 20, 10, Color.black, Platform.NORMAL);
	public Platform obj13 = new Platform(50, 250, 20, 10, Color.black, Platform.NORMAL);
	public Platform obj14 = new Platform(0, 200, 20, 10, Color.black, Platform.NORMAL);
	public Platform obj15 = new Platform(80, 140, 400, 10, Color.black, Platform.NORMAL);

	public Platform obj0 = new Platform(800 - 200, 600 - 345, 200, 275, Color.white, Platform.NORMAL);
	public Platform obj00 = new Platform(800 - 200, 0, 200, 205, Color.black, Platform.NORMAL);
	public Platform obj000 = new Platform(0, 0, 800, 50, Color.black, Platform.NORMAL);

	public Switch doorSwitch0 = new Switch(480, 280 - 30, 20, 20);
	public Switch doorSwitch1 = new Switch(750, 600 - 345 - 30, 20, 20);

	public Switch sDoor0 = new Switch(260, 250 - 30, 20, 20);

	public Switch colorSwitch = new Switch(10, 600 - 30, 20, 20);

	public LevelFive(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		
	}

	@Override
	public int getID(){
				return 5;
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

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, Platform.FINISH, Level.aLevelFinish, iLevelFinish,
				Level.duration);
		
		sLoader = new SpriteLoader(new SpriteSheet(new Image("res/sprites.png"),20,20));
		
		doorSwitch0.addSprite(sLoader.getImage(2));
		doorSwitch1.addSprite(sLoader.getImage(4));
		
		sDoor0.addSprite(sLoader.getImage(4));
		colorSwitch.addSprite(sLoader.getImage(3));

	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);

		finishDoor.render(g);
		colorSwitch.render(g);
		Level.levelFinish.render(g);

		obj0.render(g);
		obj00.render(g);
		obj000.render(g);

		obj1.render(g);
		obj2.render(g);
		obj3.render(g);
		obj4.render(g);
		obj5.render(g);
		obj6.render(g);
		obj7.render(g);
		obj8.render(g);
		obj9.render(g);
		obj10.render(g);
		obj11.render(g);
		//obj12.render(g);
		obj13.render(g);
		obj14.render(g);
		obj15.render(g);

		if(colorSwitch.triggered) {
			sDoor0.render(g);
			door0.render(g);
			doorSwitch1.render(g);
		}else{
			doorSwitch0.render(g);
		}

		player.render(g);

	}

	private void setObjColor(Color c){
		obj1.setColor(c);
		finishDoor.setColor(c);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		colorSwitch.addCollider(player);
		colorSwitch.init(player, Switch.ACTION, i);

		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(5);
		finishDoor.addCollider(player);

		sDoor0.init(player, Switch.ACTION, i);
		sDoor0.addCollider(player);

		obj0.addCollider(player);
		obj00.addCollider(player);
		obj000.addCollider(player);

		obj1.addCollider(player);

		if(colorSwitch.isTriggered()) {
			bg = Color.white;
			colorSwitch.setColor(Color.black);
			setObjColor(Color.orange);
			obj0.setColor(Color.black);

			obj6.addCollider(player);
			obj7.addCollider(player);
			obj8.addCollider(player);
			obj9.addCollider(player);
			obj10.addCollider(player);
			obj11.addCollider(player);
			//obj12.addCollider(player);
			obj13.addCollider(player);
			obj14.addCollider(player);
			obj15.addCollider(player);

			door0.addCollider(player);
			door0.addSwitch(sDoor0);
			doorSwitch1.addCollider(player);
			doorSwitch1.init(player, Switch.ACTION, i);
			
			colorSwitch.changeSprite(sLoader.getImage(5));

		}else{
			bg = Color.black;
			colorSwitch.setColor(Color.white);
			setObjColor(Color.green);

			obj0.setColor(Color.white);
			colorSwitch.changeSprite(sLoader.getImage(3));
			obj2.addCollider(player);
			obj3.addCollider(player);
			obj4.addCollider(player);
			obj5.addCollider(player);

			this.doorSwitch0.addCollider(player);
			this.doorSwitch0.init(player, Switch.ACTION, i);
		}

		if(doorSwitch0.isTriggered()) {
			doorSwitch0.destroy();
		}

		if(doorSwitch1.isTriggered()) {
			doorSwitch1.destroy();
		}

		if(sDoor0.isTriggered()) {
			sDoor0.destroy();
		}

		if(doorSwitch0.isTriggered() && doorSwitch1.isTriggered()) {
			finishDoor.open();
		}else{
			finishDoor.close();
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
