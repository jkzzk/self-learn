package com.jkzzk.annotation;

import java.lang.annotation.*;

@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
//@Documented
//@Inherited
public @interface MyAnnotation {

    int age();

}
