package in.rahult.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import in.rahulit.beans.StringUtils;

public class StringUtilsTest {

	@Test
	public void testConvertToInt() {
		String st = null;
		assertThrows(IllegalArgumentException.class, () -> StringUtils.convertToInt(st));
	}
}
