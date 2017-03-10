package cnj;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
public class ServiceInstanceBinding {

	@Id
	private String id;

	private String serviceInstanceId;
	private String syslogDrainUrl;
	private String appGuid;

	private Map<String, Object> credentials = new HashMap<>();

	public ServiceInstanceBinding(
			String id,
			String serviceInstanceId,
			Map<String, Object> credentials,
			String syslogDrainUrl,
			String appGuid) {
		this.id = id;
		this.serviceInstanceId = serviceInstanceId;
		this.syslogDrainUrl = syslogDrainUrl;
		this.appGuid = appGuid;
		this.contributeCredentials(credentials);
	}

	private void contributeCredentials(Map<String, Object> credentials) {
		if (credentials == null || credentials.isEmpty()) {
			this.credentials.clear();
		} else {
			this.credentials = credentials;
		}
	}

	public void setCredentials(Map<String, Object> credentials) {
		this.contributeCredentials(credentials);
	}
}