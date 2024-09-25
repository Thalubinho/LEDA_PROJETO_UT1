package csv_io;

public class CSVReader {
	private final String path;
	
	public CSVReader(String name){
		this.path = name;
	}
	
	public String getPath() {
		return this.path;
	}

}
