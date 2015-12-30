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
import com.connorbrezinsky.turbulent.State;
import com.connorbrezinsky.turbulent.builder.LevelBuilder;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;

public class LevelNine extends BasicGameState {

	State levelNine = new State(this);

	Color bg = Color.black;
	Character player = new Character(40, Main.getMidY(20) + 200, 20, 20, Color.darkGray);

	LevelBuilder lb = new LevelBuilder();
	


	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		Image[] iLevelFinish = { new Image("res/animation/finish/phase1.png"),
				new Image("res/animation/finish/phase2.png"), new Image("res/animation/finish/phase3.png"),
				new Image("res/animation/finish/phase4.png"), new Image("res/animation/finish/phase5.png"),
				new Image("res/animation/finish/phase6.png"), new Image("res/animation/finish/phase7.png"),
				new Image("res/animation/finish/phase8.png"), new Image("res/animation/finish/phase9.png"),
				new Image("res/animation/finish/phase10.png"), new Image("res/animation/finish/phase11.png"),
				new Image("res/animation/finish/phase12.png") };

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, iLevelFinish, Level.duration);
		Level.levelFinish.setType(Object.FINISH);
		lb.initGui(arg0);

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		Input i = arg0.getInput();
		g.setBackground(bg);
		lb.renderObjects(g);

		lb.renderGui(arg0, g);
		lb.showObjectOutline(g, i, Color.white);
		
		
		
		Level.levelFinish.render(g);
		player.render(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		lb.addBuilder(i);
		
		lb.addColliders(player);
		lb.guiListener(i);

		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(Level.stage[10]);

		if(Level.levelFinish.isFinished(player)){
			Level.levelFinish.goToNextLevel(arg1);
		}
		
		if(lb.isActive){
			Level.goToLevel(i, arg1);
		}
	}

	public LevelNine(int s) {

	}

	@Override
	public int getID(){
		return levelNine.getId();
	}

}