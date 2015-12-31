package com.connorbrezinsky.turbulent;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.gui.GuiButton;

public class Menu extends BasicGameState {

	Image background;
	Image bPlay;
	Image bExit;
	
	GuiButton play = new GuiButton(400-190/2, 300-45/2, 190, 45);
	GuiButton exit = new GuiButton(400-190/2, 300-(45/2)+50, 190, 45);
	
	public Menu(int i) {
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException{
		background = new Image("res/menu-background.png");
		bPlay = new Image("res/button-play.png");
		bExit = new Image("res/button-exit.png");
		
		play.addSprite(bPlay);
		exit.addSprite(bExit);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		background.draw();
		play.render(g);
		exit.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{
		Input i = container.getInput();
		if(play.getClick(i)){
			game.enterState(1);
		}else if(exit.getClick(i)){
			container.exit();
		}
		
	}

	@Override
	public int getID(){
		// TODO Auto-generated method stub
		return 1923;
	}

}
