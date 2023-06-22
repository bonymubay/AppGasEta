package curso.bony.appgaseta.controller;

import java.util.ArrayList;
import java.util.List;

import curso.bony.appgaseta.model.Curso;

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

    public ArrayList<String> dadosParaSpinner(){
       ArrayList<String> dados=new ArrayList<>();

        for (int i = 0; i < getListaDECurso().size(); i++) {

            Curso objecto= (Curso) getListaDECurso().get(i);
           dados.add( objecto.getNomeDoCursoDesejado());

        }
        return dados;
    }
}
