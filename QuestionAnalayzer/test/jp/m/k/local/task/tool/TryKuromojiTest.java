package jp.m.k.local.task.tool;
import static org.junit.Assert.*;
import jp.m.k.local.task.tool.TryKuromoji;

import org.junit.Test;


public class TryKuromojiTest {

	@Test
	public void test() {
		TryKuromoji kuromoji = new TryKuromoji();
		kuromoji.tryKuromoji();
		assertTrue(true);
	}

}
