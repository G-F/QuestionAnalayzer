package jp.m.k.local.task.tool;
import java.util.List;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;


public class TryKuromoji {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void tryKuromoji() {
		Tokenizer tokenizer = Tokenizer.builder().build();
		List<Token> tokens = tokenizer.tokenize("これはテストです");
		for (Token token : tokens) {
			System.out.print(token.getSurfaceForm());
			System.out.println(token.getPartOfSpeech());
		}
	}
}

