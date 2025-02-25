package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lk.zerocode.student_payment_management_system.models.options.Gender;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "fiscal_code", nullable = false)
    private String fiscalCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String country;

    @Column(name = "special_needs", nullable = false)
    private String specialNeeds;

    @ElementCollection
    @CollectionTable(name = "student_mobile_numbers", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "mobile_number")
    private List<String> mobileNumber;

    @Column(nullable = false)
    private String email;

    private String address;

//relationship mapping

    //Current Plans
    // Relationship with PaymentPlans
    @ManyToOne
    @JoinColumn(name = "payment_plan_id", nullable = false) // Foreign key column in Student table
    private PaymentPlans paymentPlan;

    // Relationship with DiscountPlans
    @ManyToOne
    @JoinColumn(name = "discount_plan_id", nullable = false) // Foreign key column in Student table
    private DiscountPlans discountPlan;

    // One-to-Many relationship with Referrals
    @OneToMany(mappedBy = "referringStudent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Referral> referrals = new ArrayList<>();

    // relationship with guardian
    @ManyToOne
    @JoinColumn(name = "guardian_id", referencedColumnName = "guardian_id", nullable = false)
    private Guardian guardian;

    // One-to-One relationship with Balance
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Balance balance;

    // Many-to-Many relationship with Intake
    @ManyToMany
    @JoinTable(
            name = "student_intake",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "intake_id")
    )
    private List<Intake> intakes ;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendance;

    @OneToMany(mappedBy = "student")
    private List<FreeAccess> freeAccess ;

}
