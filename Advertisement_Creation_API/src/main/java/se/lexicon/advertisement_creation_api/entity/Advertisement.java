package se.lexicon.advertisement_creation_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import se.lexicon.advertisement_creation_api.util.AdType;
import se.lexicon.advertisement_creation_api.util.Category;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String description;
    private int price;
    private LocalDateTime expirationDate;

    @ManyToOne
    @JoinColumn (name = "Creator_id")
    private User creator;
    @ManyToMany
    private List<User> interestedUsers = new ArrayList<>();
    private Category category;
    private AdType adType;

    public Advertisement(String description, int price, LocalDateTime expirationDate, User creator, Category category, AdType adType) {
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
        this.creator = creator;
        this.category = category;
        this.adType = adType;
    }
    public void addInterestedUser(User user){
        if (user == null) throw new IllegalArgumentException("User was null");

        interestedUsers.add(user);
    }
    public void removeInterestedUser(User user){
        if(user == null) throw new IllegalArgumentException("User was null");

        interestedUsers.remove(user);


    }}

