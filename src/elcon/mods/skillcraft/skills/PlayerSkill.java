package elcon.mods.skillcraft.skills;

import java.io.Serializable;

public class PlayerSkill implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static int[] needed = new int[100];
	
	public String skillName;
	
	public int level;
	public int exp;
	public int expNeeded;
	
	public int currentExp;
	public int currentExpNeeded;
	
	public PlayerSkill(String skillName) {
		this.skillName = skillName;
		this.level = 1;
		this.exp = 0;
		
		expNeeded = getExpNeeded(level);
		currentExpNeeded = expNeeded - exp;
		currentExp = exp - getExpNeeded(level - 1);
	}
	
	public PlayerSkill(String skillName, int level, int exp) {
		this(skillName);
		this.level = level;
		this.exp = exp;
		
		expNeeded = getExpNeeded(level);
		currentExpNeeded = expNeeded - exp;
		currentExp = exp - getExpNeeded(level - 1);
	}
	
	public void addExp(int xp) {
		exp += xp;
		if(exp > getExpNeeded(100)) {
			exp = getExpNeeded(100);
		} else {
			if(exp > expNeeded) {
				levelUp();
			} else {
				currentExpNeeded = expNeeded - exp;
				currentExp = exp - getExpNeeded(level - 1);
			}
		}
	}
	
	public void levelUp() {
		level++;
		expNeeded = getExpNeeded(level);
		currentExpNeeded = expNeeded - exp;
		currentExp = exp - getExpNeeded(level - 1);
	}
	
	public void setExp(int xp) {
		for(int i = 100; i > 0; i--) {
			if(xp > getExpNeeded(i - 1)) {
				setLevel(i);
			}
		}
	}
	
	public void setLevel(int lvl) {
		level = lvl;
		exp = getExpNeeded(lvl - 1);
		expNeeded = getExpNeeded(lvl);
		currentExpNeeded = expNeeded - exp;
		currentExp = exp - getExpNeeded(level - 1);
	}
	
	public static void calculateNeeded() {
		for(int i = 0; i < 100; i++) {
			needed[i] = i * i * 100;
		}
	}
	
	public static int getExpNeeded(int lvl) {
		return needed[lvl - 1];
	}
}
