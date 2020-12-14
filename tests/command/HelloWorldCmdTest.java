package command;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldCmdTest {


    HelloWorldCmd hello;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Recreate hello object before each test
        hello = new HelloWorldCmd();
    }

    @org.junit.jupiter.api.Test
    void runHello() {
        String[] hello_cmd = {""};
        hello.run(hello_cmd);
    }

    @org.junit.jupiter.api.Test
    void runHelp() {
        String[] hello_help_cmd = {"--help"};
        hello.run(hello_help_cmd);
    }

    @org.junit.jupiter.api.Test
    void sayHello() {
        hello.sayHello();
    }

    @org.junit.jupiter.api.Test
    void help() {
        hello.help();
    }
}