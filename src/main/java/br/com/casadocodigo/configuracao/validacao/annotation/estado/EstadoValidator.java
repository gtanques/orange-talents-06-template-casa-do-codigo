package br.com.casadocodigo.configuracao.validacao.annotation.estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstadoValidator implements ConstraintValidator<EstadoValid, EstadoRelacionamento> {

    @PersistenceContext
    private final EntityManager entityManager;

    public EstadoValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(EstadoValid valid) {
    }

    @Override
    public boolean isValid(EstadoRelacionamento r, ConstraintValidatorContext constraintValidatorContext) {

        Query query = entityManager.createQuery("SELECT 1 FROM Estado e WHERE e.nome =:nome AND e.pais.id=:id");

        query.setParameter("nome", r.getCampo());
        query.setParameter("id", r.getRelacionamento());

        List<?> resultList = query.getResultList();

        return resultList.isEmpty();
    }

}
