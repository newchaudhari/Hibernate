package com.navin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String address;

    @ElementCollection
    @CollectionTable(name = "marks", joinColumns = @JoinColumn(name = "id"))
    private Map<String,Integer> marks;
}
