package com.frankfurtairport.avajlauncher.aircrafts;

import com.frankfurtairport.avajlauncher.Aircraft;
import com.frankfurtairport.avajlauncher.Coordinates;

public class Helicopter extends Aircraft
{
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);

        sunMessage = "Vaya Helicalores";
        sunLongitudeIncrement = 10;
        sunHeightIncrement = 2;

        rainMessage = "Vaya Helichaparrón";
        rainHeightIncrement = 5;

        fogMessage = "Vaya Heliniebla";
        fogHeightIncrement = 1;

        snowMessage = "Vaya Helinevada";
        snowHeightIncrement = -12;

        landMessage = "Vaya Heliaterrizaje";
    }
}