package parser;

/**
 * Parse object to Json
 * @param <T> type of object
 */
public interface JSONParser<T> {

	/**
	 * Get an object from
	 * @param json string with json format
	 * @return an objet of type <T>
	 */
	public T getObject(String json);

	/**
	 * Parse an object in JSON
	 * @param object object of type <T>
	 * @return a string with JSON format
	 */
	public String parse(T object);
}
