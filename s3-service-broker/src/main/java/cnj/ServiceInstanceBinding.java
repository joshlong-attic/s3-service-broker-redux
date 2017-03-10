package cnj;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ServiceInstanceBinding {

	@Id
	private String id;

	private String serviceInstanceId;
	private String syslogDrainUrl;
	private String uri;
	private String appGuid;

	public String getUri() {
		return uri;
	}

	public ServiceInstanceBinding(String id,
	                              String serviceInstanceId,
	                              String uri,
	                              String syslogDrainUrl,
	                              String appGuid) {
		this.id = id;
		this.serviceInstanceId = serviceInstanceId;
		this.uri = uri;
		this.syslogDrainUrl = syslogDrainUrl;
		this.appGuid = appGuid;
	}

	public String getId() {
		return id;
	}

	public String getServiceInstanceId() {
		return serviceInstanceId;
	}

	public String getSyslogDrainUrl() {
		return syslogDrainUrl;
	}

	public String getAppGuid() {
		return appGuid;
	}

}