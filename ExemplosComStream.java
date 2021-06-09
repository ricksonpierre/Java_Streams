package StreamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExemplosComStream {
    public static void main(String[] args) {
        //Criar a coleção de estudantes
        List<String> estudantes = new ArrayList<>();

        //Adicionar elementos à lista
        estudantes.add("Roberto");
        estudantes.add("Gabriela");
        estudantes.add("Marília");
        estudantes.add("Julianne");
        estudantes.add("Nayara");
        estudantes.add("Ronaldo");
        estudantes.add("Maurízio");

        //Retornar a contagem de elementos da stream
        System.out.println("Contagem: "+estudantes.stream().count());

        //Retornar o elemento com maior número de letras
        System.out.println("Nome com mais letras: "+estudantes.stream()
                .max(Comparator.comparingInt(String::length)));

        //Retornar o elemento com menor número de letras
        System.out.println("Nome com menos letras: "+estudantes.stream()
                .min(Comparator.comparingInt(String::length)));

        //Retorna os elementos que tem a çetra R no nome
        System.out.println("Contém a letra (b) no nome: "+estudantes.stream().filter((estudante) ->
                estudante.toLowerCase().contains("b")).collect(Collectors.toList()));

        //Retorna uma nova coleção, com os nomes concatenados à quantidade de letras de cada nome
        System.out.println("Retorna uma nova coleção com a quantidade de letras: "+estudantes.stream().map(estudante ->
                estudante.concat(" - ").concat(String.valueOf(estudante.length()))).collect(Collectors.toList()));

        //Retorna somente os cinco primeiros elementos da coleção
        System.out.println("Retorna os três primeiros elementos: "+ estudantes.stream().limit(5)
                .collect(Collectors.toList()));

        //Exibe cada elemento no console, e depois retorna a mesma coleção
        System.out.println("Retorna os elementos: "+estudantes.stream()
                           .peek(System.out::println).collect(Collectors.toList()));

        //Exibe cada elemento no console sem retornar outra coleção
        System.out.println("Retorna os elementos novamente: ");
        estudantes.stream().forEach(System.out::println);

        //Retorna true apenas se todos os elementos possuem a letra "w" no nome
        System.out.println("Todos os elementos tem a letra (w) no nome? "+estudantes.stream()
                           .allMatch((elemento) -> elemento.contains("w")));

        //Retorna true se algum elemento possui a letra "a"
        System.out.println("Tem algum elemento com a letra (a) minusculo no nome? "+estudantes.stream()
                .anyMatch((elemento -> elemento.contains("a"))));

        //Retorna true se nenhum elemento possue a letra (a) minuscula no nome
        System.out.println("Não tem nenhum elemento com a letra (a) minusculo no nome? " +estudantes.stream()
                .noneMatch((elemento -> elemento.contains("a"))));

        //Retorna o primeiro elemento da coleção, se existir exibe no console
        System.out.println("Retorna o primeiro elemento da coleção: ");
        estudantes.stream().findFirst().ifPresent(System.out::println);

        //Exemplo de operação encadeada
        System.out.println("Operação encadeada");
        System.out.println(estudantes.stream()
        .peek(System.out::println)
        .map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))
        .peek(System.out::println)
        .filter((estudante) -> estudante.toLowerCase().contains("r"))
        .collect(Collectors.toList()));

    }

}
