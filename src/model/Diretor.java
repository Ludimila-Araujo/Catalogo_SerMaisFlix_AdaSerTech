package model;

import java.time.LocalDate;

/**
 * Classe "Diretor" que representa os diretores/diretoras do sistema SerMaisFlix.
 * 
 * @author Ludimila Araujo
 */
public class Diretor extends Pessoa {

        //atributos da classe filha "Diretor":

        private String estilo;

        //construtor (considerando Herança da classe-mãe "Pessoa")

        public Diretor(String nome, LocalDate dataNascimento, String nacionalidade, String estilo){
            super(nome, dataNascimento, nacionalidade);
            this.estilo = estilo;
        }

        //getters e setters:

        public String getEstilo(){
            return estilo;
        }

        public void setEstilo(String estilo) {
            this.estilo = estilo;
        }

    }

