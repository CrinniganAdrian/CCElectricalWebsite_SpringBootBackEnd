package com.bezkoder.springjwt.controllerTests;

import com.bezkoder.springjwt.models.Service;
import com.bezkoder.springjwt.repository.ServiceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ServicesConTest {

    @Autowired
    ServiceRepository serviceRepository;


    @Test
    public void testCreateReadDelete() {
        Service service = new Service("TestService", "Rewire","www.rewire.com");

        Service serviceResult = serviceRepository.save(service);

        Iterable<Service> services = serviceRepository.findAll();
        Assertions.assertThat(services).last().hasFieldOrPropertyWithValue("name", "TestService");

        serviceRepository.delete(serviceResult);
        Assertions.assertThat(services).doesNotContain(service);
    }
}
