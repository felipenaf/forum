package github.io.forum.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties({"question", "password"})
    private UserEntity user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date", nullable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date creationDate = new Date();

    @Column(name="deleted", nullable = false, columnDefinition = "tinyint default false")
    private boolean deleted;

    @OrderBy("id DESC")
    @OneToMany( mappedBy = "question" , fetch = FetchType.LAZY )
    @JsonIgnoreProperties("question")
    private Set<AnswerEntity> answer;

    public QuestionEntity() {}

    public QuestionEntity(String content, UserEntity user) {
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
