package dev.willingapp.willing.models;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 60, unique = true)
    private String email;

    @Column(nullable = false, length = 60, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 60)
    private String firstName;

    @Column(nullable = false, length = 60)
    private String lastName;

    @Column(nullable = false, length = 60)
    private String address1;

    @Column(length = 60)
    private String address2;

    @Column(nullable = false, length = 60)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false, length = 10)
    private String zip;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(columnDefinition = "TINYINT(1) UNSIGNED DEFAULT '1'")
    private int allowSms;

    @Column(columnDefinition = "TINYINT(1) UNSIGNED DEFAULT '0'")
    private int isActive;

    @Column(length = 150)
    private String profilePhoto;

// === Albums that the owner has created ===
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Album> ownerAlbums;

// === Albums that the guests are invited to ===
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "album_user",
            joinColumns = {@JoinColumn(name = "album_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<Album> albums;

//    Tied to interests table
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interestedUser")
    private List<Interest> interests;

//    Tied to comments table
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userComments")
    private List<Comment> comments;

    public User() {}

    // Copy constructor for authentication process (login/logout)
    // Called by UserWithRoles
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public User(long id, String email, String username, String password, String firstName, String lastName, String address1, String address2, String city, String state, String zip, String phone, int allowSms, int isActive, String profilePhoto, List<Album> ownerAlbums, List<Album> albums, List<Interest> interests, List<Comment> comments) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.allowSms = allowSms;
        this.isActive = isActive;
        this.profilePhoto = profilePhoto;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAllowSms() {
        return allowSms;
    }

    public void setAllowSms(int allowSms) {
        this.allowSms = allowSms;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public List<Album> getOwnerAlbums() {
        return ownerAlbums;
    }

    public void setOwnerAlbums(List<Album> ownerAlbums) {
        this.ownerAlbums = ownerAlbums;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
