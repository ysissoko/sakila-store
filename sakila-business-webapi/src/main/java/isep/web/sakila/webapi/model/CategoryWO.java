package isep.web.sakila.webapi.model;

import java.sql.Timestamp;

import isep.web.sakila.jpa.entities.Category;

public class CategoryWO extends WebObject{

	protected static final long serialVersionUID = 1L;
	protected int categoryId;
	protected String name;
	protected Timestamp lastUpdate;
	
	public CategoryWO()
	{
		super();
	}

	public CategoryWO(int categoryId, String name, Timestamp lastUpdate)
	{
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.lastUpdate = lastUpdate;
	}

	public CategoryWO(final Category category)
	{
		super();
		this.categoryId = category.getCategoryId();
		this.name = category.getName();
		this.lastUpdate = category.getLastUpdate();
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
