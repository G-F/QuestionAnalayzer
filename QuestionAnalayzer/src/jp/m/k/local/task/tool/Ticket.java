package jp.m.k.local.task.tool;

import java.util.ArrayList;
import java.util.List;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

import com.orangesignal.csv.annotation.CsvColumn;
import com.orangesignal.csv.annotation.CsvEntity;

/**
 * @author masao Redmineのチケットを表すクラス
 */
@CsvEntity(header = true)
public class Ticket {

	@CsvColumn(name = "No", position = 0)
	private String no;
	@CsvColumn(name = "題名", position = 1)
	private String title;
	@CsvColumn(name = "説明", position = 2)
	private String description;

	public Ticket() {
	}

	public Ticket(String no, String title, String description) {
		super();
		this.no = no;
		this.title = title;
		this.description = description;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Word> countWorrds() {
		Tokenizer tokenizer = Tokenizer.builder().build();
		List<Token> tokenize = tokenizer.tokenize(description);
		List<Word> words = new ArrayList<Word>();

		for (Token token : tokenize) {
			String word = token.getSurfaceForm();
			Word target = new Word(no, word);
			if (words.contains(target)) {
				Word existing = words.get(words.indexOf(target));
				existing.setCount(existing.getCount() + 1);
			} else {
				target.setCount(1);
				words.add(target);
			}
		}

		return words;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [no=" + no + ", title=" + title + ", description="
				+ description + "]";
	}

}
