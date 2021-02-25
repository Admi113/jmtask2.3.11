package web.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.models.Role;
import web.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

       for(GrantedAuthority authority:authentication.getAuthorities()){
           if(authority.getAuthority().equals("ROLE_ADMIN")){
               httpServletResponse.sendRedirect("/admin");
               return;
           }
       }

        for(GrantedAuthority authority:authentication.getAuthorities()){
            if(authority.getAuthority().equals("ROLE_USER")){
                httpServletResponse.sendRedirect("/users");
                return;
            }
        }

    }
}