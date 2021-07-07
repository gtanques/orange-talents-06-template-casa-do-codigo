package br.com.casadocodigo.configuracao.validacao.annotation.estado.existenopais;

import br.com.casadocodigo.configuracao.validacao.annotation.estado.RelacionamentoGenerico;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExisteNoPaisValidator implements ConstraintValidator<ExisteNoPaisValid, RelacionamentoGenerico<Long, Long>> {

    @PersistenceContext
    private final EntityManager entityManager;

    public ExisteNoPaisValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(ExisteNoPaisValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RelacionamentoGenerico generico, ConstraintValidatorContext constraintValidatorContext) {

        if (generico.getCampo() != null) {
            return true;
        }

        Query query = entityManager.createQuery("SELECT 1 FROM Estado e WHERE e.pais.id=:id");
        query.setParameter("id", generico.getRelacionamento());

        List<?> resultList = query.getResultList();

        return resultList.isEmpty();

    }

}
