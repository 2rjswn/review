package com.example.review.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant")
@Entity
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String adress;
    @Column
    private ZonedDateTime createAt;
    @Column
    private ZonedDateTime updateAt;
}
