package ma.ilisi2.library.models.bo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "cin", nullable = false, unique = true, length = 100)
    private String cin;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "phone")
    private String phone;

    public User() {
    }

    public User(Integer id, String name, String cin, LocalDateTime createdAt, String phone) {
        this.id = id;
        this.name = name;
        this.cin = cin;
        this.createdAt = createdAt;
        this.phone = phone;
    }

    public User(String name, String cin, LocalDateTime createdAt, String phone) {
        this.name = name;
        this.cin = cin;
        this.createdAt = createdAt;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

