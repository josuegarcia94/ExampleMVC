/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.EstudianteDAO;
import java.util.*;
//import datos.dao.Grupo;
//import datos.dao.Estudiante;

/**
 *
 * @author nacho
 */
public class Grupo {

    private LinkedList<Estudiante> estudiantes;
    private String archivo;

    public Grupo(String grupo) {
        archivo = grupo;
        estudiantes = new LinkedList<>();
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String grupo) {
        archivo = grupo;
    }
    
    public void addEstudiante(Estudiante al) {
        if(!estudiantes.contains((al))) {
            estudiantes.add(al);
        }
    }
    
    public void removeEstudiante(Estudiante al) {
        if(estudiantes.contains(al)) {
            estudiantes.remove(al);
        }
    }
    
    public void guardarGrupo() {
        EstudianteDAO daoa = new EstudianteDAO(archivo + ".odb");
        Iterator<Estudiante> itera = estudiantes.iterator();
        while(itera.hasNext()) {
            Estudiante e = itera.next();
            daoa.create(e);
            
        }
    }
}
