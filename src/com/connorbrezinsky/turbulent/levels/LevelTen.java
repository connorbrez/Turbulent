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
import com.connorbrezinsky.turbulent.builder.LevelBuilder;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.util.State;
import com.connorbrezinsky.turbulent.util.Texture;

public class LevelTen extends BasicGameState {

	Color bg = Color.black;
	public Character player = new Character(40, Main.getMidY(20) + 200, 20, 20, Color.darkGray);

	State levelTen = new State(this);
	LevelBuilder builder = new LevelBuilder();
	

	public LevelTen(int s) {

	}

	@Override
	public int getID(){
		return levelTen.getId();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		Image[] iLevelFinish = Texture.loadLevelFinish();

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, iLevelFinish, Level.duration);
		Level.levelFinish.setType(Object.FINISH);
		
		builder.initGui(arg0);
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);
		Level.levelFinish.render(g);
		player.render(g);
		builder.renderGui(arg0, g);
		builder.renderObjects(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();
		Level.levelFinish.addCollider(player);

		builder.addBuilder(i);
		builder.addColliders(player);
		builder.guiListener(i);
		
		
		// TODO add next levels
		// Level.levelFinish.setNextLevel(Level.stage[11]);
		if(Level.levelFinish.isFinished(player)){
			// Level.levelFinish.goToNextLevel(arg1);
		}
		Level.goToLevel(i, arg1);

	}

}
