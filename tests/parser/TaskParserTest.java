package parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Comment;
import repository.Task;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskParserTest {

    private TaskParser parser;
    private String json;

    @BeforeEach
    void setUp() {
        this.parser = new TaskParser();
        this.json = "{\"title\":\"The title\",\"description\":\"The description\",\"created\":\"1610240405874\",\"comments\": [{\"content\":\"The Comment\",\"created\":\"1610240405874\"},{\"content\":\"The Comment\",\"created\":\"1610240405874\"}]}";
    }

    @Test
    void getObject() {
        Task t = this.parser.getObject(this.json);
        System.out.println("Object => " + t);
    }

    @Test
    void parse() {
        Comment comment = new Comment("The Comment", new Date(Long.parseLong("1610240405874")));
        ArrayList<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment);
        Task task = new Task("The title", "The description", new Date(Long.parseLong("1610240405874")), comments);
        System.out.println(this.parser.parse(task));
    }
}