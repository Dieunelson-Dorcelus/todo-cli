package parser;

import repository.TaskList;

public class ListParser implements JSONParser<TaskList> {


	/**
	 * Get an object from
	 *
	 * @param json string with json format
	 * @return an objet of type <T>
	 */
	@Override
	public TaskList getObject(String json) {
		return null;
	}

	/**
	 * Parse an object in JSON
	 *
	 * @param object object of type <T>
	 * @return a string with JSON format
	 */
	@Override
	public String parse(TaskList object) {
		return null;
	}
}
