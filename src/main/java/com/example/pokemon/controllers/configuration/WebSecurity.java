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
                .antMatchers("/waters/tolistAquatic").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
                .antMatchers("/waters/nuevo").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/waters/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
                .antMatchers("/waters/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/waters/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")

                .antMatchers("/fires/tolistFire").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
                .antMatchers("/fires/nuevo").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/fires/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
                .antMatchers("/fires/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/fires/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")

                .antMatchers("/electrics/tolistElectric").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
                .antMatchers("/electrics/nuevo").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/electrics/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
                .antMatchers("/electrics/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/electrics/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")

                .antMatchers("/grasses/tolistGrass").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
                .antMatchers("/grasses/nuevo").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/grasses/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
                .antMatchers("/grasses/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/grasses/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
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
                .withUser("ashley").password(encoder.encode("ashley")).roles("LECTOR").and()
                .withUser("dennis").password(encoder.encode("dennis")).roles("CREADOR", "LECTOR").and()
                .withUser("degian").password(encoder.encode("degian")).roles("LECTOR","DEPURADOR").and()
                .withUser("zifrick").password(encoder.encode("zifrick")).roles("EDITOR","LECTOR").and();

    }
}
