package tw.com.eeit.midtermfix.connection;

import java.sql.Connection;

public class IOConnectionMemberBean {

private String fileName;
private String url;
private String generation;
private Connection conn;
public Connection getConn() {
	return conn;
}

public void setConn(Connection conn) {
	this.conn = conn;
}
public IOConnectionMemberBean(String url, String generation) {
	this.url=url;
	this.generation=generation;
}
public IOConnectionMemberBean() {
	// TODO Auto-generated constructor stub
}

public String getGeneration() {
	return generation;
}
public void setGeneration(String generation) {
	this.generation = generation;
}


public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}



public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}



 
}
