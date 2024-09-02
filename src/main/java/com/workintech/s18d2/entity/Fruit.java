package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "fruit", schema = "fsweb")
public class Fruit {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long  id;
 private String  name;
 private Double  price;
 private FruitType  fruitType;

}
