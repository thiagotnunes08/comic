package br.com.orange.comics.compartilhado.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CampoUnicoValidator implements ConstraintValidator<CampoUnico, Object> {

    private String atributo;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(CampoUnico parametros) {
        atributo = parametros.fieldName();
        klass = parametros.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        var list = entityManager.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + atributo + "=?1")
                .setParameter(1, value).getResultList();

        return list.isEmpty();
    }
}
