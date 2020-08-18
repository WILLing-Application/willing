package dev.willingapp.willing.models;

import javax.persistence.*;

@Entity
@Table(name = "interests")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    Tied to an interested user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User interestedUser;

//    Tied to items table
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(columnDefinition = "TINYINT(1) UNSIGNED DEFAULT '0'")
    private int interestRanking;

    @Column(columnDefinition = "TINYINT(1) UNSIGNED DEFAULT '0'")
    private int willPayShipping;

    public Interest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getInterestedUser() {
        return interestedUser;
    }

    public void setInterestedUser(User interestedUser) {
        this.interestedUser = interestedUser;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getInterestRanking() {
        return interestRanking;
    }

    public void setInterestRanking(int interestRanking) {
        this.interestRanking = interestRanking;
    }

    public int getWillPayShipping() {
        return willPayShipping;
    }

    public void setWillPayShipping(int willPayShipping) {
        this.willPayShipping = willPayShipping;
    }
}
