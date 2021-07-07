package br.com.casadocodigo.configuracao.validacao.annotation.estado.uniconopais;

import br.com.casadocodigo.configuracao.validacao.annotation.estado.RelacionamentoGenerico;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UnicoNoPaisValidator implements ConstraintValidator<UnicoNoPaisValid, RelacionamentoGenerico> {

    @PersistenceContext
    private final EntityManager entityManager;

    public UnicoNoPaisValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(UnicoNoPaisValid valid) {
    }

    @Override
    public boolean isValid(RelacionamentoGenerico r, ConstraintValidatorContext constraintValidatorContext) {

        Query query = entityManager.createQuery("SELECT 1 FROM Estado e WHERE e.nome =:nome AND e.pais.id=:id");

        query.setParameter("nome", r.getCampo());
        query.setParameter("id", r.getRelacionamento());

        List<?> resultList = query.getResultList();

        return resultList.isEmpty();
    }

}
