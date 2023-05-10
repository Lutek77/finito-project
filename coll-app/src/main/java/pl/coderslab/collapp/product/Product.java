package pl.coderslab.collapp.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.collapp.client.Client;
import pl.coderslab.collapp.detail.Detail;
import pl.coderslab.collapp.type.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "cannot be blank")
    @Column(unique = true)
    private String agreement;

    @NotBlank(message = "cannot be blank")
    @Column(unique = true, length = 28)
    private String iban;

    // relation
    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "product")
    private List<Detail> detailList;

    @OneToOne
    private Type type;

}











/*
@NotNull: a constrained CharSequence, Collection, Map, or Array is valid as long as it's not null, but it can be empty.
@NotEmpty: a constrained CharSequence, Collection, Map, or Array is valid as long as it's not null, and its size/length is greater than zero.
@NotBlank: a constrained String is valid as long as it's not null, and the trimmed length is greater than zero.
*/
