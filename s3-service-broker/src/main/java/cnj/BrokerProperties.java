package cnj;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "broker")
public class BrokerProperties {

	private String providerDisplayName;
	private String documentationUrl;
	private String supportUrl;
	private String displayName;
	private String longDescription;
	private String imageUrl;

	@NestedConfigurationProperty
	private BasicPlan basicPlan;

	@NestedConfigurationProperty
	private Definition definition;

	@Data
	public static class BasicPlan {
		private String id;
		private String name;
		private String description;
		private Boolean free;
	}

	@Data
	public static class Definition {
		private String id;
		private String name;
		private String description;
		private Boolean bindable;
	}
}
