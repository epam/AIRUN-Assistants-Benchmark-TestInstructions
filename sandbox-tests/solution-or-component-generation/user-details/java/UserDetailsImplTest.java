package com.epam.aicode;

import com.epam.aicode.entity.EUserRole;
import com.epam.aicode.entity.User;
import com.epam.aicode.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

import static com.epam.aicode.entity.UserStatus.ACTIVE;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

public class UserDetailsImplTest {

    public void setUserForContext() {
        User user = new User();
        user.setUsername("TestUser");
        user.setStatus(ACTIVE);
        user.setRoles(Set.of(
                UserRole.builder().title(EUserRole.ROLE_ADMIN).build(),
                UserRole.builder().title(EUserRole.ROLE_MODERATOR).build(),
                UserRole.builder().title(EUserRole.ROLE_CLIENT).build()
        ));
        UserDetails userDetails = new UserDetailsImpl(user);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        getContext().setAuthentication(authentication);
    }

    @Test
    public void testGetAuthorities() {
        setUserForContext();
        assert getContext().getAuthentication().getAuthorities().size() == 3;
    }

    @Test void checkTypeOfAuthorities() {
        setUserForContext();
        assert getContext().getAuthentication().getAuthorities().stream().findFirst().get().getClass().equals(SimpleGrantedAuthority.class);
    }

    @Test void checkRoles() {
        setUserForContext();
        assert getContext().getAuthentication().getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        assert getContext().getAuthentication().getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_MODERATOR"));
        assert getContext().getAuthentication().getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_CLIENT"));
    }

    @Test void checkStatus() {
        setUserForContext();
        assert getContext().getAuthentication().isAuthenticated();
    }
}
