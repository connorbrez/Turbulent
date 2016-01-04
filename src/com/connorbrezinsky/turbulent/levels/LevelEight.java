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
import com.connorbrezinsky.turbulent.Hazard;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.ObjectSpawner;
import com.connorbrezinsky.turbulent.Turbulence;
import com.connorbrezinsky.turbulent.object.Door;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.PhysicsObject;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;
import com.connorbrezinsky.turbulent.util.SpriteLoader;
import com.connorbrezinsky.turbulent.util.State;
import com.connorbrezinsky.turbulent.util.Texture;

public class LevelEight extends BasicGameState {

	State levelEight = new State(this);

	int stage = 0;

	Color bg = Color.white;
	Character player = new Character(40, Main.getMidY(20) + 200, 20, 20, Color.darkGray);
	SpriteSheet aLoader;
	SpriteLoader sLoader;
	SpriteLoader turbulenceControlls;
	Image turbulenceControllsOne;

	PhysicsObject finishCube = new PhysicsObject(200, 600 - 20, 10, 10, Color.blue, true);
	ObjectSpawner fcSpawner;

	Turbulence t = new Turbulence();

	Platform[] walls = { new Platform(165, 600 - 80, 10, 80, Color.red), new Platform(165, 600 - 80, 80, 10, Color.red),
			new Platform(165 + 70, 600 - 80, 10, 80, Color.red) };

	Door finishDoor = new Door(620, 520, 10, 80, Color.blue);

	Platform obj0 = new Platform(590, 0, 250, 520, Color.black);
	Platform obj1 = new Platform(450, 550, 100, 10, Color.black);
	// Stage 1 objects
	Platform obj2 = new Platform(0, 300, 50, 300, Color.white);
	Platform obj3 = new Platform(100, 300, 50, 300, Color.white);
	Platform obj4 = new Platform(650, 350, 150, 350, Color.white);
	Platform obj5 = new Platform(500, 350, 150, 80, Color.white);
	Platform obj6 = new Platform(200, 550, 60, 10, Color.white);
	Platform obj7 = new Platform(300, 460, 60, 10, Color.white);
	Platform obj8 = new Platform(400, 380, 60, 10, Color.white);
	Platform obj9 = new Platform(650, 200, 150, 150, Color.white);
	Platform[] obj10 = { new Platform(635, 320, 15, 10), new Platform(635, 270, 15, 10),
			new Platform(635, 220, 15, 10) };
	Platform obj11 = new Platform(510, 180, 50, 10, Color.white);
	Platform obj12 = new Platform(360, 240, 50, 10, Color.white);
	Platform obj13 = new Platform(220, 300, 50, 10, Color.white);
	Platform obj14 = new Platform(0, 200, 10, 100, Color.white);
	Platform[] obj15 = { new Platform(10, 280, 10, 10), new Platform(10, 240, 10, 10), new Platform(10, 200, 10, 10) };
	Platform obj16 = new Platform(100, 150, 50, 10, Color.white);
	Platform obj17 = new Platform(200, 100, 50, 10, Color.white);
	Platform obj18 = new Platform(300, 50, 50, 10, Color.white);
	Platform obj19 = new Platform(400, 80, 800, 10);
	Object oSprite = new Object(400, 80, 20, 10);
	Switch sOneSwitch = new Switch(600, 80 - 4, 40, 4, Color.red);
	PhysicsObject sOneCube = new PhysicsObject(600, 600 - 20, 10, 10, Color.red, true);
	ObjectSpawner sOneSpawner;
	Hazard spike1 = new Hazard(50, 600 - 20, 20F, 13);
	Hazard spike2 = new Hazard(62, 600 - 20, 20F, 13);
	Hazard spike3 = new Hazard(80, 600 - 20, 20F, 13);
	// Stage 2 objects
	Platform obj20 = new Platform(0, 600 - 100, 200, 100, Color.white);
	Platform obj21 = new Platform(300, 600 - 150, 20, 150);
	Hazard[] spikeStrip = { new Hazard(200, 600 - 20, 20F, 13), new Hazard(220, 600 - 20, 20F, 13),
			new Hazard(240, 600 - 20, 20F, 13), new Hazard(260, 600 - 20, 20F, 13),
			new Hazard(280, 600 - 20, 20F, 13) };
	Platform obj22 = new Platform(740, 550, 50, 10, Color.white);
	Platform obj23 = new Platform(640, 500, 50, 10, Color.white);
	Platform obj24 = new Platform(540, 450, 50, 10, Color.white);
	Platform obj25 = new Platform(440, 400, 50, 10, Color.white);
	Platform obj26 = new Platform(340, 350, 50, 10, Color.white);
	Platform obj27 = new Platform(240, 300, 50, 10, Color.white);
	Platform obj28 = new Platform(200, 500, 10, 10, Color.white);
	Platform obj29 = new Platform(290, 450, 10, 10, Color.white);
	Platform obj30 = new Platform(0, 200, 100, 150, Color.white);
	Platform obj31 = new Platform(450, Main.getMidY(10), 50, 10, Color.white);
	Platform obj32 = new Platform(600, Main.getMidY(10), 50, 10, Color.white);
	Platform obj33 = new Platform(800 - 100, 250, 100, 150, Color.white);
	Platform obj34 = new Platform(600, 200, 50, 10, Color.white);
	Platform obj35 = new Platform(500, 200, 10, 10);
	Platform obj36 = new Platform(400, 200, 10, 10);
	Platform obj37 = new Platform(300, 200, 10, 10);
	Platform obj38 = new Platform(200, 200, 10, 10);
	Platform obj39 = new Platform(100, 200, 10, 10);
	PhysicsObject sTwoCube = new PhysicsObject(45, 500 - 20, 10, 10, Color.red, true);
	ObjectSpawner sTwoSpawner;
	Switch sTwoSwitch = new Switch(50 - 20, 200 - 5, 40, 5, Color.red);
	// Stage 3
	Platform obj40 = new Platform(800 - 100, 200, 100, 150, Color.white);
	Platform obj41 = new Platform(Main.getMidX(50), 540, 50, 10, Color.white);
	Platform obj42 = new Platform(250, 490, 50, 10, Color.white);
	Platform obj43 = new Platform(150, 420, 50, 10, Color.white);
	Platform obj44 = new Platform(0, 350, 100, 10, Color.white);
	Platform obj45 = new Platform(160, 270, 50, 10, Color.white);
	Platform obj46 = new Platform(240, 210, 310, 10, Color.white);
	Platform obj47 = new Platform(600, 210, 50, 10, Color.white);

