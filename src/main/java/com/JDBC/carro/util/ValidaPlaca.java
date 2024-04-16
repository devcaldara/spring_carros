package com.JDBC.carro.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ValidaPlaca {

    public static  Boolean setPlacaAntiga(String placa){
         String regex = "^[A-Z]{3}-\\d{4}$";
         // Compila a expressão regular em um padrão
         Pattern pattern = Pattern.compile(regex);
         // Cria um Matcher para fazer a correspondência da placa com o padrão
         Matcher matcher = pattern.matcher(placa);
         // Retorna true se a placa corresponder ao padrão, caso contrário, retorna false
         return matcher.matches();
    }

    public static Boolean setPlacaNova(String placa){
        // Expressão regular para validar a placa no novo modelo
        String regex = "^[A-Z]{3}\\d[A-Z]\\d{2}$";
        // Compila a expressão regular em um padrão
        Pattern pattern = Pattern.compile(regex);
        // Cria um Matcher para fazer a correspondência da placa com o padrão
        Matcher matcher = pattern.matcher(placa);
        // Retorna true se a placa corresponder ao padrão, caso contrário, retorna false
        return matcher.matches();
    }

    public static Boolean valida(String placa) {
        //colocar && para testar, não vai passar no teste, pois sempre vai ser um true e um falso
        return setPlacaAntiga(placa) || setPlacaNova(placa);
    }

}


// matches(): Verifica se toda a string de entrada corresponde ao padrão.
// find(): Procura pela próxima subsequência da string de entrada que corresponde ao padrão.
// group(): Retorna a subsequência correspondente encontrada pela última chamada a find().
// start() e end(): Retorna as posições de início e fim da subsequência correspondente encontrada pela última chamada a find().
