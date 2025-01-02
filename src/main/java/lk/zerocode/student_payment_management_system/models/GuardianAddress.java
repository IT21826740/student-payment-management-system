package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "guardian_address")
public class GuardianAddress {

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

    @OneToOne(mappedBy = "guardianAddress") // Address is referenced by Guardian
    private Guardian guardian;

    public GuardianAddress() {}

    public GuardianAddress(Long id, String street, String city, String zipCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}
