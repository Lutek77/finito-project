package pl.coderslab.collapp.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import net.bytebuddy.build.Plugin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

// testy napisz


    // documentation
    @Operation(summary = "Find product with balance",
            description = "Returns a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = ProductDTO[].class))),
            @ApiResponse(responseCode = "404", description = "Products cannot be found")
    })
    @GetMapping("/single/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        ProductDTO productDTO = productService.getById(id);
        return productDTO != null
                ? ResponseEntity.ok(productDTO)
                : ResponseEntity.notFound().build();
    }


    // Test
    @Operation(summary = "Find product with last balance")
    @GetMapping("/single/last/bal/{id}")
    public ResponseEntity<ProductDTO> getProductWithLastBal(@PathVariable Long id) {
        ProductDTO productDTO = productService.getByIdWithLastBalance(id);
        return productDTO != null
                ? ResponseEntity.ok(productDTO)
                : ResponseEntity.notFound().build();
    }


}
