package zemberek.core.io;

import com.google.common.io.Resources;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

public class KeyValueReaderTest
{

	@Test
	public void testReader() throws IOException
	{
		try (final InputStream is = KeyValueReaderTest.class.getResourceAsStream("/io/key-value-colon-separator.txt");) {
			Map<String, String> map = new KeyValueReader(":").loadFromStream(is);
			Assert.assertEquals(map.size(), 4);
			Assert.assertTrue(TestUtil.containsAllKeys(map, "1", "2", "3", "4"));
			Assert.assertTrue(TestUtil.containsAllValues(map, "bir", "iki", "uc", "dort"));
		}
	}
}
