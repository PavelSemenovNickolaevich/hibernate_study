package ru.hibernate.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "priority", schema = "todolist", catalog = "postgres")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Priority {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;

    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")  //foreign key
    private User user;

}
