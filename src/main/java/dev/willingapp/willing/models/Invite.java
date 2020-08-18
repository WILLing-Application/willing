package dev.willingapp.willing.models;

import javax.persistence.*;

@Entity
@Table(name = "invites")
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private String createdAt;

    @Column(columnDefinition = "DATETIME NOT NULL")
    private String updatedAt;

//    Tied to album table
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Invite() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emaail) {
        this.email = emaail;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createAt) {
        this.createdAt = createAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
