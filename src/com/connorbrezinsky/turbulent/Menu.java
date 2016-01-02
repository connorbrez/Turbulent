package com.connorbrezinsky.turbulent;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.gui.GuiButton;
import com.connorbrezinsky.turbulent.levels.Level;

public class Menu extends BasicGameState {

	Image background;
	Image bPlay;
	Image bExit;

	GuiButton play;
	GuiButton exit;

	public Menu(int i) {
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException{
		background = new Image("res/menu-background.png");
		bPlay = new Image("res/button-play.png");
		bExit = new Image("res/button-exit.png");
		
		play = new GuiButton(400 - bPlay.getWidth() / 2, 300 - bPlay.getHeight() / 2, bPlay.getWidth(),
				bPlay.getHeight());
		exit = new GuiButton(400 - bExit.getWidth() / 2, 300 - (bExit.getHeight() / 2) + bPlay.getHeight() + 5,
				bExit.getWidth(), bExit.getHeight());
		
		
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
		
		Level.goToLevel(i, game);

	}

	@Override
	public int getID(){
		return 1923;
	}

}