	Hazard[] spikes = { new Hazard(300, 210 - 20, 20F, 13), new Hazard(390, 210 - 20, 20F, 13F),
			new Hazard(480, 210 - 20, 20F, 13F) };
	Hazard spike4 = new Hazard(305F, 520F, 20F, 13F);

	Object sCover = new Object(305, 540.5F, 20, 10, Color.white);

	PhysicsObject sThreeCube = new PhysicsObject(45, 350 - 20, 10, 10, Color.red, true);
	ObjectSpawner sThreeSpawner;
	Switch sThreeSwitch = new Switch(750 - 20, 200 - 5, 40, 5, Color.red);

	Switch[] lSwitch = { new Switch(460, 550 - 50, 20, 20), new Switch(490, 550 - 50, 20, 20),
			new Switch(520, 550 - 50, 20, 20) };
	Switch finishSwitch = new Switch(Main.getMidX(40), 600 - 5, 40, 5, Color.blue);
	Switch sBack = new Switch(-20, -20, 20, 20);
	float sx_1;
	float sx_2;
	float sx_3;
	float sx_4;

	public LevelEight(int s) {

	}

	@Override
	public int getID(){
		return levelEight.getId();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{

		aLoader = new SpriteSheet(new Image("res/animations_20x60.png"), 20, 60);
		SpriteSheet[] s = { new SpriteSheet(new Image("res/sprites.png"), 20, 20),
				new SpriteSheet(new Image("res/turbulence_controlls_2.png"), 23, 25) };
		sLoader = new SpriteLoader(s);

		turbulenceControllsOne = new Image("res/turbulence_controlls_1.png");

		sx_1 = finishCube.getX() - 10;
		sx_2 = sOneCube.getX() - 10;
		sx_3 = sTwoCube.getX() - 10;
		sx_4 = sThreeCube.getX() - 10;

		Image[] iLevelFinish = Texture.loadLevelFinish();

		Image[] iPhysSpawner = Texture.loadPhysicsSpawner();

		Level.levelFinish = new Platform(750, 600 - 60, 20, 60, iLevelFinish, Level.duration);
		Level.levelFinish.setType(Object.FINISH);
		fcSpawner = new ObjectSpawner(iPhysSpawner, Level.objSDuration);
		sOneSpawner = fcSpawner;
		sTwoSpawner = fcSpawner;
		sThreeSpawner = fcSpawner;

		sOneCube.setSpawnerPos(sx_2, 600 - 50);
		sTwoCube.setSpawnerPos(sx_3, 500 - 50);
		sThreeCube.setSpawnerPos(sx_3, sThreeCube.getY() - 50 + 20);

		lSwitch[0].setCustomActionRadius(5, 20, 10, 80);
		lSwitch[1].setCustomActionRadius(5, 20, 10, 80);
		lSwitch[2].setCustomActionRadius(5, 20, 10, 80);

		lSwitch[0].addSprite(Texture.switchBlack_off);
		lSwitch[1].addSprite(Texture.switchBlack_off);
		lSwitch[2].addSprite(Texture.switchBlack_off);
		spike1.addSprite(Texture.spike);
		spike2.addSprite(Texture.spike);
		spike3.addSprite(Texture.spike);
		obj10[0].addSprite(Texture.blockOrange);
		obj10[1].addSprite(Texture.blockOrange);
		obj10[2].addSprite(Texture.blockOrange);
		obj15[0].addSprite(Texture.blockLightBlue);
		obj15[1].addSprite(Texture.blockLightBlue);
		obj15[2].addSprite(Texture.blockLightBlue);
		obj19.addSprite(Texture.blockOrange);
		oSprite.addSprite(Texture.blockOrange);
		obj21.addSprite(Texture.blockLightBlue);
		spikeStrip[0].addSprite(Texture.spike);
		spikeStrip[1].addSprite(Texture.spike);
		spikeStrip[2].addSprite(Texture.spike);
		spikeStrip[3].addSprite(Texture.spike);
		spikeStrip[4].addSprite(Texture.spike);
		obj35.addSprite(Texture.blockOrange);
		obj36.addSprite(Texture.blockOrange);
		obj37.addSprite(Texture.blockOrange);
		obj38.addSprite(Texture.blockOrange);
		obj39.addSprite(Texture.blockOrange);
		sBack.addSprite(Texture.switchWhite_off);
		spike4.addSprite(Texture.spike);
		spikes[0].addSprite(Texture.spike);
		spikes[1].addSprite(Texture.spike);
		spikes[2].addSprite(Texture.spike);

	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException{

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);

		sBack.render(g);

		if(!lSwitch[0].isTriggered() && !lSwitch[1].isTriggered() && !lSwitch[2].isTriggered()){
			bg = Color.white;
			finishSwitch.render(g);
			g.setColor(Color.black);
			if(sOneSwitch.isTriggered()){
				g.setColor(Color.green);
				g.drawString("S1", 460, 550 - 70);
			}else{
				g.setColor(Color.black);
				g.drawString("S1", 460, 550 - 70);
			}

			if(!sTwoSwitch.isTriggered()){
				g.setColor(Color.black);
				g.drawString("S2", 490, 550 - 70);
			}else{
				g.setColor(Color.green);
				g.drawString("S2", 490, 550 - 70);
			}

			if(!sThreeSwitch.isTriggered()){
				g.setColor(Color.black);
				g.drawString("S3", 520, 550 - 70);
			}else{
				g.setColor(Color.green);
				g.drawString("S3", 520, 550 - 70);
			}

			lSwitch[0].render(g);
			lSwitch[1].render(g);
			lSwitch[2].render(g);

			g.setColor(Color.black);
			g.fillRect(sx_1 - 25, 600 - 80, 80, 80);
			finishCube.setSpawnerPos(sx_1, 600 - 50);
			finishCube.render(g, fcSpawner);

			walls[0].render(g);
			walls[1].render(g);
			walls[2].render(g);

			obj0.render(g);
			obj1.render(g);

			finishDoor.render(g);

			Level.levelFinish.render(g);

		}else if(lSwitch[0].isTriggered()){
			stage = 1;
			bg = Color.black;
			obj2.render(g);
			spike1.render(g);
			spike2.render(g);
			spike3.render(g);
			obj3.render(g);
			obj4.render(g);
			obj5.render(g);
			obj6.render(g);
			obj7.render(g);
			obj8.render(g);
			obj9.render(g);
			obj10[0].render(g);
			obj10[1].render(g);
			obj10[2].render(g);
			obj11.render(g);
			obj12.render(g);
			obj13.render(g);
			obj14.render(g);
			obj15[0].render(g);
			obj15[1].render(g);
			obj15[2].render(g);
			obj16.render(g);
			obj17.render(g);
			obj18.render(g);
			obj19.render(g);
			oSprite.render(g);
			sOneSwitch.render(g);

			sOneCube.render(g, sOneSpawner);

		}else if(lSwitch[1].isTriggered()){
			stage = 2;
			bg = Color.black;
			obj20.render(g);
			obj21.render(g);
			obj22.render(g);
			spikeStrip[0].render(g);
			spikeStrip[1].render(g);
			spikeStrip[2].render(g);
			spikeStrip[3].render(g);
			spikeStrip[4].render(g);
			obj23.render(g);
			obj24.render(g);
			obj25.render(g);
			obj26.render(g);
			obj27.render(g);
			obj28.render(g);
			obj29.render(g);
			obj30.render(g);
			obj31.render(g);
			obj32.render(g);
			obj33.render(g);
			obj34.render(g);
			obj35.render(g);
			obj36.render(g);
			obj37.render(g);
			obj38.render(g);
			obj39.render(g);

			sTwoSwitch.render(g);
			sTwoCube.render(g, sTwoSpawner);

		}else if(lSwitch[2].isTriggered()){
			stage = 3;
			bg = Color.black;
			obj40.render(g);
			obj44.render(g);

			if(sThreeCube.goneFromSpawner){
				sThreeCube.render(g);
			}

			if(!t.isActive()){
				sThreeCube.render(g, sThreeSpawner);
				sThreeSwitch.render(g);
				g.setColor(Color.gray);
				g.fillRect(70, 510, this.turbulenceControllsOne.getWidth() + 20,
						this.turbulenceControllsOne.getHeight() + 20);
				this.turbulenceControllsOne.draw(80, 520);

			}else if(t.isActive(t.z)){
				g.setColor(Color.gray);
				g.fillRect(70, 510, Texture.turbZ.getWidth() + 20, Texture.turbZ.getHeight() + 20);
				Texture.turbZ.draw(80, 520);

				obj40.render(g);
				obj41.render(g);
				obj45.render(g);
				obj46.render(g);
				spikes[0].render(g);
				spikes[1].render(g);
				spikes[2].render(g);

			}else if(t.isActive(t.x)){
				g.setColor(Color.gray);
				g.fillRect(70, 510, Texture.turbX.getWidth() + 20, Texture.turbX.getHeight() + 20);
				Texture.turbX.draw(80, 520);
				obj40.render(g);
				obj41.render(g);
				obj42.render(g);
				spike4.render(g);
				sCover.render(g);
				obj46.render(g);
				spikes[0].render(g);
				spikes[1].render(g);
				spikes[2].render(g);

				obj47.render(g);
			}else if(t.isActive(t.c)){
				g.setColor(Color.gray);
				g.fillRect(70, 510, Texture.turbC.getWidth() + 20, Texture.turbC.getHeight() + 20);
				Texture.turbC.draw(80, 520);
				obj40.render(g);
				obj42.render(g);
				obj43.render(g);
			}else if(t.isActive()){

			}
		}

		player.render(g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		sBack.addCollider(player);
		sBack.addListener(player, Switch.ACTION, i);

		if(sBack.isTriggered()){
			switch(stage){
			case 1:
				lSwitch[0].triggered = false;
				player.setPos(lSwitch[0].getX(), lSwitch[0].getY() + 21);
				break;
			case 2:
				lSwitch[1].triggered = false;
				player.setPos(lSwitch[1].getX(), lSwitch[1].getY() + 21);
				break;
			case 3:
				lSwitch[2].triggered = false;
				player.setPos(lSwitch[2].getX(), lSwitch[2].getY() + 21);
				break;
			}
			sBack.triggered = false;
		}

		if(!lSwitch[0].isTriggered() && !lSwitch[1].isTriggered() && !lSwitch[2].isTriggered()){
			sBack.setPos(-20, -20);
			finishCube.addPhysics();
			finishCube.addPlayer(player);
			finishCube.addPlayerCollider(player);
			finishCube.addListener(i);

			finishSwitch.addCollider(player, finishCube);
			finishSwitch.addListener(player, finishCube, Switch.PRESSURE, i);

			lSwitch[0].addListener(player, Switch.ACTION, i);
			lSwitch[1].addListener(player, Switch.ACTION, i);
			lSwitch[2].addListener(player, Switch.ACTION, i);
			lSwitch[0].addCollider(player);
			lSwitch[1].addCollider(player);
			lSwitch[2].addCollider(player);

			obj0.addCollider(player);
			obj1.addCollider(player, finishCube);

			if(sOneSwitch.isTriggered() && sTwoSwitch.isTriggered() && sThreeSwitch.isTriggered()){
				walls[0].destroy();
				walls[1].destroy();
				walls[2].destroy();
			}

			finishDoor.addCollider(player);
			finishDoor.addSwitch(finishSwitch);

			walls[0].addCollider(player, finishCube);
			walls[1].addCollider(player, finishCube);
			walls[2].addCollider(player, finishCube);

			if(lSwitch[0].isTriggered()){
				lSwitch[0].changeSprite(Texture.switchBlack_on);

			}else{
				lSwitch[0].changeSprite(Texture.switchBlack_off);
			}

			if(lSwitch[1].isTriggered()){
				lSwitch[1].changeSprite(Texture.switchBlack_off);
			}else{

				lSwitch[1].changeSprite(Texture.switchBlack_on);
			}

			if(lSwitch[2].isTriggered()){
				lSwitch[2].changeSprite(Texture.switchBlack_on);
			}else{
				lSwitch[2].changeSprite(Texture.switchBlack_off);
			}

			Level.levelFinish.addCollider(player, finishCube);
			Level.levelFinish.setNextLevel(Level.stage[9]);
			if(Level.levelFinish.isFinished(player)){
				// Level.levelFinish.goToNextLevel(arg1);
			}
		}else if(lSwitch[0].isTriggered()){
			player.setSpawn(200, 580);
			sBack.setPos(160, 600 - 30);

			spike1.addCollider(player, sOneCube);
			spike2.addCollider(player, sOneCube);
			spike3.addCollider(player, sOneCube);

			sOneCube.addListener(i);
			sOneCube.addPhysics();
			sOneCube.addPlayer(player);
			sOneCube.addPlayerCollider(player);

			sOneSwitch.addCollider(player, sOneCube);
			sOneSwitch.addListener(player, sOneCube, Switch.PRESSURE, i);

			obj2.addCollider(player, sOneCube);
			obj3.addCollider(player, sOneCube);
			obj4.addCollider(player, sOneCube);
			obj5.addCollider(player, sOneCube);
			obj6.addCollider(player, sOneCube);
			obj7.addCollider(player, sOneCube);
			obj8.addCollider(player, sOneCube);
			obj9.addCollider(player, sOneCube);
			obj10[0].addCollider(player, sOneCube);
			obj10[1].addCollider(player, sOneCube);
			obj10[2].addCollider(player, sOneCube);
			obj11.addCollider(player, sOneCube);
			obj12.addCollider(player, sOneCube);
			obj13.addCollider(player, sOneCube);
			obj14.addCollider(player, sOneCube);
			obj15[0].addCollider(player, sOneCube);
			obj15[1].addCollider(player, sOneCube);
			obj15[2].addCollider(player, sOneCube);
			obj16.addCollider(player, sOneCube);
			obj17.addCollider(player, sOneCube);
			obj18.addCollider(player, sOneCube);
			obj19.addCollider(player, sOneCube);

		}else if(lSwitch[1].isTriggered()){
			sBack.setPos(640, 600 - 30);
			player.setSpawn(680, 600 - 30);

			obj20.addCollider(player, sTwoCube);
			obj21.addCollider(player, sTwoCube);
			obj22.addCollider(player, sTwoCube);
			obj23.addCollider(player, sTwoCube);
			obj24.addCollider(player, sTwoCube);
			obj25.addCollider(player, sTwoCube);
			obj26.addCollider(player, sTwoCube);
			obj27.addCollider(player, sTwoCube);
			obj28.addCollider(player, sTwoCube);
			obj29.addCollider(player, sTwoCube);
			obj30.addCollider(player, sTwoCube);
			obj31.addCollider(player, sTwoCube);
			obj32.addCollider(player, sTwoCube);
			obj33.addCollider(player, sTwoCube);
			obj34.addCollider(player, sTwoCube);
			obj35.addCollider(player, sTwoCube);
			obj36.addCollider(player, sTwoCube);
			obj37.addCollider(player, sTwoCube);
			obj38.addCollider(player, sTwoCube);
			obj39.addCollider(player, sTwoCube);

			sTwoCube.addListener(i);
			sTwoCube.addPhysics();
			sTwoCube.addPlayer(player);
			sTwoCube.addPlayerCollider(player);

			sTwoSwitch.addListener(player, sTwoCube, Switch.PRESSURE, i);
			sTwoSwitch.addCollider(player, sTwoCube);

			spikeStrip[0].addCollider(player, sTwoCube);
			spikeStrip[1].addCollider(player, sTwoCube);
			spikeStrip[2].addCollider(player, sTwoCube);
			spikeStrip[3].addCollider(player, sTwoCube);
			spikeStrip[4].addCollider(player, sTwoCube);

		}else if(lSwitch[2].isTriggered()){
			t.addListener(i);
			sBack.setPos(800 - 160, 600 - 30);
			player.setSpawn(550, 600 - 40);

			obj40.addCollider(player, sThreeCube);
			obj44.addCollider(player, sThreeCube);

			sThreeCube.addListener(i);
			sThreeCube.addPhysics();
			sThreeCube.addPlayer(player);
			sThreeCube.addPlayerCollider(player);

			if(!t.isActive()){

				obj40.setColor(Color.white);
				obj44.setColor(Color.white);
				sThreeSwitch.addCollider(player);
				sThreeSwitch.addCollider(sThreeCube);
				sThreeSwitch.addListener(player, sThreeCube, Switch.PRESSURE, i);

			}else if(t.isActive(t.z)){
				obj40.setColor(Color.orange);
				obj41.setColor(Color.orange);
				obj44.setColor(Color.orange);
				obj45.setColor(Color.orange);
				obj46.setColor(Color.orange);

				obj41.addCollider(player, sThreeCube);
				obj45.addCollider(player, sThreeCube);
				obj46.addCollider(player, sThreeCube);

				spikes[0].addCollider(player, sThreeCube);
				spikes[1].addCollider(player, sThreeCube);
				spikes[2].addCollider(player, sThreeCube);

			}else if(t.isActive(t.x)){
				obj40.setColor(Color.yellow);
				obj44.setColor(Color.yellow);

				obj41.addCollider(player, sThreeCube);
				obj41.setColor(Color.yellow);
				obj42.addCollider(player, sThreeCube);
				obj42.setColor(Color.yellow);
				spike4.addCollider(player, sThreeCube);
				sCover.addCollider(player, sThreeCube);
				sCover.setColor(Color.yellow);
				obj47.addCollider(player, sThreeCube);
				obj47.setColor(Color.yellow);
				obj46.addCollider(player, sThreeCube);
				obj46.setColor(Color.yellow);
			}else if(t.isActive(t.c)){
				obj40.setColor(Color.pink);
				obj44.setColor(Color.pink);

				obj43.addCollider(player, sThreeCube);
				obj43.setColor(Color.pink);
				obj42.addCollider(player, sThreeCube);
				obj42.setColor(Color.pink);

			}

		}

		Level.goToLevel(i, arg1);

	}

}
