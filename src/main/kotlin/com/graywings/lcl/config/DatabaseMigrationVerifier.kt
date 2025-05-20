package com.graywings.lcl.config

import org.flywaydb.core.Flyway
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.slf4j.LoggerFactory

@Configuration
class DatabaseMigrationVerifier {
    private val logger = LoggerFactory.getLogger(DatabaseMigrationVerifier::class.java)

    @Bean
    @Profile("!test")
    fun verifyMigration(flyway: Flyway): CommandLineRunner {
        return CommandLineRunner {
            logger.info("Verifying database migration...")
            val migrationInfo = flyway.info()
            val appliedMigrations = migrationInfo.applied()

            if (appliedMigrations.isEmpty()) {
                logger.warn("No migrations have been applied yet!")
            } else {
                logger.info("Applied migrations:")
                appliedMigrations.forEach { migration ->
                    logger.info("  - ${migration.version}: ${migration.description} (${migration.type})")
                }
            }

            val pendingMigrations = migrationInfo.pending()
            if (pendingMigrations.isNotEmpty()) {
                logger.warn("There are pending migrations:")
                pendingMigrations.forEach { migration ->
                    logger.warn("  - ${migration.version}: ${migration.description} (${migration.type})")
                }
            } else {
                logger.info("No pending migrations. Database is up to date.")
            }
        }
    }
}
