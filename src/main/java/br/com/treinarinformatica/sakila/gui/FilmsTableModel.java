/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinarinformatica.sakila.gui;

import br.com.treinarinformatica.sakila.model.Film;
import br.com.treinarinformatica.sakila.service.FilmService;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Treinar
 */
public class FilmsTableModel extends AbstractTableModel {
    
    private List<Film> filmsList;
    
    public FilmsTableModel(List<Film> filmsList) {
        this.filmsList = filmsList;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "ID";
            case 1: return "Title";
            case 2: return "Release Year";
            case 3: return "Description";
            default: return null;
        }
    }
    
    
    

    @Override
    public int getRowCount() {
       return getFilmsList().size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex) {
           case 0: return getFilmsList().get(rowIndex).getId();
           case 1: return getFilmsList().get(rowIndex).getTitle();
           case 2: return getFilmsList().get(rowIndex).getReleaseYear();
           case 3: return getFilmsList().get(rowIndex).getDescription();
           default: return null;
       }
    }

    /**
     * @return the filmsList
     */
    public List<Film> getFilmsList() {
        return filmsList;
    }

   
    
}
