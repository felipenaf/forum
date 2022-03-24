package github.io.forum.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties({"question", "password"})
    private UserEntity user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date", nullable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date creationDate = new Date();

    public AnswerEntity() {}

    public AnswerEntity(QuestionEntity question, String content, UserEntity user) {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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

    public QuestionEntity getQuestion() {
        return question;
    }
}
