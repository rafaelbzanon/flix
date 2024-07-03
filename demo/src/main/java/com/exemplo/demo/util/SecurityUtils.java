package com.exemplo.demo.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {

    public static String getLoggedInUserEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        } else {
            return principal.toString();
        }
    }
}
