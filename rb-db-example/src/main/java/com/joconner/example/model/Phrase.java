package com.joconner.example.model;

import java.util.Locale;

/**
 * Created by John O'Conner on 10/13/14.
 */
public class Phrase {
    private Long id;
    private Locale language;
    private String key;
    private String phrase;

    public Phrase() {
    }

    public Phrase(Locale language, String key, String phrase) {
        this.language = language;
        this.key = key;
        this.phrase = phrase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Locale getLanguage() {
        return language;
    }

    public void setLanguage(Locale language) {
        this.language = language;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
