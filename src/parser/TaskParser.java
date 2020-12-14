package parser;

import repository.Task;

public class TaskParser implements JSONParser<Task> {

	/**
	 * Get an object from
	 *
	 * @param json string with json format
	 * @return an objet of type <T>
	 */
	@Override
	public Task getObject(String json) {
		return null;
	}

	/**
	 * Parse an object in JSON
	 *
	 * @param object object of type <T>
	 * @return a string with JSON format
	 */
	@Override
	public String parse(Task object) {
		return null;
	}
}
