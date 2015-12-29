package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.SpriteLoader;
import com.connorbrezinsky.turbulent.State;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;



public class LevelOne extends BasicGameState {

	public State levelOne = new State(this);
	
	Color bg = Color.black;
	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);

	public Image move;
	
	
	SpriteLoader sLoader;

	public LevelOne(int s) {

	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		
	}

	@Override
	public int getID(){
				return levelOne.getId();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		move = new Image("res/move.png");

		Level.aLoader = new SpriteSheet(new Image("res/animations_20x60.png"), 20, 60);
		
		sLoader = new SpriteLoader(new SpriteSheet(new Image("res/sprites.png"),20,20));

		Level.aLoader.startUse();
		Image[] iLevelFinish = { Level.aLoader.getSubImage(0,0), Level.aLoader.getSubImage(1,0), Level.aLoader.getSubImage(2,0), Level.aLoader.getSubImage(3,0),
				Level.aLoader.getSubImage(4,0), Level.aLoader.getSubImage(5,0), Level.aLoader.getSubImage(6,0), Level.aLoader.getSubImage(7,0), Level.aLoader.getSubImage(8,0),
				Level.aLoader.getSubImage(9,0), Level.aLoader.getSubImage(1,1), Level.aLoader.getSubImage(2,1) };
		Level.aLoader.endUse();

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60,  iLevelFinish,
				Level.duration);
		Level.levelFinish.setType(Object.FINISH);
		
		
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);
		Level.levelFinish.render(g);
		move.draw(10, 400);
		

		// Level.renderBasicWalls(g);
		player.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();
		


		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(Level.stage[2]);
		if(Level.levelFinish.isFinished(player)) {
			Level.levelFinish.goToNextLevel(arg1);
		}

		Level.goToLevel(i, arg1);
	}

	

}
