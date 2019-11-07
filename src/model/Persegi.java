package model;

public class Persegi {
	
	private int sisi;
	private double luas;
	public int getSisi() {
		return sisi;
	}
	public void setSisi(int sisi) {
		this.sisi = sisi;
	}
	public double getLuas(int sisi) {
		return sisi*sisi;
	}
	public void setLuas(double luas) {
		this.luas = luas;
	}
}
