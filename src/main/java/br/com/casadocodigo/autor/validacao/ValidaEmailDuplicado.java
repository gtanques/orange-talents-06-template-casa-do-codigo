package br.com.casadocodigo.autor.validacao;

import br.com.casadocodigo.autor.Autor;
import br.com.casadocodigo.autor.dto.AutorForm;
import br.com.casadocodigo.autor.repository.AutorRepository;
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
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Autor> autorExiste = repository.findByEmail(s);
        if (autorExiste.isPresent()){
            return false;
        }
        return true;
    }
}
