package csv_io;

import java.io.*;

public class CSVWriter {
	private final String path;
	
	public CSVWriter(String name){
		this.path = "transformations" + File.separator + name;
	}
	
	public String getPath() {
		return path;
	}
	
	
}
