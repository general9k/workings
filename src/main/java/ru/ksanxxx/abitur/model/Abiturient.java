package ru.ksanxxx.abitur.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "abiturient")
public class Abiturient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "date_of_birth", nullable = false)
    private OffsetDateTime dateOfBirth;

    @Column(name = "date_of_end")
    private OffsetDateTime dateOfEnd;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "education", referencedColumnName = "id", nullable = false)
    private Education education;

    @ManyToOne
    @JoinColumn(name = "address", referencedColumnName = "id", nullable = false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "achievement", referencedColumnName = "id", nullable = false)
    private Achievement achievement;

    @ManyToOne
    @JoinColumn(name = "speciality", referencedColumnName = "id", nullable = false)
    private Specialty speciality;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    private Category category;
}
