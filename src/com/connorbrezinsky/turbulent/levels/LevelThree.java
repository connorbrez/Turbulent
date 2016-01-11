package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.gui.GuiPauseMenu;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.util.State;
import com.connorbrezinsky.turbulent.util.Texture;

public class LevelThree extends BasicGameState {

	State levelThree = new State(this);

	Color bg = Color.black;
	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);

	public Platform obj1 = new Platform(Main.getMidX(20), 100, 20, 500, Color.gray);

	public Platform[] jumpPlatforms = { new Platform(obj1.getX() - 15, 570, 15, 10, Color.lightGray),
			new Platform(obj1.getX() - 15, 520, 15, 10, Color.lightGray),
			new Platform(obj1.getX() - 15, 470, 15, 10, Color.lightGray),
			new Platform(obj1.getX() - 15, 430, 15, 10, Color.lightGray),
			new Platform(obj1.getX() - 15, 370, 15, 10, Color.lightGray),
			new Platform(obj1.getX() - 15, 330, 15, 10, Color.lightGray),
			new Platform(obj1.getX() - 15, 270, 15, 10, Color.lightGray),
			new Platform(obj1.getX() - 15, 230, 15, 10, Color.lightGray),
			new Platform(obj1.getX() - 15, 170, 15, 10, Color.lightGray) };

	public LevelThree(int s) {

	}

	@Override
	public int getID(){
		return levelThree.getId();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		Image[] iLevelFinish = Texture.loadLevelFinish();

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, iLevelFinish, Level.duration);
		Level.levelFinish.setType(Object.FINISH);

	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);
		Level.levelFinish.render(g);

		obj1.render(g);
		jumpPlatforms[1].render(g);
		jumpPlatforms[3].render(g);
		jumpPlatforms[5].render(g);
		jumpPlatforms[7].render(g);
		jumpPlatforms[8].render(g);

		player.render(g);
		GuiPauseMenu.render(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		GuiPauseMenu.update(arg0, arg1);
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		obj1.addCollider(player);

		jumpPlatforms[1].addCollider(player);
		jumpPlatforms[3].addCollider(player);
		jumpPlatforms[5].addCollider(player);
		jumpPlatforms[7].addCollider(player);
		jumpPlatforms[8].addCollider(player);

		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(Level.stage[4]);

		if(Level.levelFinish.isFinished(player)){
			Level.levelFinish.goToNextLevel(arg1);
		}

		Level.goToLevel(i, arg1);
	}

}
