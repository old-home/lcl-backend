package com.graywings.lcl.migration

import org.flywaydb.core.Flyway
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.slf4j.LoggerFactory

@SpringBootApplication(scanBasePackages = ["com.graywings.lcl"])
@EntityScan("com.graywings.lcl.domain")
@EnableJpaRepositories("com.graywings.lcl.domain")
@Profile("migration")
class MigrationRunner {
    private val logger = LoggerFactory.getLogger(MigrationRunner::class.java)

    @Bean
    fun run(flyway: Flyway): CommandLineRunner {
        return CommandLineRunner {
            logger.info("Starting database migration...")

            try {
                flyway.migrate()
                logger.info("Migration completed successfully!")

                // Print migration info
                val migrationInfo = flyway.info()
                val appliedMigrations = migrationInfo.applied()

                logger.info("Applied migrations:")
                appliedMigrations.forEach { migration ->
                    logger.info("  - ${migration.version}: ${migration.description} (${migration.type})")
                }

                val pendingMigrations = migrationInfo.pending()
                if (pendingMigrations.isNotEmpty()) {
                    logger.warn("There are still pending migrations:")
                    pendingMigrations.forEach { migration ->
                        logger.warn("  - ${migration.version}: ${migration.description} (${migration.type})")
                    }
                } else {
                    logger.info("No pending migrations. Database is up to date.")
                }
            } catch (e: Exception) {
                logger.error("Migration failed: ${e.message}", e)
                throw e
            }
        }
    }
}

fun main(args: Array<String>) {
    val app = SpringApplication(MigrationRunner::class.java)
    app.setAdditionalProfiles("migration")
    app.run(*args)
}
