package parser;

import org.json.JSONObject;
import repository.Comment;

import java.sql.Date;
import java.sql.Timestamp;

public class CommentParser implements JSONParser<Comment> {

    /**
     * Get an object from
     *
     * @param json string with json format
     * @return an objet of type <T>
     */
    @Override
    public Comment getObject(String json) {
        JSONObject o = new JSONObject(json);
        String content = (String) o.get("content");
        Timestamp ts = new Timestamp((Long) o.get("created"));
        Date created = new Date(ts.getTime());
        return new Comment(content, created);
    }

    /**
     * Parse an object in JSON
     *
     * @param object object of type <T>
     * @return a string with JSON format
     */
    @Override
    public String parse(Comment object) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"content\":"+object.getContent()+",");
        Timestamp ts = new Timestamp(object.getCreated().getTime());
        builder.append("\"created\":"+ts+"}");
        return builder.toString();
    }
}
