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

    // relations
    // with client
    @ManyToOne
    private Client client;

    // with details
    @OneToMany(mappedBy = "product")
    private List<Detail> detailList;

    // with type
    @OneToOne
    private Type type;


    // Test
/*    @OneToOne
    @MapsId
    @JoinColumn(name = "id")*/
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Detail detail;

}
/*
@NotNull: a constrained CharSequence, Collection, Map, or Array is valid as long as it's not null, but it can be empty.
@NotEmpty: a constrained CharSequence, Collection, Map, or Array is valid as long as it's not null, and its size/length is greater than zero.
@NotBlank: a constrained String is valid as long as it's not null, and the trimmed length is greater than zero.
*/

