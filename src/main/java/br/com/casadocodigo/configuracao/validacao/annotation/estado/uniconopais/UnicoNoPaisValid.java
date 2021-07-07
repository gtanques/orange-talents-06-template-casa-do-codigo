package br.com.casadocodigo.configuracao.validacao.annotation.estado.uniconopais;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {UnicoNoPaisValidator.class})
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface UnicoNoPaisValid {

    String message() default "Já existe um estado com esse nome no país";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
