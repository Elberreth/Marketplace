package se.lexicon.advertisement_creation_api.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "User")
@Getter
@Setter
@ToString

public class User {

    String username;
    String password;


    @Id

    @Column(unique = true)
    String email;
    @OneToMany
    @JoinTable
            (name = "User_SellAds",
                    joinColumns = @JoinColumn(name = "ad_id"),
                    inverseJoinColumns = @JoinColumn(name = "ad_id"))
    List<Advertisement> sellAdvertisements = new ArrayList<>();
    @OneToMany
            @JoinTable
    List<Advertisement> buyAdvertisements = new ArrayList<>();


    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

    }

    public void addSellAd(Advertisement ad) {
        if (ad == null) throw new IllegalArgumentException("Ad was null");

        sellAdvertisements.add(ad);
    }

    public void addBuyAd(Advertisement ad) {
        if (ad == null) throw new IllegalArgumentException("Ad was null");

        buyAdvertisements.add(ad);
    }

    public void removeSellAd(Advertisement ad) {
        if (ad == null) throw new IllegalArgumentException("Ad was null");

        sellAdvertisements.remove(ad);

    }

    public void removeBuyAd(Advertisement ad) {
        if (ad == null) throw new IllegalArgumentException("Ad was null");

        buyAdvertisements.remove(ad);
    }
}
