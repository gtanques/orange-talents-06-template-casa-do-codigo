package br.com.casadocodigo.autores.validacao;

import br.com.casadocodigo.autores.Autor;
import br.com.casadocodigo.autores.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidaEmailDuplicado implements ConstraintValidator<EmailDuplicadoValid, String> {

    private String value;

    @Autowired
    AutorRepository repository;

    @Override
    public void initialize(EmailDuplicadoValid constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String request, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Autor> autorExiste = repository.findByEmail(request);
        if (autorExiste.isPresent()){
            return false;
        }
        return true;
    }
}
