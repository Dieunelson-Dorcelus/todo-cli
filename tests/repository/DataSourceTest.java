package repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.ListParser;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DataSourceTest {

    private ListParser parser;
    private String json;
    private DataSource source;

    @BeforeEach
    void setUp() {
        this.parser = new ListParser();
        this.json = "{\"name\":\"The name\",\"created\":\"1610240405874\",\"tasks\": [{\"title\":\"The title\",\"description\":\"The description\",\"created\":\"1610240405874\",\"comments\": [{\"content\":\"The Comment\",\"created\":\"1610240405874\"},{\"content\":\"The Comment\",\"created\":\"1610240405874\"}]}]}";
        this.source = new DataSource();
    }
    @Test
    void getInstance() {
        try {
            System.out.println(this.source.getObject(Path.of("./testList.json"), this.parser));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void save() {
        try {
            this.source.save(this.parser.getObject(this.json), Path.of("./testList.json"), this.parser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}