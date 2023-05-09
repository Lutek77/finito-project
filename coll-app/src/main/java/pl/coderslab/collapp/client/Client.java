package pl.coderslab.collapp.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.collapp.product.Product;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "name")
    private String firstName;
    @NotBlank
    @Column(name = "surname")
    private String lastName;
    @NotBlank
    @Column(unique = true, length = 11 )
    private String pesel;
    @NotBlank
    private String address;
    @NotBlank
    private String email;
    private Integer phoneNumber;

    // relation
    @NotBlank
    @OneToMany
    @JoinColumn(name="id_client")
    private List<Product> productList = new ArrayList<>();

}
