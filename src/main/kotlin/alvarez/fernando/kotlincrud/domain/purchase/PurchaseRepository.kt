package alvarez.fernando.kotlincrud.domain.purchase

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import java.util.*

interface PurchaseRepository : ReactiveMongoRepository<Purchase, UUID> {



}