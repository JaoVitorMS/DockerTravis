package org.zsh.dockertravisgradle.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private StatusProduct statusProduct;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.statusProduct = StatusProduct.RECEBIDO;
    }
}
