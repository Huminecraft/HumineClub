package fr.club.utils;

import java.io.Serializable;
import java.util.Comparator;

public class Prestige implements Serializable, Comparator<Prestige>, Comparable<Prestige>{

	private static final long serialVersionUID = -2481671106308858211L;
	
	private int palier;
	private int level;
	
	public Prestige(int palier, int level) {
		this.palier = palier;
		this.level = level;
	}
	
	public Prestige() {
		this.palier = 1;
		this.level = 0;
	}
	
	public int getPalier() {
		return palier;
	}
	
	public void setPalier(int palier) {
		this.palier = palier;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void palierUp() {
		this.palier++;
	}
	
	public void palierDown() {
		this.palier--;
	}
	
	public void levelUp() {
		this.level++;
	}
	
	public void levelDown() {
		this.level--;
	}
	
	public void resetLevel() {
		this.level = 0;
	}

	@Override
	public int compare(Prestige p1, Prestige p2) {
		if(p1 == null || p2 == null)
			return 0;
		if(p1.getPalier() != p2.getPalier())
			return (p1.getPalier() > p2.getPalier()) ? 1 : -1;
		if(p1.getLevel() != p2.getLevel())
			return (p1.getLevel() > p2.getLevel()) ? 1 : -1;
		return 0;
	}
	
	@Override
	public int compareTo(Prestige p) {
		return compare(this, p);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + level;
		result = prime * result + palier;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestige other = (Prestige) obj;
		if (level != other.level)
			return false;
		if (palier != other.palier)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prestige [palier=" + palier + ", level=" + level + "]";
	}

}
