package parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Comment;
import repository.Task;
import repository.TaskList;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ListParserTest {

    private ListParser parser;
    private String json;

    @BeforeEach
    void setUp() {
        this.parser = new ListParser();
        this.json = "{\"name\":\"The name\",\"created\":\"1610240405874\",\"tasks\": [{\"title\":\"The title\",\"description\":\"The description\",\"created\":\"1610240405874\",\"comments\": [{\"content\":\"The Comment\",\"created\":\"1610240405874\"},{\"content\":\"The Comment\",\"created\":\"1610240405874\"}]}]}";
    }
    @Test
    void getObject() {
        TaskList l = this.parser.getObject(this.json);
        System.out.println("Object => " + l);
    }

    @Test
    void parse() {
        Comment comment = new Comment("The Comment", new Date(Long.parseLong("1610240405874")));
        ArrayList<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment);
        Task task = new Task("The title", "The description", new Date(Long.parseLong("1610240405874")), comments, false);
        HashMap<String,Task> tasks = new HashMap<>();
        tasks.put("The title", task);
        TaskList list = new TaskList("The name", new Date(Long.parseLong("1610240405874")), tasks);
        System.out.println(this.parser.parse(list));
    }
}