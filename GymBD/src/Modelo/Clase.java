/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author estudiante
 */
public class Clase {
    
    private Integer codigo;
    private String clase;        
    private String horario;
    private Integer cod_Instructor;

    public Clase() {
    }

    public Clase(Integer codigo, String clase, String horario, Integer cod_Instructor) {
        this.codigo = codigo;
        this.clase = clase;
        this.horario = horario;
        this.cod_Instructor = cod_Instructor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getCod_Instructor() {
        return cod_Instructor;
    }

    public void setCod_Instructor(Integer cod_Instructor) {
        this.cod_Instructor = cod_Instructor;
    }
    
    
}
