package handsetServer;

public class CollectionFileReader {
	
	DBHandle dbh = new DBHandle();
	
	public CollectionFileReader(){
		
		String serverName = "avinash";
		String portNumber = "1521";
		String sid = "AVIDB";
		String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
		String username = "hfs_preprod";
		String password = "hfs_preprod";
		
		dbh.connect(url,username,password);
	}
	
	public void readCollectionFiles() {
		dbh.runSql("blah blah");
	}
	
	public void verifyAllFiles() {
		System.out.println("verifying files thank you ");
	} 
}
