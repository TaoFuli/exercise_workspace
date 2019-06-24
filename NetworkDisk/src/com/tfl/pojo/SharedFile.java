package com.tfl.pojo;

public class SharedFile {
	private int sid;			//共享id
	private String randomFileName;//随机产生的文件
	private String fileName;	//文件名
	private String filePath;	//文件路径
	private String fileType;	//文件类型
	private String loginName;	//共享者
	private String sharedTime;	//共享截止日期
	private String sCreateTime;	//共享创建日期
	public SharedFile() {	}
	public SharedFile(int sid,String randomFileName, String fileName, String filePath, String fileType, String loginName, String sharedTime,
			String sCreateTime) {
		super();
		this.sid = sid;
		this.randomFileName=randomFileName;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileType = fileType;
		this.loginName = loginName;
		this.sharedTime = sharedTime;
		this.sCreateTime = sCreateTime;
	}
	
	public String getRandomFileName() {
		return randomFileName;
	}
	public void setRandomFileName(String randomFileName) {
		this.randomFileName = randomFileName;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getSharedTime() {
		return sharedTime;
	}
	public void setSharedTime(String sharedTime) {
		this.sharedTime = sharedTime;
	}
	public String getsCreateTime() {
		return sCreateTime;
	}
	public void setsCreateTime(String sCreateTime) {
		this.sCreateTime = sCreateTime;
	}
	@Override
	public String toString() {
		return "SharedFile [sid=" + sid + ", fileName=" + fileName + ", filePath=" + filePath + ", fileType=" + fileType
				+ ", loginName=" + loginName + ", sharedTime=" + sharedTime + ", sCreateTime=" + sCreateTime + "]";
	}
	
}
