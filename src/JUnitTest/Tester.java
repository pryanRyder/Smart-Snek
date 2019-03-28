package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import CompareData.*;

class Tester {

	@Test
	void dataTest() {
		int[] a = { 1, 2, 4, 5, 6 };
		int[] b = { 1, 2, 4, 5, 6 };
		assertEquals(true, CompareIntArray.compareIntArray(a, b));
	}

}
