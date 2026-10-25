package org.example.zinsrechner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ZinsController {
    @GetMapping("/zins")
    public String zinsRechner(
            // @RequestParam : parameter aus dem gegebennen URL nehmen
            // z.B : http://localhost:8080/zins?Anfangskapital=3000&Laufzeit=2&Zinssatz=0.1

            @RequestParam(name="Anfangskapital" , defaultValue = "5000") double anfangskapital,
            @RequestParam(name="Laufzeit", defaultValue = "3") int laufzeit,
            @RequestParam(name="Zinssatz" , defaultValue = "0.5") double zinssatz,
            Model model){

            ZinsErgebnis ergebnis = ZinsErgebnis.rechnen(anfangskapital,laufzeit,zinssatz);

            model.addAttribute("EK", ergebnis.endkapital());
            model.addAttribute("AK", ergebnis.anfangskapital());
            model.addAttribute("LZ", ergebnis.laufzeit());
            model.addAttribute("ZS", ergebnis.zinssatz());


     return "zins";
    }

}
