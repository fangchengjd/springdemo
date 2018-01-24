package fangcheng.springframework.lab.springboot.custom.annotation.annotation;



import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(PropertyBeanRegistrar.class)
public @interface PropertyBean {

    String name () default "";

    String location () default "";

}
