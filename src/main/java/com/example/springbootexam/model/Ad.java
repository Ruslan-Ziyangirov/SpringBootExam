package com.example.springbootexam.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ades")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ad;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private Date date;

    @Column(name = "text")
    private String text;
}
