package csv_io;

import java.io.File;

public class CSVWriter {
	private final String path;
	
	public CSVWriter(String folder, String name){
		this.path = folder + File.separator + name;
	}
	
	public String getPath() {
		return path;
	}
	
	
}
