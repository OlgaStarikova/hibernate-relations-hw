package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.CountryDao;
import mate.academy.hibernate.relations.dao.impl.CountryDaoImpl;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.service.CountryService;
import mate.academy.hibernate.relations.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.NoSuchElementException;

public class CountryServiceImpl implements CountryService {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final CountryDao countryDao = new CountryDaoImpl(sessionFactory);

    @Override
    public Country add(Country country) {
        return countryDao.add(country);
    }

    @Override
    public Country get(Long id) {
        return countryDao.get(id).orElseThrow(
                () -> new NoSuchElementException("Unable get Country by id: " + id));
    }
}
