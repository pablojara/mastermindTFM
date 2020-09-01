package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ControllerImplementation {
    public StateValue value() default StateValue.INITIAL;
}
