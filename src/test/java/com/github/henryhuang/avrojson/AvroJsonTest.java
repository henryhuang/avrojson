package com.github.henryhuang.avrojson;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * 
 * @author <a href="mailto:h1886@outlook.com">Henry Huang</a>
 * @version 9:53:23 PM Nov 20, 2016
 * 
 */
public class AvroJsonTest {

	@Test
	public void testAvroObjectToJsonNoPretty() throws IOException {
		testAvroObjectToJson(false);
	}

	@Test
	public void testAvroObjectToJsonPretty() throws IOException {
		testAvroObjectToJson(true);
	}

	private void testAvroObjectToJson(boolean pretty) throws IOException {

		AvroDemo avroDemo = new AvroDemo();
		avroDemo.setName("AvroDemo");
		avroDemo.setVersion(181);
		avroDemo.setVersionUuid("1.8.1");

		String jsonString = null;
		try {
			jsonString = AvroJson.avroObjectToJson(avroDemo, AvroDemo.class, avroDemo.getSchema(), pretty);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		assertEquals(getExpectedString(pretty), jsonString);
	}

	private String getExpectedString(boolean pretty) throws IOException {

		String fileName = pretty ? "AvroDemoPretty.json" : "AvroDemo.json";
		StringBuilder builder = new StringBuilder();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				builder.append(line);
				if (scanner.hasNextLine()) {
					builder.append("\n");
				}
			}
		}
		return builder.toString();
	}

}
