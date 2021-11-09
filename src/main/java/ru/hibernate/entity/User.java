package ru.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_data", schema = "todolist", catalog = "postgres")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public User(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;

    @Basic
    @Column(name = "userpassword", nullable = false, length = -1)
    private String password;

    @Basic
    @Column(name = "username", nullable = false, length = -1)
    private String username;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Category> categoryList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Priority> priorityList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
