package ru.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    public Activity activity; //активность пользователя

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    public Stat stat; //общая статистика пользователя по всем задачам

    // если нам не нужна таблица UserRole и ее данные - мы можем просто сразу получить все Role пользователя
    @ManyToMany(fetch = FetchType.LAZY) // таблица role ссылается на user через промежуточную таблицу user_role
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
