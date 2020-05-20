package github.io.forum.models;

import java.util.Date;
import java.util.Set;

public class Question {

    private Integer id;
    private String content;
    private String user;
    private Date creationDate;
    private boolean deleted;
    private Set<Answer> answer;

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
    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public Set<Answer> getAnswer() {
        return answer;
    }
    public void setAnswer(Set<Answer> answer) {
        this.answer = answer;
    }

}
