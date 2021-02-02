package repository;

import parser.JSONParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataSource {

	private static DataSource instance;

	public static DataSource getInstance(){
		if (DataSource.instance==null){
			DataSource.instance = new DataSource();
		}
		return DataSource.instance;
	}

	public Object getObject(Path name, JSONParser parser) throws IOException {
		List<String> content = Files.readAllLines(name, StandardCharsets.UTF_8);
		StringBuilder builder = new StringBuilder();
		for (String s: content) {
			builder.append(s);
		}
		return parser.getObject(builder.toString());
	}
	public void save(Object object, Path name, JSONParser parser) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(name)));
		writer.write(parser.parse(object));
		writer.close();
	}
}
