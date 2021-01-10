package parser;

import org.json.JSONArray;
import org.json.JSONObject;
import repository.Task;
import repository.TaskList;
import java.util.Date;
import java.util.HashMap;

public class ListParser implements JSONParser<TaskList> {


	/**
	 * Get an object from
	 *
	 * @param json string with json format
	 * @return an objet of type <T>
	 */
	@Override
	public TaskList getObject(String json) {
		JSONObject o = new JSONObject(json);

		String name = (String) o.get("name");
		String time = (String) o.get("created");
		Date created = new Date(Long.parseLong(time));
		JSONArray tasks_json = (JSONArray) o.get("tasks");

		HashMap<String,Task> tasks = new HashMap<>();
		TaskParser taskParser = new TaskParser();
		for (Object o1 : tasks_json) {
			Task t = taskParser.getObject(o1.toString());
			tasks.put(t.getTitle(), t);
		}

		return new TaskList(name, created, tasks);
	}

	/**
	 * Parse an object in JSON
	 *
	 * @param object object of type <T>
	 * @return a string with JSON format
	 */
	@Override
	public String parse(TaskList object) {

		StringBuilder builder = new StringBuilder();
		builder.append("{\"name\":\""+object.getName()+"\",");
		builder.append("\"created\":\""+object.getCreated().getTime()+"\",");
		builder.append("\"tasks\": [");
		Task[] tasks = object.getTasks().values().toArray(new Task[0]);
		TaskParser taskParser = new TaskParser();
		for (int i = 0; i < tasks.length; i++){
			if (i==tasks.length-1){
				builder.append(taskParser.parse(tasks[i]));
			}else{
				builder.append(taskParser.parse(tasks[i])+",");
			}
		}
		builder.append("]}");

		return builder.toString();
	}
}
