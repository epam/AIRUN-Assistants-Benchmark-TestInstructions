package com.golf.app.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.golf.app.exception.CourseNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

class ExceptionHandlerControllerTest {

    private static final String COURSE_NOT_FOUND_ERROR_MESSAGE = "Course not found";

    private ExceptionHandlerController exceptionHandlerController = new ExceptionHandlerController();

    @Test
    void testHandleCourseNotFoundException() {
        CourseNotFoundException testException = new CourseNotFoundException(COURSE_NOT_FOUND_ERROR_MESSAGE);

        ModelAndView modelAndView = exceptionHandlerController.handleCourseNotFoundException(testException);

        assertNotNull(modelAndView);
        assertEquals("error/error-page", modelAndView.getViewName());
        assertEquals(COURSE_NOT_FOUND_ERROR_MESSAGE, modelAndView.getModel().get("errorMessage"));
    }
}
