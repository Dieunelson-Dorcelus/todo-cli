package parser;

import org.json.JSONArray;
import org.json.JSONObject;
import repository.Comment;
import repository.Task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class TaskParser implements JSONParser<Task> {

	/**
	 * Get an object from
	 *
	 * @param json string with json format
	 * @return an objet of type <T>
	 */
	@Override
	public Task getObject(String json) {
		JSONObject o = new JSONObject(json);
		String title = (String) o.get("title");
		String description = (String) o.get("description");
		String time = (String) o.get("created");
		Date created = new Date(Long.parseLong(time));
		JSONArray comments_json = (JSONArray) o.get("comments");

		ArrayList<Comment> comments = new ArrayList<>();
		CommentParser commentParser = new CommentParser();
		for (Object comment : comments_json) {
			comments.add(commentParser.getObject(comment.toString()));
		}

		return new Task(title, description, created, comments);
	}

	/**
	 * Parse an object in JSON
	 *
	 * @param object object of type <T>
	 * @return a string with JSON format
	 */
	@Override
	public String parse(Task object) {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"title\":\""+object.getTitle()+"\",");
		builder.append("\"description\":\""+object.getDescription()+"\",");
		builder.append("\"created\":\""+object.getCreated().getTime()+"\",");

		builder.append("\"comments\": [");
		CommentParser commentParser = new CommentParser();
		for (int i = 0; i < object.getComments().size(); i++){
			Comment comment = object.getComments().get(i);
			if (i==object.getComments().size()-1){
				builder.append(commentParser.parse(comment));
			}else{
				builder.append(commentParser.parse(comment)+",");
			}
		}
		builder.append("]}");

		return builder.toString();
	}
}
