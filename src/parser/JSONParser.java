package parser;

public interface JSONParser<T> {
	public T getObject(String object);
	public String parse(T file);
}
