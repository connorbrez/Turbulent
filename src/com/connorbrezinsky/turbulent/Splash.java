package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.util.Save;
import com.connorbrezinsky.turbulent.util.State;
import com.connorbrezinsky.turbulent.util.Texture;

public class Splash extends BasicGameState {

	int timeElapsed;
	static final int DELAY = 1000;

	State splash = new State(this);
	public int id = splash.getId();

	public Splash(int id) {

	}

	public int getID(){
		return id;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		Main.init();
		System.out.println(Save.get());
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(Color.white);
		Texture.loading.draw();

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{

		timeElapsed += delta;

		if(timeElapsed >= DELAY) {
			game.enterState(1923);
		}

	}

}
