package model;

import java.time.LocalDate;

/**
 * Classe "Ator" que representa os atores/atrizes do sistema SerMaisFlix.
 * 
 * @author Ludimila Araujo
 */
public class Ator extends Pessoa {

        //atributos da classe-filha "Ator:

        private double cache;

        //construtor (levando em consideração a Herança da classe-mãe "Pessoa")

        public Ator(String nome, LocalDate dataNascimento, String nacionalidade, double cache){
            super(nome, dataNascimento, nacionalidade);
            this.cache = cache;
        }

        // getters e setters:
        public double getCache(){
            return cache;
        }

        public void setCache(double cache){
            this.cache = cache;
        }
    }

