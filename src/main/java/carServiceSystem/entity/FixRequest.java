package carServiceSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "requests")

public class FixRequest {

    @Id
    @GeneratedValue
    private String id;

    @Column
    private Date date;
    @Column
    private Long carId;
    @Column
    private String diagonose;

//    @OneToOne
//    @JoinColumn(name = "fix_request_id")
//    private User user;
//
//    @OneToOne
//    @JoinColumn(name = "fix_id")
//    private Car car;
}
