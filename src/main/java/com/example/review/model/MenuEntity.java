package com.example.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
@Getter
@Builder
@Table(name = "menu")
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long restaurantId;
    @Column
    private String name;
    @Column
    private Integer price;
    @Column
    private ZonedDateTime createAt;
    @Column
    private ZonedDateTime updateAt;

}
