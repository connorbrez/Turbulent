package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.Platform;
import com.connorbrezinsky.turbulent.Character;


public class LevelThree implements GameState {

	Color bg = Color.black;
	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);

	public Platform obj1 = new Platform(Main.getMidX(20), 100, 20, 500, Color.blue);

	public Platform[] jumpPlatforms = { new Platform(obj1.getX() - 14, 550, 15, 10, Color.red),
			new Platform(obj1.getX() - 14, 500, 15, 10, Color.red),
			new Platform(obj1.getX() - 14, 450, 15, 10, Color.red),
			new Platform(obj1.getX() - 14, 400, 15, 10, Color.red),
			new Platform(obj1.getX() - 14, 350, 15, 10, Color.red),
			new Platform(obj1.getX() - 14, 300, 15, 10, Color.red),
			new Platform(obj1.getX() - 14, 250, 15, 10, Color.red),
			new Platform(obj1.getX() - 14, 200, 15, 10, Color.red),
			new Platform(obj1.getX() - 14, 150, 15, 10, Color.red), };

	public LevelThree(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override
	public int getID(){
		// TODO Auto-generated method stub
		return 3;
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
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);
		Level.levelFinish.render(g);

		obj1.render(g);
		jumpPlatforms[0].render(g);
		jumpPlatforms[1].render(g);
		jumpPlatforms[2].render(g);
		jumpPlatforms[3].render(g);
		jumpPlatforms[4].render(g);
		jumpPlatforms[5].render(g);
		jumpPlatforms[6].render(g);
		jumpPlatforms[7].render(g);
		jumpPlatforms[8].render(g);
	

		player.render(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		obj1.addCollider(player);

		jumpPlatforms[0].addCollider(player);
		jumpPlatforms[1].addCollider(player);
		jumpPlatforms[2].addCollider(player);
		jumpPlatforms[3].addCollider(player);
		jumpPlatforms[4].addCollider(player);
		jumpPlatforms[5].addCollider(player);
		jumpPlatforms[6].addCollider(player);
		jumpPlatforms[7].addCollider(player);
		jumpPlatforms[8].addCollider(player);
		
		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(Level.stage[4]);

		if(Level.levelFinish.isFinished(player)) {
			Level.levelFinish.goToNextLevel(arg1);
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
