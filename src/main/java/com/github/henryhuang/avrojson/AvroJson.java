package com.github.henryhuang.avrojson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;

/**
 * 
 * 
 * @author <a href="mailto:h1886@outlook.com">Henry Huang</a>
 * @version 9:28:20 PM Nov 20, 2016
 * @since 1.8.1
 */
public class AvroJson {

	/**
	 * Convert an avro record to JSON format string, not pretty.
	 * 
	 * @param genericRecord
	 *            an avro record
	 * 
	 * @throws IOException
	 *             Some related class throws
	 * @return avro object's JSON format string
	 * 
	 */
	public static String recordToJson(GenericRecord genericRecord) throws IOException {
		return recordToJson(genericRecord, false);
	}

	/**
	 * Convert an avro record to JSON format string.
	 * 
	 * @param genericRecord
	 *            an avro record
	 * @param pretty
	 *            pretty the json string if true
	 * 
	 * @throws IOException
	 *             Some related class throws
	 * @return avro object's JSON format string
	 * 
	 */
	public static String recordToJson(GenericRecord genericRecord, boolean pretty) throws IOException {

		Schema schema = genericRecord.getSchema();
		DatumWriter<Object> writer = new GenericDatumWriter<Object>(schema);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		JsonEncoder encoder = EncoderFactory.get().jsonEncoder(schema, output, pretty);
		writer.write(genericRecord, encoder);
		encoder.flush();

		return new String(output.toByteArray(), "UTF-8");

	}

}
