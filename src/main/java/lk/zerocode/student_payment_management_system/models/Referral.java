package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lk.zerocode.student_payment_management_system.models.options.Relation;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "referrals")
public class Referral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "referral_id")
    private Long id;

    //foreign key
    @ManyToOne
    @JoinColumn(name = "referring_student_id", nullable = false)
    private Student referringStudent;

    @ManyToOne
    @JoinColumn(name = "referred_student_id", nullable = false, unique = true)
    private Student referredStudent;

    @Column(name = "referral_date", nullable = false)
    private LocalDate referralDate;

    @Column(name = "relation_or_not")
    private Relation relation;

}
