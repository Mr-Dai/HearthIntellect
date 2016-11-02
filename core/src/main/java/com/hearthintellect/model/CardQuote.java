package com.hearthintellect.model;

import com.hearthintellect.utils.LocaleString;
import org.mongodb.morphia.annotations.Embedded;

/**
 * Quotes of a card
 */
@Embedded
public class CardQuote {

    private int HHID;
    private Type type;
    private LocaleString line;
    private String audioUrl;

    public CardQuote() {}

    public CardQuote(Type type, LocaleString line, String audioUrl) {
        this.type = type;
        this.line = line;
        this.audioUrl = audioUrl;
    }

    public void setHHID(int HHID) { this.HHID = HHID; }
    public int getHHID() { return HHID; }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public LocaleString getLine() {
        return line;
    }
    public void setLine(LocaleString line) {
        this.line = line;
    }
    public String getAudioUrl() {
        return audioUrl;
    }
    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public enum Type {
        Play, Attack, Death, Alternate, Trigger, Other
    }
}
