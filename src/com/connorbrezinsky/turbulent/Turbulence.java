package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Input;

public class Turbulence {

	public boolean x, y, c = false;
	int key[] = { Input.KEY_Z, Input.KEY_X, Input.KEY_C };

	public Turbulence() {

	}

	public void addListener(Input i){
		if(Main.getKeyPress(i, key[0])) {
			if(x){
				setLevel(0);
			}else{
				setLevel(1);
			}
		}else if(Main.getKeyPress(i, key[1])) {
			if(y){
				setLevel(0);
			}else{
				setLevel(2);
			}
		}else if(Main.getKeyPress(i, key[2])) {
			if(c){
				setLevel(0);
			}else{
				setLevel(3);
			}
		}
		
		
	}

	public boolean isActive(boolean xyc){
		if(xyc){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isActive(){
		if(x||y||c){
			return true;
		}else{
			return false;
		}
	}
	
	public void setLevel(int xyc){
		switch(xyc){
		case 0:
			x = false;
			y = false;
			c = false;
			break;
		case 1:
			x = true;
			y = false;
			c = false;
			break;
		case 2:
			x = false;
			y = true;
			c = false;
			break;
		case 3:
			x = false;
			y = false;
			c = true;
			break;
		default:
			System.err.println("no level with id" + xyc);
		}
	}

}
