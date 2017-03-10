package cnj;

import org.springframework.cloud.servicebroker.model.Catalog;
import org.springframework.cloud.servicebroker.model.Plan;
import org.springframework.cloud.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;


@Configuration
class CatalogConfiguration {

	@Bean
	public Catalog catalog() {
		return new Catalog(Collections.singletonList(
				new ServiceDefinition(
						"s3-service-broker",
						"s3",
						"A simple AWS S3 service broker implementation",
						true,
						false,
						Collections.singletonList(
								new Plan("ac8fdb55-3223-41e9-a5f5-eca6f8fd40c0",
										"s3-basic",
										"Amazon S3 bucket with unlimited storage",
										getPlanMetadata())),
						Arrays.asList("s3", "storage", "cache", "AWS"),
						getServiceDefinitionMetadata(),
						null,
						null)));
	}

	private Map<String, Object> getServiceDefinitionMetadata() {
		Map<String, Object> sdMetadata = new HashMap<>();
		sdMetadata.put("displayName", "Amazon S3");
		sdMetadata.put("longDescription", "A backing service with unlimited Amazon S3 storage");
		sdMetadata.put("providerDisplayName", "Amazon S3");
		sdMetadata.put("documentationUrl", "http://aws.amazon.com/s3");
		sdMetadata.put("supportUrl", "http://aws.amazon.com/s3");
		return sdMetadata;
	}

	private Map<String, Object> getPlanMetadata() {
		Map<String, Object> planMetadata = new HashMap<>();
		planMetadata.put("costs", getCosts());
		planMetadata.put("bullets", getBullets());
		return planMetadata;
	}

	private Map<String, Object> getCosts() {
		return Collections.singletonMap("free", true);
	}

	private List<String> getBullets() {
		return Collections.singletonList("Amazon S3");
	}

}
