package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import com.connorbrezinsky.turbulent.Character;


import com.connorbrezinsky.turbulent.Main;

public class LevelNine implements GameState {

	Color bg = Color.black;
	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);

	public LevelNine(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override
	public int getID(){
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);

		player.render(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();
		
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
