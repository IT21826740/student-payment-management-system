package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @OneToOne(mappedBy = "studentAddress") // Address is referenced by Student
    private Student student;

    public StudentAddress() {}

    public StudentAddress(Long id, String street, String city, String zipCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}
