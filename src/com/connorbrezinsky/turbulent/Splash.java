package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Splash extends BasicGameState {

	int timeElapsed;
	static final int DELAY = 1000;

	Image logo;

	public Splash(int id) {

	}

	public int getID(){
		return 0;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		// TODO make better logo
		logo = new Image("res/loading.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(Color.white);
		//logo.draw(400 - (logo.getWidth() / 2), 300 - (logo.getHeight() / 2));
		logo.draw(0,0);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{

		timeElapsed += delta;

		if(timeElapsed >= DELAY) {
			game.enterState(1);
		}

	}

}
