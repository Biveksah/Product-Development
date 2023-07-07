package com.example.productdevelopment.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String firstName;
    private String lastName;
    private String message;
    private String phoneNo;
    private String email;
}

