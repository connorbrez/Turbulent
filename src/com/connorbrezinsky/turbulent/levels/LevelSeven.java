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
import com.connorbrezinsky.turbulent.gui.GuiPauseMenu;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;
import com.connorbrezinsky.turbulent.util.SpriteLoader;
import com.connorbrezinsky.turbulent.util.State;
import com.connorbrezinsky.turbulent.util.Texture;

public class LevelSeven extends BasicGameState {

	State levelSeven = new State(this);

	Color bg = Color.black;
	public Character player = new Character(100, Main.getMidY(20) + 200, 20, 20, Color.darkGray);
	SpriteLoader sLoader;

	public Switch switchOne = new Switch(50, 50, 20, 20);
	public Switch switchTwo = new Switch(750, 50, 20, 20);
	public Switch switchThree = new Switch(50, 570, 20, 20);
	public Switch switchFour = new Switch(750, 570, 20, 20);
	Platform levelFinish;

	public Platform obj1 = new Platform(Main.getMidX(100), Main.getMidY(-80), 100, 10);
	public Platform obj2 = new Platform(600, 550, 50, 10);
	public Platform obj3 = new Platform(500, 500, 50, 10);
	public Platform obj4 = new Platform(400, 450, 50, 10);
	public Platform obj5 = new Platform(300, 400, 50, 10);
	public Platform obj6 = new Platform(200, 350, 50, 10);
	public Platform obj7 = new Platform(100, 300, 50, 10);
	public Platform obj8 = new Platform(200, 250, 50, 10);
	public Platform obj9 = new Platform(300, 200, 50, 10);
	public Platform obj10 = new Platform(400, 150, 50, 10);
	public Platform obj11 = new Platform(100, 200, 50, 10);
	public Platform obj12 = new Platform(20, 150, 50, 10);
	public Platform obj13 = new Platform(100, 100, 50, 10);
	public Platform obj14 = new Platform(500, 100, 50, 10);
	public Platform obj15 = new Platform(600, 50, 50, 10);
	public Platform obj16 = new Platform(700, 100, 50, 10);

	Platform[] doorWalls = { new Platform(obj1.getX(), obj1.getY() - 80, 10, 80),
			new Platform(obj1.getX() + 100 - 10, obj1.getY() - 80, 10, 80),
			new Platform(obj1.getX(), obj1.getY() - 80, 100, 10) };

	@Override
	public int getID(){
		return levelSeven.getId();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		Image[] iLevelFinish = Texture.loadLevelFinish();

		levelFinish = new Platform(obj1.getX() + (100 / 2 - (20 / 2)), obj1.getY() - 60, 20, 60, iLevelFinish,
				Level.duration);
		levelFinish.setType(Object.FINISH);
		sLoader = new SpriteLoader(new SpriteSheet("res/sprites.png", 20, 20));

		switchOne.addSprite(Texture.switchWhite_off);
		switchTwo.addSprite(Texture.switchWhite_off);
		switchThree.addSprite(Texture.switchWhite_on);
		switchFour.addSprite(Texture.switchWhite_on);

		obj1.addSprite(Texture.blockMagenta);
		obj2.addSprite(Texture.blockBlue);
		obj3.addSprite(Texture.blockBlue);
		obj4.addSprite(Texture.blockBlue);
		obj5.addSprite(Texture.blockBlue);
		obj6.addSprite(Texture.blockBlue);
		obj7.addSprite(Texture.blockBlue);
		obj8.addSprite(Texture.blockBlue);
		obj9.addSprite(Texture.blockBlue);
		obj10.addSprite(Texture.blockBlue);
		obj11.addSprite(Texture.blockBlue);
		obj12.addSprite(Texture.blockBlue);
		obj13.addSprite(Texture.blockBlue);
		obj14.addSprite(Texture.blockBlue);
		obj15.addSprite(Texture.blockBlue);
		obj16.addSprite(Texture.blockBlue);

		doorWalls[0].addSprite(Texture.blockMagenta);
		doorWalls[1].addSprite(Texture.blockMagenta);
		doorWalls[2].addSprite(Texture.blockMagenta);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);
		levelFinish.render(g);
		switchOne.render(g);
		switchTwo.render(g);
		switchThree.render(g);
		switchFour.render(g);

		obj1.render(g);
		obj2.render(g);
		obj3.render(g);
		obj4.render(g);
		obj5.render(g);
		obj6.render(g);
		obj7.render(g);
		obj8.render(g);
		obj9.render(g);
		obj10.render(g);
		obj11.render(g);
		obj12.render(g);
		obj13.render(g);
		obj14.render(g);
		obj15.render(g);
		obj16.render(g);

		doorWalls[0].render(g);
		doorWalls[1].render(g);
		doorWalls[2].render(g);
		g.setColor(Color.black);
		g.drawString("23", obj1.getX() + 40, obj1.getY() - 3);

		player.render(g);
		GuiPauseMenu.render(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		GuiPauseMenu.update(arg0,arg1);
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		switchOne.addCollider(player);
		switchOne.addListener(player, Switch.ACTION, i);
		switchTwo.addCollider(player);
		switchTwo.addListener(player, Switch.ACTION, i);
		switchThree.addCollider(player);
		switchThree.addListener(player, Switch.ACTION, i);
		switchFour.addCollider(player);
		switchFour.addListener(player, Switch.ACTION, i);

		if(switchThree.isTriggered() && switchTwo.isTriggered() && !switchFour.isTriggered()
				&& !switchOne.isTriggered()){
			doorWalls[0].destroy();
			doorWalls[1].destroy();
			doorWalls[2].destroy();
		}

		if(switchOne.isTriggered()){
			switchOne.changeSprite(Texture.switchWhite_on);
		}else{
			switchOne.changeSprite(Texture.switchWhite_off);

		}

		if(switchTwo.isTriggered()){
			switchTwo.changeSprite(Texture.switchWhite_on);
		}else{
			switchTwo.changeSprite(Texture.switchWhite_off);

		}

		if(switchThree.isTriggered()){
			switchThree.changeSprite(Texture.switchWhite_on);
		}else{
			switchThree.changeSprite(Texture.switchWhite_off);
		}

		if(switchFour.isTriggered()){
			switchFour.changeSprite(Texture.switchWhite_on);
		}else{
			switchFour.changeSprite(Texture.switchWhite_off);

		}

		obj1.addCollider(player);
		obj2.addCollider(player);
		obj3.addCollider(player);
		obj4.addCollider(player);
		obj5.addCollider(player);
		obj6.addCollider(player);
		obj7.addCollider(player);
		obj8.addCollider(player);
		obj9.addCollider(player);
		obj10.addCollider(player);
		obj11.addCollider(player);
		obj12.addCollider(player);
		obj13.addCollider(player);
		obj14.addCollider(player);
		obj15.addCollider(player);
		obj16.addCollider(player);

		doorWalls[0].addCollider(player);
		doorWalls[1].addCollider(player);
		doorWalls[2].addCollider(player);

		levelFinish.addCollider(player);
		levelFinish.setNextLevel(Level.stage[8]);
		if(levelFinish.isFinished(player)){
			levelFinish.goToNextLevel(arg1);
		}
		Level.goToLevel(i, arg1);

	}

	public LevelSeven(int s) {

	}
}