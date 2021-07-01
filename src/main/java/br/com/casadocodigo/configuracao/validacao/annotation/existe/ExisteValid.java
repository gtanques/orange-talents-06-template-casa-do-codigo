package br.com.casadocodigo.configuracao.validacao.annotation.existe;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ExisteValidator.class)
public @interface ExisteValid {

    String message() default "Não encontrado(a).";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";

    String atributo();

    Class<?> classe();

}


