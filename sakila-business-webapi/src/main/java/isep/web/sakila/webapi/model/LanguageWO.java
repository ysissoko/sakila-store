package isep.web.sakila.webapi.model;

import java.sql.Timestamp;
import isep.web.sakila.jpa.entities.Language;

public class LanguageWO extends WebObject {

	private static final long serialVersionUID = 1L;
	private int languageId;
	private Timestamp lastUpdate;
	private String name;
	
	public LanguageWO(){
		super();
	}
	
	public LanguageWO(int languageId, Timestamp lastUpdate, String name)
	{
		super();
		this.languageId = languageId;
		this.lastUpdate = lastUpdate;
		this.name = name;
	}

	public LanguageWO(final Language language){
		super();
		this.languageId = language.getLanguageId();
		this.name = language.getName();
		this.lastUpdate = language.getLastUpdate();
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
