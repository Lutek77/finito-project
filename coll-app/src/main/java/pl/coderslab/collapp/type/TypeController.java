package pl.coderslab.collapp.type;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/types")
public class TypeController {
    private final TypeService typeService;
    private final TypeRepository typeRepository;

    public TypeController(TypeService typeService, TypeRepository typeRepository) {
        this.typeService = typeService;
        this.typeRepository = typeRepository;
    }

    // add
    @Operation(summary = "update type")
    @PostMapping
    public ResponseEntity<TypeDTO> addClient(@RequestBody @Valid TypeDTO type) {
        TypeDTO typeDTO = typeService.addType(type);
        return ResponseEntity.ok(typeDTO);
    }

    // update
    @Operation(summary = "update type")
    @PutMapping("/{id}")
    public ResponseEntity<TypeDTO> updateType(@PathVariable Long id, @RequestBody TypeDTO type) {
        TypeDTO typeDTO = typeService.updateById(id, type);
        return ResponseEntity.ok(typeDTO);
    }

}
