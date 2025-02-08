package com.frankfurtairport.avajlauncher.aircrafts;

import com.frankfurtairport.avajlauncher.Aircraft;
import com.frankfurtairport.avajlauncher.Coordinates;
import com.frankfurtairport.avajlauncher.WeatherProvider;

public class Baloon extends Aircraft
{
    public Baloon(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);

        sunMessage = "Hace un calor que te torras.";
        sunLongitudeIncrement = 2;
        sunHeightIncrement = 4;

        rainMessage = "Aish tengo toda la camiseta mojada, que rabia.";
        rainHeightIncrement = -5;

        fogMessage = "Estamos tan indefensos con esta niebla...";
        fogHeightIncrement = -3;

        snowMessage = "Con esta nieve tengo la piel de gallina, ¿quiere comprobarlo torre de control?";
        snowHeightIncrement = -15;

        landMessage = "Aterrizado con éxito, jodete Mr. Sullivan.";
    }
}