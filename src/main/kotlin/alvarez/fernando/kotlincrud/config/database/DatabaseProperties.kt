package alvarez.fernando.kotlincrud.config.database

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class DatabaseProperties(
    @Value("\${app.database.host}") val host: String,
    @Value("\${app.database.port}") val port: Int,
    @Value("\${app.database.url}") val url: String,
    @Value("\${app.database.name}") val name: String,
    @Value("\${app.database.username}") val username: String,
    @Value("\${app.database.password}") val password: String,
    @Value("\${app.database.userLocation}") val userLocation: String,
)