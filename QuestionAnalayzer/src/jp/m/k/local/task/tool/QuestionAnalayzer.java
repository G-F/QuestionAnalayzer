package jp.m.k.local.task.tool;

import java.io.IOException;
import java.util.List;

public class QuestionAnalayzer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 処理順①CSVを読み込む②解析する③CSVに書き出す
		 */
		// ①CSVの読み込み
		CSVParser parser = new CSVParser(args[0]);
		List<Ticket> tickets = null;
		try {
			tickets = parser.parseCSV();
		} catch (IOException e) {
			System.out.println("CSV解析中にエラー");
			e.printStackTrace();
		}
		// ②チケットの解析
		for (Ticket ticket : tickets) {
			List<Word> words = ticket.countWorrds();

			Ticket2CSVWriter writer = new Ticket2CSVWriter(words);
			try {
				writer.write();
			} catch (IOException e) {
				System.out.println("CSV書き込み中にエラー");
				e.printStackTrace();
			}
		}

	}

}
