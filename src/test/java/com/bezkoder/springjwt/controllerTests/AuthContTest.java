package com.bezkoder.springjwt.controllerTests;

import com.bezkoder.springjwt.SpringBootSecurityJwtApplication;
import com.bezkoder.springjwt.controllers.ItemController;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
//@SpringBootTest
@WebMvcTest(ItemController.class)
@ContextConfiguration(classes= SpringBootSecurityJwtApplication.class)
public class AuthContTest {

}
