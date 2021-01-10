package repository;

import java.util.Date;

public class Comment {
    private String content;
    private Date created;

    public Comment(String content, Date created){
        this.content = content;
        this.created = created;
    }

    public Comment(String content){
        this(content, new Date());
    }

    public String getContent() {
        return content;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", created=" + created +
                '}';
    }
}
