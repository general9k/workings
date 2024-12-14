package ru.ksanxxx.abitur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Optional;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"ru.ksanxxx.abitur.repository"})
@EntityScan(basePackages = {"ru.ksanxxx.abitur.model"})
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
public class AbiturApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbiturApplication.class, args);
    }

    @Bean
    public DateTimeProvider auditingDateTimeProvider() {
        return () -> Optional.of(OffsetDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS));
    }
}
