package JDBC_3.xml;

public class DBInfo {
	private String url;
	private String driver;
	private String username;
	private String password;
	private String dbName;
	private String attUser;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getAttUser() {
		return attUser;
	}
	public void setAttUser(String attUser) {
		this.attUser = attUser;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return dbName + "," + url + "," + driver +
				"," + username + "," + password + "," + attUser;
	}
}
