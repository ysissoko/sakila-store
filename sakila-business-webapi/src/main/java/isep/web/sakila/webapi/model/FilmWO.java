package isep.web.sakila.webapi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.FilmActor;
import isep.web.sakila.jpa.entities.FilmCategory;
import isep.web.sakila.jpa.entities.Inventory;
import isep.web.sakila.jpa.entities.Language;

public class FilmWO extends WebObject {

	private static final long serialVersionUID = -8494386839845787279L;
	private int filmId;
	private String title;
	private String description;
	private Date releaseYear;
	private int language;
	private Language originalLanguage;
	private byte rentalDuration;
	private BigDecimal rentalRate;
	private int length;
	private BigDecimal replacementCost;
	private String rating;
	private String specialFeatures;
	private Timestamp lastUpdate;
	private List<FilmActor> actors;
	private List<FilmCategory> categories;
	private List<Inventory> inventories;

	public FilmWO() {
		super();
	}

	public FilmWO(int filmId, String title, String description, Date releaseYear, int language,
			Language originalLanguage, byte rentalDuration, BigDecimal rentalRate, int length,
			BigDecimal replacementCost, String rating, String specialFeatures, List<FilmActor> actors,
			List<FilmCategory> categories, List<Inventory> inventories, Timestamp lastUpdate) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.language = language;
		this.originalLanguage = originalLanguage;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.lastUpdate = lastUpdate;
		this.actors = actors;
		this.categories = categories;
		this.inventories = inventories;
	}

	public FilmWO(final Film film) {
		super();
		this.filmId = film.getFilmId();
		this.title = film.getTitle();
		this.description = film.getDescription();
		this.releaseYear = film.getReleaseYear();
		this.language = film.getLanguage1().getLanguageId();
		this.originalLanguage = film.getLanguage2();
		this.rentalDuration = film.getRentalDuration();
		this.rentalRate = film.getRentalRate();
		this.length = film.getLength();
		this.replacementCost = film.getReplacementCost();
		this.rating = film.getRating();
		this.specialFeatures = film.getSpecialFeatures();
		this.lastUpdate = film.getLastUpdate();
		this.categories = film.getFilmCategories();
		this.actors = film.getFilmActors();
		this.inventories = film.getInventories();
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public Language getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(Language originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public byte getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<FilmActor> getActors() {
		return actors;
	}

	public void setActors(List<FilmActor> actors) {
		this.actors = actors;
	}

	public List<FilmCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<FilmCategory> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "FilmWO [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", language=" + language + ", originalLanguage=" + originalLanguage
				+ ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
				+ ", replacementCost=" + replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures
				+ ", lastUpdate=" + lastUpdate + ", actors=" + actors + ", categories=" + categories + "]";
	}

}
