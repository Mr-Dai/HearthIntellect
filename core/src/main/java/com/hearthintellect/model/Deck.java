package com.hearthintellect.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.utils.IndexType;

/**
 * Entity for Deck
 * @author Robert Peng
 */
@Entity(value = "decks", noClassnameStored = true)
@Indexes({
         @Index(fields = @Field(value = "name", type = IndexType.TEXT)),
         @Index(fields = @Field("class"))
})
public class Deck extends MongoEntity<Long> implements JsonEntity {

	@Id
	private long deckId;

	private String name;
    private String content;
	private int like;
    private int dislike;
    @Property("class")
	private HeroClass classs;
    @Embedded(concreteClass = ArrayList.class)
	private List<DeckEntry> cards;

    @Reference(idOnly = true)
	private Patch patch;
    private boolean active = true;

    private LocalDateTime postedDate;
    private LocalDateTime lastModified;

    @Override
    public JSONObject toJson() {
        JSONObject result = new JSONObject();

        result.put("id", deckId);
        result.put("name", name);
        result.put("content", content);
        result.put("like", like);
        result.put("dislike", dislike);
        result.put("heroClass", classs.ordinal());
        result.put("patch", patch.getId());
        result.put("active", active);
        result.put("postedDate", postedDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        result.put("lastModified", lastModified.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        cards.forEach((card) -> result.append("cards", card.toJson()));

        return result;
    }

	public long getDeckId() {
		return deckId;
	}
	public void setDeckId(long deckId) {
		this.deckId = deckId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DeckEntry> getCards() {
		return cards;
	}
	public void setCards(List<DeckEntry> cards) {
		this.cards = cards;
	}
	@Override
	public Long getId() {
		return deckId;
	}
	@Override
	public void setId(Long id) {
		deckId = id;
	}
    public HeroClass getClasss() {
        return classs;
    }
    public void setClasss(HeroClass classs) {
        this.classs = classs;
    }
    public int getLike() {
        return like;
    }
    public void setLike(int like) {
        this.like = like;
    }
    public int getDislike() {
        return dislike;
    }
    public void setDislike(int dislike) {
        this.dislike = dislike;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public Patch getPatch() {
        return patch;
    }
    public void setPatch(Patch patch) {
        this.patch = patch;
    }
    public LocalDateTime getPostedDate() {
        return postedDate;
    }
    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = postedDate;
    }
    public LocalDateTime getLastModified() {
        return lastModified;
    }
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
}
