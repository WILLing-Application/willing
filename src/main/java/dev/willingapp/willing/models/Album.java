package dev.willingapp.willing.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    Ties to the owner_id of this album
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

//    album_user table
    @ManyToMany(mappedBy = "albums")
    private List<User> users;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @Column(length = 50)
    private String lineage;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private String deadline;

    @Column(columnDefinition = "TINYINT(1) UNSIGNED DEFAULT '1'")
    private int isActive;

//    Invites Table
    @OneToMany(mappedBy = "album")
    private List<Invite> invites;

//    Items Table
    @OneToMany(mappedBy = "albumForItems")
    private List<Item> items;

    public Album() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLineage() {
        return lineage;
    }

    public void setLineage(String lineage) {
        this.lineage = lineage;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Invite> getInvites() {
        return invites;
    }

    public void setInvites(List<Invite> invites) {
        this.invites = invites;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
