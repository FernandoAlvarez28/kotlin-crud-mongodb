package alvarez.fernando.kotlincrud.domain.product

import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.repository.query.Param
import reactor.core.publisher.Flux
import java.util.*

interface ProductRepository: ReactiveMongoRepository<Product, UUID> {

    @Query(value = "{ id: {\$in: :#{#ids}}, availableQuantity: {\$gt: 0} }")
    fun findAllAvailableById(@Param("ids") ids: Iterable<UUID>): Flux<Product>

}