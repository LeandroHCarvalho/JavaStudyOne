/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakila.service;

import br.com.treinarinformatica.sakila.dao.FilmDAO;
import br.com.treinarinformatica.sakila.exceptions.ServiceException;
import br.com.treinarinformatica.sakila.model.Film;
import java.util.List;

/**
 *
 * @author Treinar
 */
public class FilmService {

    private FilmDAO filmDAO;

    public FilmService() {
        filmDAO = new FilmDAO();
    }

    public List<Film> listAll() throws ServiceException {
        try {
            return filmDAO.listAll();
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }

    }
}
