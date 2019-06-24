package com.tfl.pojo;

public class Files {
	private int id;
	private String filename;
	private String fileType;
	private String fileRoad;
	private String createtime;
	private int author_id;
	public Files() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Files(int id, String filename, String fileType, String fileRoad, String createtime, int author_id) {
		super();
		this.id = id;
		this.filename = filename;
		this.fileType = fileType;
		this.fileRoad = fileRoad;
		this.createtime = createtime;
		this.author_id = author_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileRoad() {
		return fileRoad;
	}
	public void setFileRoad(String fileRoad) {
		this.fileRoad = fileRoad;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	
}
