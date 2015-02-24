/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joconner.demo.collation;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author joconner
 */
public class CollationMain {

    
    static String[] WORDS = {"rastrillo", "cotê","Hendrick", "côté", "aßlar", "coté", "Ülle", "assoziation", 
        "addled", "Üxküll", "cotè", "assistant", "cotë", "rápido", "côte", "Izaak", "rana", "IJsbrand", "nino", 
        "Ypsilon", "æon", "Ueve", "niña", "niño", "Udet", "aegis", "oeuvre", "nits", "Uell", "aether", "Übelacker", "azure", 
        "œuf", "Uffenbach", "oedipal", "cote"};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length !=1) {
            System.exit(-1);
        }
        String locale = args[0];
        Locale l = new Locale(locale);
        
        Collator c = Collator.getInstance(l);
        Arrays.sort(WORDS,c);
        System.out.printf("Locale: %s\n", l);
        
        for(int x = 0; x < WORDS.length; x++) {
            System.out.printf("%s\n", WORDS[x]);
        }
    }
    
}
