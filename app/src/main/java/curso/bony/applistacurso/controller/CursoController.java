package curso.bony.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import curso.bony.applistacurso.model.Curso;

public class CursoController {

    private List listCurso;

    public List getListaDECurso(){
        listCurso= new ArrayList<Curso>();
        listCurso.add(new Curso("Java"));
        listCurso.add(new Curso("PHP"));
        listCurso.add(new Curso("Python"));
        listCurso.add(new Curso("C"));
        listCurso.add(new Curso("C#"));
        listCurso.add(new Curso("Ada"));

        return listCurso;
    }
}