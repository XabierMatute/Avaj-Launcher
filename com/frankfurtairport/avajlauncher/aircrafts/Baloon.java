package com.frankfurtairport.avajlauncher.aircrafts;

import com.frankfurtairport.avajlauncher.Aircraft;
import com.frankfurtairport.avajlauncher.Coordinates;
import com.frankfurtairport.avajlauncher.WeatherProvider;

public class Baloon extends Aircraft
{
    public Baloon(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions()
    {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
        switch (weather) { 
            case "SUN":
                System.out.println(this.toString() + ": Hace un calor que te torras.");
                this.coordinates.incrementLongitude(2);
                this.coordinates.incrementHeight(4);
             break;
            case "RAIN":
                System.out.println(this.toString() + ": Aish tengo toda la camiseta mojada, que rabia.");
                this.coordinates.decrementHeight(5);
             break;
            case "FOG" :
                System.out.println(this.toString() + ": Estamos tan indefensos con esta niebla...");
                this.coordinates.decrementHeight(3);
             break;
            case "SNOW" :
             System.out.println(this.toString() + ": Con esta nieve tengo la piel de gallina, ¿quiere comprobarlo torre de control?");
             this.coordinates.decrementHeight(15);
             break;
            default:
            throw new IllegalArgumentException("Condición climática no reconocida: " + weather);
          }
    }

}