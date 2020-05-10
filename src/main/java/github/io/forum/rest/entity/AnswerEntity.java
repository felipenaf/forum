package github.io.forum.rest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_question")
    private QuestionEntity question;

    private String content;
    private String user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date", nullable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date creationDate = new Date();

    public AnswerEntity() {}

    public AnswerEntity(QuestionEntity question, String content, String user) {
        this.question = question;
        this.content = content;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

}
