package com.golf.app.controller;

import com.golf.app.model.User;
import com.golf.app.service.UserService;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.web.bind.annotation.PostMapping;
import static org.mockito.Mockito.verify;

class UserControllerTest {

    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        String result = userController.registerUser(user);

        assertEquals("redirect:/login", result);
        verify(userService, Mockito.times(1)).registerUser(user);
    }

    @Test
    public void testRegisterUserModelAttributeAnnotation() throws NoSuchMethodException {
        Method registerUserMethod = UserController.class.getMethod("registerUser", User.class);
        Parameter[] parameters = registerUserMethod.getParameters();
        ModelAttribute modelAttributeAnnotation = parameters[0].getAnnotation(ModelAttribute.class);
        PostMapping postMappingAnnotation = registerUserMethod.getAnnotation(PostMapping.class);

       assertTrue(modelAttributeAnnotation != null ||
           (postMappingAnnotation != null && postMappingAnnotation.consumes().length > 0 &&
                postMappingAnnotation.consumes()[0].equals(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
       );
    }
}

