package br.com.casadocodigo.configuracao.validacao.annotation.estado.existenopais;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ExisteNoPaisValidator.class})
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface ExisteNoPaisValid {

    String message() default "O país possui estados.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
