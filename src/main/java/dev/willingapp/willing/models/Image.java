package dev.willingapp.willing.models;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    Tied to albums table
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album albumWithImages;

//    Tied to items table
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemImage;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false, length = 60)
    private String fileType;

    public Image() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Album getAlbumWithImages() {
        return albumWithImages;
    }

    public void setAlbumWithImages(Album albumWithImages) {
        this.albumWithImages = albumWithImages;
    }

    public Item getItemImage() {
        return itemImage;
    }

    public void setItemImage(Item itemImage) {
        this.itemImage = itemImage;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
