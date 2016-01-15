package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;

import com.connorbrezinsky.turbulent.util.Save;
import com.connorbrezinsky.turbulent.util.State;
import com.connorbrezinsky.turbulent.util.Texture;

public class Splash extends BasicGameState {

	int timeElapsed;
	static final int DELAY = 1000;

	State splash = new State(this);
	public int id = splash.getId();
	
	static Transition leave = new FadeOutTransition();


	public Splash(int id) {

	}

	public int getID(){
		return id;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		Main.init();
		System.out.println(Save.get());
		leave.init(this, new Menu(1923));
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(Color.white);
		Texture.loading.draw();
		leave.postRender(arg1, arg0, g);
		leave.preRender(arg1, arg0, g);

	}

	Transition tLeave = new FadeOutTransition();
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{
		
		timeElapsed += delta;

		if(timeElapsed >= DELAY) {
			leave.update(game, container, delta);
			
		}
		
		if(leave.isComplete()){
			game.enterState(1923);
		}
		

	}

}
