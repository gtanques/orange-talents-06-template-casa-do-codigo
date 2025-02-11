package br.com.casadocodigo.configuracao.validacao.annotation.existe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExisteValidator implements ConstraintValidator<ExisteValid, Object> {

    private String atributo;
    private Class<?> classe;

    @PersistenceContext
    private final EntityManager entityManager;

    public ExisteValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(ExisteValid existeValid) {
        atributo = existeValid.atributo();
        classe = existeValid.classe();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {

        if(obj == null){
            return true;
        }

        Query query = entityManager.createQuery("select 1 from " + classe.getName() + " where " + atributo + "=:value");
        query.setParameter("value", obj);
        List<?> list = query.getResultList();

        return !list.isEmpty();
    }

}
