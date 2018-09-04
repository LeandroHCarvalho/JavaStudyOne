/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakila.dao;

import br.com.treinarinformatica.sakila.db.SakilaConnection;
import br.com.treinarinformatica.sakila.exceptions.DAOException;
import br.com.treinarinformatica.sakila.model.Film;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Treinar
 */
public class FilmDAO {
    public List<Film> listAll() throws DAOException {
       List<Film> filmsList = new ArrayList<>();
       
       try {
           StringBuilder sb = new StringBuilder();
           sb.append("select film_id,title,description,release_year ");
           sb.append("from film");
           Statement stm = SakilaConnection.getConnection().createStatement();
           ResultSet rs = stm.executeQuery(sb.toString());
           while (rs.next()) {
               Film film = new Film();
               film.setId(rs.getInt("film_id"));
               film.setTitle(rs.getString("title"));
               film.setDescription(rs.getString("description"));
               film.setReleaseYear(rs.getInt("release_year"));
               filmsList.add(film);
           }
           
           return filmsList;
       } catch (Exception ex) {
           throw new DAOException(ex);
       }
    }
}
