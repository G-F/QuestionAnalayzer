package jp.m.k.local.task.tool;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TicketTest {

	@Test
	public void チケットを比較する_同じ場合() throws Exception {
		Ticket ticket = new Ticket("1", "テスト", "テスト");
		assertThat(ticket, is(new Ticket("1", "テスト", "テスト")));
	}

	@Test
	public void チケットを比較する_違う場合() throws Exception {
		Ticket ticket = new Ticket("1", "テスト", "テスト");
		boolean check = ticket.equals(new Ticket("2", "テスト", "テスト"));
		assertThat(check, is(false));
	}

	@Test
	public void チケットを解析する() {
		Ticket ticket = new Ticket("1234", "テスト", "単語単語テスト");
		List<Word> words = ticket.countWorrds();;
		assertThat(words, hasItems(new Word("1234", "単語", 2),new Word("1234", "テスト", 1)));
		
	}
}
