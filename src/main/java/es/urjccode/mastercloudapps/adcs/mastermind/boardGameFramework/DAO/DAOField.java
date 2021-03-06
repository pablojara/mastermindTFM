package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.DAO;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DAOField {
    public String value() default "";
}
