package cz.cvut.sep.rychljir;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/customers").setViewName("customers");
        registry.addViewController("/requests").setViewName("requests");
        registry.addViewController("/new").setViewName("new");
        registry.addViewController("/edit").setViewName("edit");
    }

}
