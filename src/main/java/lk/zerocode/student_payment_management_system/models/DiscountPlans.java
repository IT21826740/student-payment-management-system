package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "discount_plans")
public class DiscountPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private float percentage;

    @ManyToOne
    @JoinColumn(name = "intake_id", nullable = false)
    private Intake intake;

    private List<String> requirement;


}
