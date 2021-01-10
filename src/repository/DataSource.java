package repository;

import parser.JSONParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataSource <T> {

	public T getInstance(Path name, JSONParser<T> parser) throws IOException {
		List<String> content = Files.readAllLines(name, StandardCharsets.UTF_8);
		StringBuilder builder = new StringBuilder();
		for (String s: content) {
			builder.append(s);
		}
		return parser.getObject(builder.toString());
	}
	public void save(T object, Path name, JSONParser<T> parser) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(name)));
		writer.write(parser.parse(object));
		writer.close();
	}
}
