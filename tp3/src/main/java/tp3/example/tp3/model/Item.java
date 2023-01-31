package tp3.example.tp3.model;

public class Item {
	private int insee;
	private int day;
	private int wind10m;
	private int gust10m;
	private int dirwind10m;
	private int probarain;
	private int weather;
	private int tmin;
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getWind10m() {
		return wind10m;
	}

	public void setWind10m(int wind10m) {
		this.wind10m = wind10m;
	}

	public int getGust10m() {
		return gust10m;
	}

	public void setGust10m(int gust10m) {
		this.gust10m = gust10m;
	}

	public int getDirwind10m() {
		return dirwind10m;
	}

	public void setDirwind10m(int dirwind10m) {
		this.dirwind10m = dirwind10m;
	}

	public int getProbarain() {
		return probarain;
	}

	public void setProbarain(int probarain) {
		this.probarain = probarain;
	}

	public int getWeather() {
		return weather;
	}

	public void setWeather(int weather) {
		this.weather = weather;
	}

	public int getTmin() {
		return tmin;
	}

	public void setTmin(int tmin) {
		this.tmin = tmin;
	}

	public int getTmax() {
		return tmax;
	}

	public void setTmax(int tmax) {
		this.tmax = tmax;
	}

	private int tmax;
	
	

	public int getInsee() {
		return insee;
	}

	public void setInsee(int insee) {
		this.insee = insee;
	}

}



