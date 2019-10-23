package hello.model;

import hello.model.Comment;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="posts")
public class Posts extends AuditModel<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    @Lob
    private String content;

    public Posts(){}

    @Override
    public String toString() {
        return String.format(
                "Post : [id=%d, name='%s', content='%s']",
                id, name, content);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @OneToMany(mappedBy = "posts")
    private Set<Comment> comment;

}
