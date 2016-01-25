package jp.m.k.local.task.tool;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CSVParserTest {
	CSVParser parser;
	Ticket[] testTickets;
	@Before
	public void setUp() {
		 parser = new CSVParser("resource/test.csv");
		 testTickets = new Ticket[]{
				 new Ticket("6942", "いいねいいね", "テスト"),
				 new Ticket("6940", "damedame", "テスト"),
				 new Ticket("6853", "なんか動かない", "なんかこれが動かない"),
				 new Ticket("3029", "テスト作成", "テスト"),
				 new Ticket("3028", "チケットテスト", "テスト"),
				 };
	}
	@Test
	public void CSVを読み込む() throws IOException {
		List<Ticket> tickets = parser.parseCSV();
		for (int i = 0; i < tickets.size(); i++) {
			assertThat(tickets.get(i), is(testTickets[i]));
		}
		// 配列を解析するMatcherが必要
	}

}
