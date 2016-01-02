package com.connorbrezinsky.turbulent.util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Main;

public class State {

	
	
	int id;
	GameState s;
	
	public State(GameState state){
		id=generateStateId();
		Main.states.add(this);
	}
	
	public int generateStateId(){
		Main.sInt++;
		return Main.sInt-1;
	}
	
	public static void initGameStates(StateBasedGame arg0){
		for(State st : Main.states){
			arg0.addState(st.getGameState());
		}
	}
	
	public static void initStates(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		for(State st : Main.states){
			arg1.getState(st.getId()).init(arg0, arg1);
		}
	}
	
	
	
	public int getId(){
		return id;
	}
	
	public GameState getGameState(){
		return s;
	}
	
}
