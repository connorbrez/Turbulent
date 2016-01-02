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
import com.connorbrezinsky.turbulent.object.Door;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.PhysicsObject;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;
import com.connorbrezinsky.turbulent.util.State;

public class LevelNine extends BasicGameState {

	State levelNine = new State(this);

	Color bg = Color.black;
	Character player = new Character(40, Main.getMidY(20) + 200, 20, 20, Color.darkGray);
	Turbulence tb = new Turbulence();

	// AUTO GENERATED CODE
	Platform obj0 = new Platform(600, 200, 200, 300, Color.white);
	Platform obj1 = new Platform(187, 542, 50, 10, Color.white);
	Platform obj2 = new Platform(384, 390, 50, 10, Color.white);
	Platform obj3 = new Platform(197, 237, 50, 10, Color.white);
	Platform obj4 = new Platform(0, 155, 50, 30, Color.white);
	Platform obj5 = new Platform(288, 473, 50, 10, Color.white);
	Platform obj6 = new Platform(282, 308, 50, 10, Color.white);
	Platform obj7 = new Platform(391, 249, 50, 10, Color.white);
	Platform obj8 = new Platform(496, 202, 50, 10, Color.white);
	Platform obj9 = new Platform(66, 195, 50, 10, Color.white);
	Platform obj10 = new Platform(0, 90, 50, 10, Color.white);

	PhysicsObject cube = new PhysicsObject(15, 130, 10, 10, Color.blue, true);
	ObjectSpawner cSpawner;
	Switch sw0 = new Switch(699, 165, 20, 20, Color.red);

	Door dr0 = new Door(643, 500, 10, 100, Color.red);
	Door dr1 = new Door(40, 100, 10, 55, Color.red);

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

		Image[] iPhysSpawner = { new Image("res/animation/physSpawner/physSpawner1.png"),
				new Image("res/animation/physSpawner/physSpawner2.png"),
				new Image("res/animation/physSpawner/physSpawner3.png"),
				new Image("res/animation/physSpawner/physSpawner4.png"),
				new Image("res/animation/physSpawner/physSpawner5.png"),
				new Image("res/animation/physSpawner/physSpawner6.png"), };

		cSpawner = new ObjectSpawner(iPhysSpawner, Level.objSDuration);

		cube.setSpawnerPos(cube.x - 10, cube.y - 25);

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);

		cube.render(g, cSpawner);
		
		if(tb.z){
			
		}else if(tb.x){
		
		}else if(tb.c){

		
		}
		// AUTO GENERATED CODE
		obj0.render(g);
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

		sw0.render(g);

		dr0.render(g);
		dr1.render(g);

		Level.levelFinish.render(g);
		player.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		tb.addListener(i);
		
		if(tb.z){

		}else if(tb.x){

		}else if(tb.c){

		}

		// AUTO GENERATED CODE
		obj0.addCollider(player);
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

		sw0.addCollider(player);
		sw0.addListener(player, Switch.ACTION, i);

		dr0.addCollider(player);
		dr1.addCollider(player);

		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(Level.stage[10]);

		if(Level.levelFinish.isFinished(player)){
			Level.levelFinish.goToNextLevel(arg1);
		}

	}

	public LevelNine(int s) {

	}

	@Override
	public int getID(){
		return levelNine.getId();
	}

}