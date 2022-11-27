package Chapter16;

import java.io.*;
import java.util.Arrays;
public class GameCharacter implements Serializable{
    private final int power;
    private final String type;
    private final String[] weapons;

    public int getPower() {
		return this.power;
	}

    public String getType() {
		return this.type;
	}

	public String[] getWeapons() {
		return this.weapons;
	}


    public GameCharacter(int power, String type, String[] weapons){
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }


}