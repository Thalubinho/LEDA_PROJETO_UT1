package csv_io;

import java.io.File;

public class CSVReader {
	private final String path;
	
	public CSVReader(String name){
		this.path = name;
	}

	public CSVReader(String folder,String name){
		this.path = folder+ File.separator+name;
	}

	public String getPath() {
		return this.path;
	}

}
