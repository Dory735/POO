package tp3.example.tp3.model;

public class IconManager {
	
	public String getIcon(int index) {
		//soleil
		if(index==0) {
			return "https://cdn.icon-icons.com/icons2/2505/PNG/512/sun_weather_icon_150657.png";
		}
		//nuages
		if(index>0 && index<8) {
			return "https://cdn.icon-icons.com/icons2/2505/PNG/512/cloudy_weather_icon_150660.png";
		}
		//pluie
		if((index>=10 && index<=16) || (index>=40 && index<=48) || (index>=210 && index<=212)) {
			return "https://cdn.icon-icons.com/icons2/2505/PNG/512/rain_weather_icon_150662.png";
		}
		//neige
		if((index>=20 && index<=32)|| (index>=60 && index<=78) || (index>=220 && index<=232)){
			return "https://cdn.icon-icons.com/icons2/2505/PNG/512/snowy_weather_icon_150655.png";
		}
		//orage
		if(index>=100 && index<=138) {
			return "https://cdn.icon-icons.com/icons2/2505/PNG/512/storm_weather_icon_150658.png";
		}
		
		
		return "https://cdn.icon-icons.com/icons2/2505/PNG/512/sunny_weather_icon_150663.png";
	}

}
