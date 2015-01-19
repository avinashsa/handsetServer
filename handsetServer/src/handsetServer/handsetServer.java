package handsetServer;

public class handsetServer {

	public static void main(String[] args) {
		
		
		CollectionFileReader collectionFileReader = new CollectionFileReader();
		
		collectionFileReader.readCollectionFiles();
		
		collectionFileReader.verifyAllFiles();
		
		
	}

}
