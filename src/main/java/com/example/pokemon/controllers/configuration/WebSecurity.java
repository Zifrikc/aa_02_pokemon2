package com.example.pokemon.controllers.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/css/**", "/imagenes/**", "/js/**", "/", "/principal", "/home", "/inicio", "/logeo", "/login","/rest/**")
                .permitAll()

                .antMatchers("/grass/tolistGrass").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
                .antMatchers("/grass/nuevo").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/grass/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
                .antMatchers("/grass/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/grass/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")

                .antMatchers("/fire/tolistFire").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
                .antMatchers("/fire/nuevo").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/fire/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
                .antMatchers("/fire/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/fire/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")

                .antMatchers("/water/tolistWater").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
                .antMatchers("/water/nuevo").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/water/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
                .antMatchers("/water/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/water/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")

                .antMatchers("/electric/tolistElectric").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
                .antMatchers("/electric/nuevo").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/electric/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
                .antMatchers("/electric/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/electric/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")

                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
                .and().logout()
                .permitAll();

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
                .withUser("juan").password(encoder.encode("juan")).roles("ADMIN").and()
                .withUser("ashley").password(encoder.encode("ashley")).roles("LECTOR", "EDITOR", "CREADOR").and()
                .withUser("dennis").password(encoder.encode("dennis")).roles("LECTOR", "CREADOR", "DEPURADOR").and()
                .withUser("degian").password(encoder.encode("degian")).roles("LECTOR","EDITOR").and()
                .withUser("zifrick").password(encoder.encode("zifrick")).roles("LECTOR", "EDITOR").and();

    }
}
