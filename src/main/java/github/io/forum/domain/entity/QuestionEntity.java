package github.io.forum.domain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "question" )
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String content;
    private String user;

    @OneToMany( mappedBy = "question" , fetch = FetchType.LAZY )
    private Set<AnswerEntity> answer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date", nullable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date creationDate = new Date();

    public QuestionEntity() {}

    public QuestionEntity(String content, String user) {
        this.content = content;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<AnswerEntity> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<AnswerEntity> answer) {
        this.answer = answer;
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

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user='" + user + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
