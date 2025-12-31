package jp.co.sss.blog.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="articles")

public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_articles_gen")
	@SequenceGenerator(name = "seq_articles_gen", sequenceName = "seq_articles", allocationSize = 1)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column(name="delete_flag")
	private Integer deleteFlag = 0;
	
	@Column
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

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	
	
}
