package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.util.Texture;

public class TestChamber extends BasicGameState {


	public Character player = new Character(Main.getMidX(20), 600 - 30, 20, 20, true);



	public TestChamber(int s) {

	}



	@Override
	public int getID(){
		return Level.testChamber;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		Level.characterTest = Texture.testPlayer;
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		Input i = arg0.getInput();

		Texture.test_background.draw();
		player.render(g);
		player.addBasicController(i, Input.KEY_D, Input.KEY_A, Input.KEY_SPACE);
		player.addPhysics();

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();

		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

	}

	

}
