package jp.co.sss.blog.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ArticleBean implements Serializable {

	private Integer id;
	private String name;
	private String description;
	private Date insertDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

}
