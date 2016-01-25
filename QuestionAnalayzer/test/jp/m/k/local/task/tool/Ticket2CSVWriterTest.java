package jp.m.k.local.task.tool;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Ticket2CSVWriterTest {

	List<Word> words;
	@Before
	public void setUp() {
		words = Arrays.asList(
				new Word("1", "タイトル", 1),
				new Word("2", "タイトル2", 2),
				new Word("3", "タイトル3", 3)
				);
	}

	@Test
	public void CSV書き込み() throws IOException {
		Ticket2CSVWriter writer = new Ticket2CSVWriter(words);
		writer.write();
	}

}
