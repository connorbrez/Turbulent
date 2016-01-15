package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;

import com.connorbrezinsky.turbulent.guiutils.GuiButton;
import com.connorbrezinsky.turbulent.levels.Level;
import com.connorbrezinsky.turbulent.util.Save;
import com.connorbrezinsky.turbulent.util.Texture;

public class Menu extends BasicGameState {

	static FadeInTransition enter = new FadeInTransition();
	
	GuiButton play;
	GuiButton exit;
	GuiButton continue_;
	GuiButton settings =  new GuiButton(800-26, 10, 16,16);
	GuiButton delete = new GuiButton(490, 375, 24,24);

	public Menu(int i) {
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

		play = new GuiButton(400 - Texture.bPlay.getWidth() / 2, 300 - Texture.bPlay.getHeight() / 2,
				Texture.bPlay.getWidth(), Texture.bPlay.getHeight());
		exit = new GuiButton(400 - Texture.bExit.getWidth() / 2,
				300 - (Texture.bExit.getHeight() / 2) + Texture.bPlay.getHeight() + 5, Texture.bExit.getWidth(),
				Texture.bExit.getHeight());
		continue_ = new GuiButton(400 - Texture.bContinue.getWidth() / 2,
				300 - (Texture.bContinue.getHeight() / 2) + Texture.bPlay.getHeight() * 2 + 10,
				Texture.bContinue.getWidth(), Texture.bContinue.getHeight()).addSprite(Texture.bContinue);
		
		
		
		container.setShowFPS(false);
		play.addSprite(Texture.bPlay);
		exit.addSprite(Texture.bExit);
		settings.addSprite(Texture.bSettings);
		delete.addSprite(Texture.bDelete);
		
		enter.init(new Splash(0), this);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		Texture.background.draw();
		play.render(g);
		exit.render(g);
		settings.render(g);
		g.setColor(Color.white);
		g.drawString("v" + Main.VERSION, 5, 5);

		if (!Save.get().equals("nosave")) {
			continue_.render(g);
			delete.render(g);
		}
		
		enter.postRender(game, container, g);
		enter.preRender(game, container, g);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		Input i = container.getInput();
		if (play.getClick(i)) {
			game.enterState(1);
		} else if (exit.getClick(i)) {
			container.exit();
		}else if (!Save.get().equals("nosave")) {
				if(continue_.getClick(i)){
					System.out.println(Save.get());
					game.enterState(Integer.parseInt(Save.get()));
				}else if(delete.getClick(i)){
					Save.delete();
				}
		}else if(settings.getClick(i)){
			
		}

		Level.goToLevel(i, game);
		
		enter.update(game, container, delta);

	}

	@Override
	public int getID() {
		return 1923;
	}

}
