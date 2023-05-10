package pl.coderslab.collapp.client;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"id", "firstName", "lastName", "pesel", "phoneNumber", "address", "email"})
public class ClientDTOTwo {
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
    @Column(unique = true, length = 11)
    private String pesel;
    @NotBlank
    private String address;
    @NotBlank
    private String email;
    private Integer phoneNumber;

}
