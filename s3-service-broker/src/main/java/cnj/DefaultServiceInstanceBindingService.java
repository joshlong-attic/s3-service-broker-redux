package cnj;

import org.springframework.cloud.servicebroker.exception.ServiceInstanceBindingDoesNotExistException;
import org.springframework.cloud.servicebroker.exception.ServiceInstanceBindingExistsException;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceAppBindingResponse;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class DefaultServiceInstanceBindingService
		implements ServiceInstanceBindingService {

	private final ServiceInstanceBindingRepository bindingRepository;

	public DefaultServiceInstanceBindingService(ServiceInstanceBindingRepository repository) {
		this.bindingRepository = repository;
	}

	@Override
	public CreateServiceInstanceBindingResponse createServiceInstanceBinding(
			CreateServiceInstanceBindingRequest request) {

		String bindingId = request.getBindingId();
		String serviceInstanceId = request.getServiceInstanceId();

		ServiceInstanceBinding binding = bindingRepository.findOne(bindingId);
		if (binding != null) {
			throw new ServiceInstanceBindingExistsException(serviceInstanceId, bindingId);
		}

		String uri =
				this.createCredentialedConnection(serviceInstanceId, bindingId, UUID.randomUUID().toString());

		binding = new ServiceInstanceBinding(bindingId,
				serviceInstanceId, uri , null, request.getBoundAppGuid());
		bindingRepository.save(binding);

		return new CreateServiceInstanceAppBindingResponse().withCredentials(Collections.singletonMap("uri", uri));
	}


	@Override
	public void deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest request) {
		String bindingId = request.getBindingId();
		ServiceInstanceBinding binding = getServiceInstanceBinding(bindingId);

		if (binding == null) {
			throw new ServiceInstanceBindingDoesNotExistException(bindingId);
		}

		deleteCredentialedConnection(binding.getServiceInstanceId(), bindingId);

		// todo mongo.deleteUser(binding.getServiceInstanceId(), bindingId);
		bindingRepository.delete(bindingId);
	}

	private ServiceInstanceBinding getServiceInstanceBinding(String id) {
		return bindingRepository.findOne(id);
	}

	// TODO: return a valid URI
	private String createCredentialedConnection(String database, String username, String password) {
		return null;
	}

	// TODO: return a valid URI
	private void deleteCredentialedConnection(String serviceInstanceId, String bindingId) {

	}

}


