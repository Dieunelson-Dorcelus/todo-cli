package parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Comment;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CommentParserTest {

    private CommentParser parser;
    private String json;

    @BeforeEach
    void setUp() {
        this.parser = new CommentParser();
        this.json = "{\"content\":\"The content\",\"created\":\"1610240405874\"}";
    }

    @Test
    void parse() {
        Comment comment = new Comment("The content", new Date(Long.parseLong("1610240405874")));
        String result = this.parser.parse(comment);
        System.out.println("JSON => "+result);
    }

    @Test
    void getObject() {
        Comment c = this.parser.getObject(this.json);
        System.out.println("Object => " + c);
    }


}