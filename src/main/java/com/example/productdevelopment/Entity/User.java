package com.example.productdevelopment.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @Column(unique = true)
    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is required")
    private String email;
    @Size(min = 6, message = "Password must be at least 6 characters")
    @NotBlank(message = "Password is required")
    private String password;
    private String phoneNo;
    private String address;
    @Enumerated(EnumType.STRING)

    private Role role;
    /*@ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    //private Collection<Role> roles = new HashSet<>();
    private List<Role> roles;*/

}
