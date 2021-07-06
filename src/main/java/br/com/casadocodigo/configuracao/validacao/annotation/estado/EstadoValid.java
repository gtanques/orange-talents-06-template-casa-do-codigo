package br.com.casadocodigo.configuracao.validacao.annotation.estado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Constraint(validatedBy = {EstadoValidator.class})
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface EstadoValid {
    String message() default "Já existe um estado com esse nome no país";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> classe();

    String campo();

    Class<?> relacionamento();

    String relacionamentoNome();

    String relacionamentoCampo();
}
