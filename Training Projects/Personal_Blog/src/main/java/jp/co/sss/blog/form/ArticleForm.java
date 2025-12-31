package jp.co.sss.blog.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ArticleForm {

	private Integer id;
	private String name;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
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
