package com.golf.app.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.golf.app.dto.CourseDto;
import com.golf.app.service.CourseService;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.junit.jupiter.api.Test;
import org.springframework.validation.ObjectError;

class CourseControllerTest {

    private final CourseService courseService = mock(CourseService.class);
    private final Model model = mock(Model.class);
    private final CourseController courseController = new CourseController(courseService);

    @Test
    void testAddCourseWithErrors() {
        BindingResult bindingResult = mock(BindingResult.class);
        ObjectError error = new ObjectError("name", "Name should not be empty");
        when(bindingResult.hasErrors()).thenReturn(true);
        when(bindingResult.getAllErrors()).thenReturn(List.of(error));

        String result = courseController.addCourse(new CourseDto(), bindingResult, model);

        assertEquals("error/error-page", result);
        verify(courseService, never()).saveCourse(any());
        verify(model, times(1)).addAttribute("errors", bindingResult.getAllErrors());
    }
}