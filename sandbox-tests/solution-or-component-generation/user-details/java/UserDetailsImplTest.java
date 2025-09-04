package com.epam.aicode;

import com.epam.aicode.entity.EUserRole;
import com.epam.aicode.entity.User;
import com.epam.aicode.entity.UserRole;
import com.epam.aicode.entity.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserDetailsImpl Test Suite")
class UserDetailsImplTest {

    private User baseUser;

    @BeforeEach
    void setUp() {
        baseUser = new User();
        baseUser.setId(1L);
        baseUser.setUsername("testUser");
        baseUser.setPassword("testPassword");
        baseUser.setStatus(UserStatus.ACTIVE);
        baseUser.setRoles(new HashSet<>());
    }

    private User createUserWithRole(EUserRole role) {
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.builder().title(role).build());
        baseUser.setRoles(roles);
        return baseUser;
    }

    @Nested
    @DisplayName("UserDetails Building Tests")
    class UserDetailsBuildingTests {

        @Test
        @DisplayName("Should correctly build UserDetails with all properties")
        void shouldBuildUserDetailsWithAllProperties() {
            User user = createUserWithRole(EUserRole.ROLE_CLIENT);

            UserDetailsImpl userDetails = UserDetailsImpl.build(user);

            assertEquals(1L, userDetails.getId());
            assertEquals("testUser", userDetails.getUsername());
            assertEquals("testPassword", userDetails.getPassword());
            assertEquals(UserStatus.ACTIVE, userDetails.getStatus());

            assertFalse(userDetails.getAuthorities().isEmpty());
            assertTrue(userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(auth -> auth.equals("ROLE_CLIENT")));
        }

        @Test
        @DisplayName("Should handle multiple user roles")
        void shouldHandleMultipleUserRoles() {
            Set<UserRole> roles = new HashSet<>();
            roles.add(UserRole.builder().title(EUserRole.ROLE_CLIENT).build());
            roles.add(UserRole.builder().title(EUserRole.ROLE_ADMIN).build());
            baseUser.setRoles(roles);

            UserDetailsImpl userDetails = UserDetailsImpl.build(baseUser);

            assertEquals(2, userDetails.getAuthorities().size());
            assertTrue(userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .allMatch(auth -> auth.equals("ROLE_CLIENT") || auth.equals("ROLE_ADMIN")));
        }
    }

    @Nested
    @DisplayName("Account Status Tests")
    class AccountStatusTests {

        @Test
        @DisplayName("Active user should have all privileges enabled")
        void activeUserShouldHaveAllPrivilegesEnabled() {
            baseUser.setStatus(UserStatus.ACTIVE);

            UserDetailsImpl userDetails = UserDetailsImpl.build(baseUser);

            assertTrue(userDetails.isEnabled());
            assertTrue(userDetails.isAccountNonLocked());
            assertTrue(userDetails.isAccountNonExpired());
            assertTrue(userDetails.isCredentialsNonExpired());
        }

        @Test
        @DisplayName("Banned user should have restricted privileges")
        void bannedUserShouldHaveRestrictedPrivileges() {
            baseUser.setStatus(UserStatus.BANNED);

            UserDetailsImpl userDetails = UserDetailsImpl.build(baseUser);

            assertFalse(userDetails.isEnabled());
            assertFalse(userDetails.isAccountNonLocked());
            assertTrue(userDetails.isAccountNonExpired());
            assertTrue(userDetails.isCredentialsNonExpired());
        }

        @Test
        @DisplayName("Deleted user should be disabled but not locked")
        void deletedUserShouldBeDisabledButNotLocked() {
            baseUser.setStatus(UserStatus.DELETED);

            UserDetailsImpl userDetails = UserDetailsImpl.build(baseUser);

            assertFalse(userDetails.isEnabled());
            assertTrue(userDetails.isAccountNonLocked());
            assertTrue(userDetails.isAccountNonExpired());
            assertTrue(userDetails.isCredentialsNonExpired());
        }
    }

    @Nested
    @DisplayName("Equality Tests")
    class EqualityTests {

        @Test
        @DisplayName("Users with same ID should be equal regardless of other properties")
        void userWithSameIdShouldBeEqual() {
            User user1 = new User();
            user1.setId(1L);
            user1.setUsername("user1");
            user1.setStatus(UserStatus.ACTIVE);
            user1.setRoles(new HashSet<>());

            User user2 = new User();
            user2.setId(1L);
            user2.setUsername("differentUser");
            user2.setStatus(UserStatus.BANNED);
            user2.setRoles(new HashSet<>());

            UserDetailsImpl userDetails1 = UserDetailsImpl.build(user1);
            UserDetailsImpl userDetails2 = UserDetailsImpl.build(user2);

            assertEquals(userDetails1, userDetails2);
            assertNotEquals(null, userDetails1);
            assertNotEquals(new Object(), userDetails1);
        }

        @Test
        @DisplayName("Users with different IDs should not be equal")
        void usersWithDifferentIdsShouldNotBeEqual() {
            User user1 = new User();
            user1.setId(1L);
            user1.setRoles(new HashSet<>());

            User user2 = new User();
            user2.setId(2L);
            user2.setRoles(new HashSet<>());

            UserDetailsImpl userDetails1 = UserDetailsImpl.build(user1);
            UserDetailsImpl userDetails2 = UserDetailsImpl.build(user2);

            assertNotEquals(userDetails1, userDetails2);
        }
    }
}
