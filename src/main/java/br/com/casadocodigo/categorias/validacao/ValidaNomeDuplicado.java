package br.com.casadocodigo.categorias.validacao;

import br.com.casadocodigo.categorias.Categoria;
import br.com.casadocodigo.categorias.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidaNomeDuplicado implements ConstraintValidator<NomeDuplicadoValid, String> {

    private String value;

    @Autowired
    CategoriaRepository repository;

    @Override
    public void initialize(NomeDuplicadoValid constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String request, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Categoria> categoriaExiste = repository.findByNome(request);
        if (categoriaExiste.isPresent()){
            return false;
        }
        return true;
    }
}
