package com.products.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    private final JdbcTemplate jdbc;
    HelloController(JdbcTemplate jdbc) { this.jdbc = jdbc; }
    // @RequestMapping("/Products")
    // public String hello() {
    //     return "hello productsss";
    // }
    // @RequestMapping("/")
    // public String main() {
    //     return "hello productttttttttttssssssssssssssssss";
    // }
    // @GetMapping("/api/db-ping")
    // public String ping() {
    //     Integer one = jdbc.queryForObject("SELECT 1", Integer.class);
    //     return "Db Ok: " + one;
    // }
    
}
