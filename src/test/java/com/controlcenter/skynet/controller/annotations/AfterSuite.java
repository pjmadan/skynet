package com.controlcenter.skynet.controller.annotations;
/**
 * Created by pmadan on 12/21/16.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by pmadan on 12/21/16.
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AfterSuite {

}
