package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float credit;

    @Column(nullable = false)
    private String type;

    // One-to-One relationship with Student
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private Student student;

}
