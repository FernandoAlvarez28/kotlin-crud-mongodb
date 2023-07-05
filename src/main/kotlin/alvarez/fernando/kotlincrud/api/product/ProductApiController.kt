package alvarez.fernando.kotlincrud.api.product

import alvarez.fernando.kotlincrud.domain.product.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductApiController(val productService: ProductService) {

    @GetMapping("/api/v1/products")
    fun listProducts(): ResponseEntity<List<ProductApiOutput>> {
        val products = this.productService.findAll()
        return if (products.isNotEmpty()) ResponseEntity.ok(ProductApiOutput.from(products)) else ResponseEntity(HttpStatus.NO_CONTENT)
    }

}