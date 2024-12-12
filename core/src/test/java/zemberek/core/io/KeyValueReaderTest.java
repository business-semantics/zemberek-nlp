package zemberek.core.io;

import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class KeyValueReaderTest {

  String key_value_colon_separator = URLDecoder.decode(Resources.getResource("io/key-value-colon-separator.txt").getPath());

  @Test
  public void testReader() throws IOException {
    Map<String, String> map = new KeyValueReader(":")
        .loadFromFile(new File(key_value_colon_separator));
    Assert.assertEquals(map.size(), 4);
    Assert.assertTrue(TestUtil.containsAllKeys(map, "1", "2", "3", "4"));
    Assert.assertTrue(TestUtil.containsAllValues(map, "bir", "iki", "uc", "dort"));
  }
}
