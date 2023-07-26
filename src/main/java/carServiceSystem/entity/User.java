package carServiceSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name ="users")
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;



//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
//    private List<Car> car;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
//    private List<FixRequest> fixRequest;


}
