package ua.abdulaiev.hw21.annotation;

import ua.abdulaiev.hw21.objects.Operation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Multiplier {
    Operation value() default Operation.ADD;
}
