package dev.willingapp.willing.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    Tied to items table
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemToComment;

//    Tied to users table
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userComments;

//    the parent_comment
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment parentComment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentComment")
    private List<Comment> comments;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String content;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private String createdAt;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private String updatedAt;

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItemToComment() {
        return itemToComment;
    }

    public void setItemToComment(Item itemToComment) {
        this.itemToComment = itemToComment;
    }

    public User getUserComments() {
        return userComments;
    }

    public void setUserComments(User userComments) {
        this.userComments = userComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
