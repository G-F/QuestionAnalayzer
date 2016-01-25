package jp.m.k.local.task.tool;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.orangesignal.csv.manager.CsvEntityManager;

public class Ticket2CSVWriter {
	List<Word> words;

	public Ticket2CSVWriter(List<Word> words) {
		this.words = words;
	}

	public void write() throws IOException {
		CsvEntityManager entityManager = new CsvEntityManager();
		entityManager.save(words, Word.class).to(new FileWriter("resource/output/result.csv",true));
	}
	
	

}
