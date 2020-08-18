package dev.willingapp.willing.models;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    Ties to albums table
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album albumForItems;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @Column(length = 50)
    private String lineage;

    @Column(columnDefinition = "TINYINT(1) UNSIGNED DEFAULT '0'")
    private int isPickupOnly;

    @Column(columnDefinition = "TINYINT(1) UNSIGNED DEFAULT '0'")
    private int hasShippingCost;

    @Column(columnDefinition = "DECIMAL(6,2) DEFAULT '0'")
    private double estShippingCost;

    @OneToOne
    private User user;

    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Album getAlbumForItems() {
        return albumForItems;
    }

    public void setAlbumForItems(Album albumForItems) {
        this.albumForItems = albumForItems;
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

    public int getIsPickupOnly() {
        return isPickupOnly;
    }

    public void setIsPickupOnly(int isPickupOnly) {
        this.isPickupOnly = isPickupOnly;
    }

    public int getHasShippingCost() {
        return hasShippingCost;
    }

    public void setHasShippingCost(int hasShippingCost) {
        this.hasShippingCost = hasShippingCost;
    }

    public double getEstShippingCost() {
        return estShippingCost;
    }

    public void setEstShippingCost(double estShippingCost) {
        this.estShippingCost = estShippingCost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
