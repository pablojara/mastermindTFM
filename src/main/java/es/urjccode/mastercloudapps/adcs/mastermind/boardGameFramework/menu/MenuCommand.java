package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.menu;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MenuCommand {
    public Class<?> value();
}
