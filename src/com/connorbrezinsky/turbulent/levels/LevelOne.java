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


public class LevelOne implements GameState {

	Color bg = Color.black;
	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);

	public Image a_key;
	public Image d_key;

	public LevelOne(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override
	public int getID(){
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		a_key = new Image("res/a.png");
		d_key = new Image("res/d.png");

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
		a_key.draw(Main.viewportWidth / 4 - a_key.getWidth(), Main.viewportHeight / 2 - a_key.getHeight());
		g.setColor(Color.lightGray);
		g.drawString("To go left", Main.viewportWidth / 4 - a_key.getWidth() + 50,
				Main.viewportHeight / 2 - a_key.getHeight() + 10);
		d_key.draw(Main.viewportWidth / 4 - d_key.getWidth(), Main.viewportHeight / 2 - d_key.getHeight() + 50);
		g.drawString("To go right", Main.viewportWidth / 4 - d_key.getWidth() + 50,
				Main.viewportHeight / 2 - d_key.getHeight() + 58);

		// Level.renderBasicWalls(g);
		player.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		// Level.addWallCollison(player);

		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(Level.stage[2]);
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
