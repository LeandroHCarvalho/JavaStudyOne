/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakila.service;

import br.com.treinarinformatica.sakila.exceptions.ServiceException;
import br.com.treinarinformatica.sakila.model.Film;
import br.com.treinarinformatica.sakila.util.HibernateUtil;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class FilmService {

    public List<Film> listAll() throws ServiceException {
        try (Session session = HibernateUtil.sessionFactory.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Film> cr = cb.createQuery(Film.class);
            cr.select(cr.from(Film.class));
            Query<Film> query = session.createQuery(cr);

            return query.getResultList();
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }

    }

    public List<Film> listByReleaseYear(int releaseYear) throws ServiceException {
        try (Session session = HibernateUtil.sessionFactory.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Film> cr = cb.createQuery(Film.class);
            Root<Film> root = cr.from(Film.class);
            cr
                    .select(root)
                    .where(cb.equal(root.get("releaseYear"), releaseYear));

            Query<Film> query = session.createQuery(cr);

            return query.getResultList();
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }

    }

    public void save(Film film) throws ServiceException {
        try (Session session = HibernateUtil.sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(film);
            session.getTransaction().commit();
        } catch (Exception ex) {
            throw new ServiceException(ex);
        } 

    }

    public void update(Film film) throws ServiceException {
        try (Session session = HibernateUtil.sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(film);
            session.getTransaction().commit();
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    public void delete(int id) throws ServiceException {
        try (Session session = HibernateUtil.sessionFactory.openSession()) {
            session.beginTransaction();
            Film film = session.get(Film.class, id);
            session.remove(film);
            session.getTransaction().commit();
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }
}
