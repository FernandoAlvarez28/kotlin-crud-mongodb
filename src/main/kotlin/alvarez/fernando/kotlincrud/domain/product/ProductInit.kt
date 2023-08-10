package alvarez.fernando.kotlincrud.domain.product

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.BeanInstantiationException
import org.springframework.stereotype.Component
import java.io.InputStream
import java.math.BigDecimal
import java.util.*
import java.util.logging.Logger

@Component
class ProductInit(
    private val logger: Logger = Logger.getLogger(ProductInit::class.qualifiedName),
    private val initialProductsJson: String = "db/migration/defaultProducts.json",
    private val productRepository: ProductRepository,
    private val jsonObjectMapper: ObjectMapper,
) {

    init {
        if (this.productRepository.count().block()?.toInt() == 0) {
            this.logger.info("Initializing Products")
            val classLoader = javaClass.classLoader
            val jsonInputStream: InputStream = classLoader.getResourceAsStream(this.initialProductsJson)
                ?: throw BeanInstantiationException(javaClass, "File \"$initialProductsJson\" not found")

            val products: MutableList<Product>
            try {
                val parsedJson: List<Map<String, Any>> = this.jsonObjectMapper.readValue(jsonInputStream, ListedMapTypeReference())

                products = ArrayList(parsedJson.size)
                for (map in parsedJson) {
                    products.add(
                        Product(
                            id = UUID.randomUUID(),
                            name = map["name"] as String,
                            unitPrice = BigDecimal.valueOf(map["unitPrice"] as Double),
                            availableQuantity = map["availableQuantity"] as Int
                        )
                    )
                }
            } catch (e: Exception) {
                throw BeanInstantiationException(javaClass, "Error initializing Products", e)
            }

            this.productRepository.saveAll(products).subscribe()
            this.logger.info("Finished initializing Products")
        } else {
            this.logger.info("There are Products in the database; no need to initialize them")
        }
    }

}

private class ListedMapTypeReference : TypeReference<List<Map<String, Any>>>()
