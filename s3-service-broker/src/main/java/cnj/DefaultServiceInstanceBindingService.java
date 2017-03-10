package cnj;

import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;

// todo
@Service
public class DefaultServiceInstanceBindingService
		implements ServiceInstanceBindingService {

	private final ServiceInstanceBindingRepository repository;

	public DefaultServiceInstanceBindingService(ServiceInstanceBindingRepository repository) {
		this.repository = repository;
	}

	@Override
	public CreateServiceInstanceBindingResponse createServiceInstanceBinding(CreateServiceInstanceBindingRequest request) {
		return null;
	}

	@Override
	public void deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest request) {

	}
}
