package com.connorbrezinsky.turbulent.levels;

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
import com.connorbrezinsky.turbulent.SpriteLoader;
import com.connorbrezinsky.turbulent.builder.LevelBuilder;

public class TestChamber implements GameState {

	Image bg;
	public Character player = new Character(Main.getMidX(20), 600 - 30, 20, 20, true);
	SpriteLoader sLoader;
	Image darkPink;

	public TestChamber(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public int getID(){
		return Level.testChamber;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		bg = new Image("res/testBg.png");
		Image iSpritesheet = new Image("res/sprites.png");
		Level.spriteSheet = new SpriteSheet(iSpritesheet, 20, 20);
		sLoader = new SpriteLoader(Level.spriteSheet);

		Level.characterTest = sLoader.getImage(1);

		LevelBuilder.initGui(arg0);

	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		Input i = arg0.getInput();
		
		bg.draw();
		player.render(g);
		player.addBasicController(i, Input.KEY_D, Input.KEY_A, Input.KEY_SPACE);
		player.addPhysics();


		/*LevelBuilder.renderObjects(g);
		LevelBuilder.renderGui(arg0, g);
		LevelBuilder.showObjectOutline(g, i);*/

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		
			player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
			player.addPhysics();
			player.addWorldCollider();
		

		/*LevelBuilder.addBuilder(i);
		LevelBuilder.addColliders(player);
		LevelBuilder.guiListener(i);

		Level.goToLevel(i, arg1);*/

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
