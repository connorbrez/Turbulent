package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Door;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.Platform;
import com.connorbrezinsky.turbulent.Switch;
import com.connorbrezinsky.turbulent.Trigger;
import com.connorbrezinsky.turbulent.Character;


public class LevelFour implements GameState {

	Color bg = Color.black;
	Image e_key;
	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);

	public Platform obj1 = new Platform(150, 530, 40, 10, Color.orange, Platform.NORMAL);
	public Platform obj2 = new Platform(200, 480, 30, 10, Color.orange, Platform.NORMAL);
	public Platform obj3 = new Platform(250, 400, 100, 10, Color.red, Platform.NORMAL);
	public Platform obj4 = new Platform(600, 0, 200, 600 - 70, Color.black, Platform.NORMAL);
	public Platform roof = new Platform(0, 0, 800, 300, Color.black, Platform.NORMAL);

	public Trigger bgColorSwitch = new Trigger(250, 0, 100, 410, Trigger.NORMAL);

	public Door finishDoor = new Door(620, 600 - 100, 10, 100, Color.black);

	public Switch sFinishDoor = new Switch(320, 400 - 30, 20, 20, Color.black);

	boolean isActive = false;

	public LevelFour(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override
	public int getID(){
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		e_key = new Image("res/e.png");

		Image[] iLevelFinish = { new Image("res/animation/finish/phase1.png"),
				new Image("res/animation/finish/phase2.png"), new Image("res/animation/finish/phase3.png"),
				new Image("res/animation/finish/phase4.png"), new Image("res/animation/finish/phase5.png"),
				new Image("res/animation/finish/phase6.png"), new Image("res/animation/finish/phase7.png"),
				new Image("res/animation/finish/phase8.png"), new Image("res/animation/finish/phase9.png"),
				new Image("res/animation/finish/phase10.png"), new Image("res/animation/finish/phase11.png"),
				new Image("res/animation/finish/phase12.png") };

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, Platform.FINISH, Level.aLevelFinish, iLevelFinish,
				Level.duration);
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);
		if(isActive) {
			e_key.draw(Main.viewportWidth / 4 - e_key.getWidth(), Main.viewportHeight / 2 - e_key.getHeight() + 100);
			g.setColor(Color.lightGray);
			g.drawString("To activate", Main.viewportWidth / 4 - e_key.getWidth() + 50,
					Main.viewportHeight / 2 - e_key.getHeight() + 110);
		}

		obj1.render(g);
		obj2.render(g);
		obj3.render(g);
		obj4.render(g);
		roof.render(g);

		finishDoor.render(g);

		sFinishDoor.render(g);

		Level.levelFinish.render(g);
		player.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		obj1.addCollider(player);
		obj2.addCollider(player);
		obj3.addCollider(player);
		obj4.addCollider(player);
		roof.addCollider(player);

		bgColorSwitch.addBasicCollider(player);

		finishDoor.addCollider(player);
		finishDoor.addSwitch(sFinishDoor);

		this.sFinishDoor.init(player, Switch.ACTION, i);
		this.sFinishDoor.addCollider(player);

		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(Level.stage[5]);

		if(Level.levelFinish.isFinished(player)) {
			Level.levelFinish.goToNextLevel(arg1);
		}

		if(bgColorSwitch.isTriggered) {
			player.setColor(Color.darkGray);
			bg = Color.red;
			obj3.setColor(Color.black);
			isActive = true;
		}else{
			bg = Color.black;
			obj3.setColor(Color.red);
			isActive = false;

		}

		Level.goToLevel(i, arg1);
	}

	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3){
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3){
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3){
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2){
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2){
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(int arg0){
		// TODO Auto-generated method stub

	}

	@Override
	public void inputEnded(){
		// TODO Auto-generated method stub

	}

	@Override
	public void inputStarted(){
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAcceptingInput(){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInput(Input arg0){
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(int arg0, char arg1){
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int arg0, char arg1){
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerButtonPressed(int arg0, int arg1){
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerButtonReleased(int arg0, int arg1){
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerDownPressed(int arg0){
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerDownReleased(int arg0){
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerLeftPressed(int arg0){
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerLeftReleased(int arg0){
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerRightPressed(int arg0){
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerRightReleased(int arg0){
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerUpPressed(int arg0){
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerUpReleased(int arg0){
		// TODO Auto-generated method stub

	}

}
