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
import com.connorbrezinsky.turbulent.ObjectSpawner;
import com.connorbrezinsky.turbulent.Turbulence;
import com.connorbrezinsky.turbulent.gui.GuiPauseMenu;
import com.connorbrezinsky.turbulent.object.Door;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.PhysicsObject;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;
import com.connorbrezinsky.turbulent.util.State;
import com.connorbrezinsky.turbulent.util.Texture;

public class LevelNine extends BasicGameState {

	State levelNine = new State(this);

	Color bg = Color.black;
	Character player = new Character(40, Main.getMidY(20) + 200, 20, 20, Color.darkGray);
	Turbulence tb = new Turbulence();

	// AUTO GENERATED CODE
	Platform obj0 = new Platform(600, 200, 200, 300, Color.white);
	Platform obj1 = new Platform(187, 542, 50, 10, Color.white);
	Platform obj2 = new Platform(384, 390, 50, 10, Color.white);
	Platform obj3 = new Platform(170, 240, 50, 10, Color.white);
	Platform obj4 = new Platform(0, 155, 50, 30, Color.white);
	Platform obj5 = new Platform(288, 473, 50, 10, Color.white);
	Platform obj6 = new Platform(282, 308, 50, 10, Color.white);
	Platform obj7 = new Platform(391, 249, 50, 10, Color.white);
	Platform obj8 = new Platform(496, 202, 50, 10, Color.white);
	Platform obj9 = new Platform(66, 195, 50, 10, Color.white);
	Platform obj10 = new Platform(0, 90, 50, 10, Color.white);
	Platform obj11 = new Platform(120, 400, 80, 10, Color.white);

	Switch sw0 = new Switch(699, 165, 20, 20);
	Switch sw1 = new Switch(120 + (80 / 2 - (20 / 2)), 400 - 5, 20, 5, Color.blue);

	Door dr0 = new Door(643, 500, 10, 100, Color.red);
	Door dr1 = new Door(40, 100, 10, 55, Color.red);
	
	PhysicsObject cube = new PhysicsObject(15, 130, 10, 10, Color.blue, true);
	ObjectSpawner cSpawner;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		Image[] iLevelFinish = Texture.loadLevelFinish();

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, iLevelFinish, Level.duration);
		Level.levelFinish.setType(Object.FINISH);

		Image[] iPhysSpawner = Texture.loadPhysicsSpawner();

		cSpawner = new ObjectSpawner(iPhysSpawner, Level.objSDuration);

		cube.setSpawnerPos(cube.x - 10, cube.y - 25);
		cube.addPlayer(player);

		sw0.addSprite(Texture.switchWhite_off);

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.setBackground(bg);
		cube.render(g, cSpawner);

		if (tb.z) {
			obj1.render(g);
			obj2.render(g);
			obj5.render(g);

			obj1.setColor(Color.red);
			obj2.setColor(Color.red);
			obj5.setColor(Color.red);
		} else if (tb.x) {
			obj6.render(g);
			obj7.render(g);
			obj8.render(g);

			obj6.setColor(Color.blue);
			obj7.setColor(Color.blue);
			obj8.setColor(Color.blue);
		} else if (tb.c) {
			obj3.render(g);
			obj6.render(g);
			obj9.render(g);

			obj3.setColor(Color.green);
			obj6.setColor(Color.green);
			obj9.setColor(Color.green);
		} else if (!tb.isActive()) {
			obj11.render(g);
			sw1.render(g);
		}

		obj0.render(g);
		obj4.render(g);
		obj10.render(g);

		sw0.render(g);

		dr0.render(g);
		dr1.render(g);

		Level.levelFinish.render(g);
		player.render(g);
		GuiPauseMenu.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		Input i = arg0.getInput();
		GuiPauseMenu.update(arg0, arg1);
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		tb.addListener(i);

		if (tb.z) {
			obj1.addCollider(player, cube);
			obj2.addCollider(player, cube);
			obj5.addCollider(player, cube);
		} else if (tb.x) {
			obj6.addCollider(player, cube);
			obj7.addCollider(player, cube);
			obj8.addCollider(player, cube);
		} else if (tb.c) {
			obj6.addCollider(player, cube);
			obj3.addCollider(player, cube);
			obj9.addCollider(player, cube);
		} else if (!tb.isActive()) {
			obj11.addCollider(player, cube);
			sw1.addCollider(player, cube);
			sw1.addListener(player, cube, Switch.PRESSURE, i);
		}

		obj0.addCollider(player);
		obj4.addCollider(player);
		obj10.addCollider(player);

		sw0.addCollider(player);
		sw0.addListener(player, Switch.ACTION, i);

		if (sw0.isTriggered()) {
			sw0.destroy();
		}

		cube.addPlayerCollider(player);
		cube.addListener(i);
		cube.addPhysics();

		dr0.addCollider(player, cube);
		dr0.addSwitch(sw1);
		dr1.addCollider(player, cube);
		dr1.addSwitch(sw0);

		Level.levelFinish.addCollider(player, cube);
		Level.levelFinish.setNextLevel(Level.stage[10]);

		if (Level.levelFinish.isFinished(player)) {
			//Level.levelFinish.goToNextLevel(arg1);
		}

		Level.goToLevel(i, arg1);
		
	}

	public LevelNine(int s) {

	}

	@Override
	public int getID() {
		return levelNine.getId();
	}

}