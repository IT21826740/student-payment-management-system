package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "guardians")
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guardian_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "fiscal_code", nullable = false)
    private String fiscalCode;

    @Column(nullable = false)
    private String relation;

    private String guardianAddress;

    @ElementCollection
    @CollectionTable(name = "guardian_mobile_numbers", joinColumns = @JoinColumn(name = "guardian_id"))
    @Column(name = "mobile_number")
    private List<String> mobileNumber;

    //relationship mapping

    @OneToMany(mappedBy = "guardian", cascade = CascadeType.ALL)
    private List<Student> students;

}

