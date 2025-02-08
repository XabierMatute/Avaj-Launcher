package com.frankfurtairport.avajlauncher.aircrafts;

import com.frankfurtairport.avajlauncher.Aircraft;
import com.frankfurtairport.avajlauncher.Coordinates;

public class JetPlane extends Aircraft
{
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);
        sunMessage = "Patrolling the Mojave almost makes you wish for a nuclear winter.";
        sunLatitudeIncrement = 10;
        sunHeightIncrement = 2;

        rainMessage = "A rain of blood will flood the desert and not purify it";
        rainLatitudeIncrement = 5;

        fogMessage = "The fog is so thick you can cut it with a knife.";
        fogLatitudeIncrement = 1;

        snowMessage = "Oh the weather outside is frightful, but the fire is so delightful.";
        snowHeightIncrement = -7;

        landMessage = "And so the Courier, who had cheated death in the cemetery outside Goodsprings, cheated death once again, landing.";
    }
}