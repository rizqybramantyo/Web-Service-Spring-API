package model;

public class Segitiga {
	private int tinggi;
	private int alas;
	private double luas;
	public int getTinggi() {
		return tinggi;
	}
	public void setTinggi(int tinggi) {
		this.tinggi = tinggi;
	}
	public int getAlas() {
		return alas;
	}
	public void setAlas(int alas) {
		this.alas = alas;
	}
	public double getLuas(int alas, int tinggi) {
		return 1*(alas*tinggi)/2;
	}
	public void setLuas(double luas) {
		this.luas = luas;
	}
}
