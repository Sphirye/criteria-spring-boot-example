package com.sphiryecode.criteria

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Repository

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(includeFilters = [ComponentScan.Filter(Repository::class)])

class CriteriaExampleApplication

fun main(args: Array<String>) {
	runApplication<CriteriaExampleApplication>(*args)
}
