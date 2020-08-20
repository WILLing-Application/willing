package dev.willingapp.willing.services;

import dev.willingapp.willing.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) { this.usersLoader = usersLoader; }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(12); }
    // Default salt is 10, changed to 12

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader) // How to find users by their username
                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/profile") // user's home page, it can be any URL (temporary, will change to view when built?
                .permitAll() // Anyone can go to the login page
                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // append a query string value
                /* Pages that can be viewed without having to log in */
                .and()
                .authorizeRequests()
                .antMatchers("/") // anyone can see these pages
                .permitAll()
                /* Pages that require authentication */
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/view", // only authenticated users can view albums/items index page
                        "/create", // only authenticated users can create albums/items
                        "/albums/{id}", // only authenticated users can view albums
                        "/albums/edit", // only authenticated users can edit albums
                        "/albums/delete",      // only authenticated users can delete albums
                        "/items/{id}", // only authenticated users can view items
                        "/items/edit", // only authenticated users can edit items
                        "/items/delete", // only authenticated users can delete items
                        "/profile", // only authenticated users can view the user profile page
                        "/profile/edit", // only authenticated users can edit the user profile page
                        "/profile/delete" // only authenticated users can delete the user account
                )
                .authenticated()
        ;
    }
}
