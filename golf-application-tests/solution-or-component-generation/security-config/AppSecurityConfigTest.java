package com.golf.app.security;

import com.golf.app.controller.AdminController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(AdminController.class)
@Import(AppSecurityConfig.class)
class AppSecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void testShouldReturn403ForAdminPageForNotAdminRoleUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
            .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithAnonymousUser
    public void testShouldReturn200ForLoginPageForAnonymousUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = "ADMIN")
    public void testShouldReturn200ForAdminPageForAdminRoleUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
