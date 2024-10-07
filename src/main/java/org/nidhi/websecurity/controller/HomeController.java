package org.nidhi.websecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request) {

        return "Welcome to Home Page: " + request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request) {

        // You will get something like this
        /*
                "parameterName": "_csrf",
                "token": "zDLOwaMq07bX_9Oxs7LlqReHQgwrpTsnUvUyVduOkb8kw0rr-QH_opMZ6oL6nuqEhJ_RyC-ybzQZwQ0Ka5RWN-i4p4kc8H6J",
                "headerName": "X-CSRF-TOKEN"
        */
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }
}
