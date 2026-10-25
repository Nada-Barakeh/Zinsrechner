package org.example.zinsrechner;


public record ZinsErgebnis(double anfangskapital, int laufzeit, double zinssatz, double endkapital){

    // static-factory methode um das Ergebnis des Endkapital zu rechnen

    public static ZinsErgebnis rechnen(double anfangskapital, int laufzeit, double zinssatz){
        double endkapital = Math.pow(1+(zinssatz / 100), laufzeit) * anfangskapital;

        return new ZinsErgebnis(anfangskapital,laufzeit,zinssatz,endkapital);
    }
}




