package jp.m.k.local.task.tool;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.orangesignal.csv.manager.CsvEntityManager;

public class CSVParser {

	private String path;

	public CSVParser(String path) {
		this.path = path;
	}

	public List<Ticket> parseCSV() throws IOException {
		CsvEntityManager csvManager = new CsvEntityManager();
		List<Ticket> list = csvManager.load(Ticket.class).from(new FileReader(new File(path)));
		return list;
		
	}
	
	
	
	

}
