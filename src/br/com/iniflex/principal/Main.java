package br.com.iniflex.principal;

import br.com.iniflex.model.Funcionario;
import br.com.iniflex.services.FuncionarioService;
import br.com.iniflex.util.DateUtils;
import br.com.iniflex.util.NumberUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FuncionarioService funcionarioService = new FuncionarioService();


        // 3.1  Inserir todos os funcionários
        List<Funcionario> funcionarios = List.of(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 05, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 05, 02), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 01, 05), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 07, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 02), new BigDecimal("2799.93"), "Gerente")

        );



        // 3.2 Remover o funcionário “João”
        funcionarios = funcionarioService.removerFuncionario(funcionarios, "João");



        // 3.3 Imprimir todos os funcionários
        funcionarioService.imprimirFuncionarios(funcionarios);



        // 3.4 10% de aumento de salário
        funcionarios = funcionarioService.aumentarSalario(funcionarios, new BigDecimal("0.10"));



        // 3.5 Agrupar por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarioService.agruparPorFuncao(funcionarios);



        // 3.6 Imprimir agrupados por função
        funcionarioService.imprimirPorFuncao(funcionariosPorFuncao);



        // 3.8 Imprimir aniversariantes dos meses 10 e 12
        funcionarioService.imprimirAniversariantes(funcionarios, 10, 12);



        // 3.9 Imprimir funcionário com maior idade
        funcionarioService.imprimirFuncionarioMaisVelho(funcionarios);



        // 3.10 Imprimir por ordem alfabética
        funcionarioService.ordenarFuncionariosPorNome(funcionarios);



        // 3.11 Imprimir total dos salários
        funcionarioService.imprimirTotalSalarios(funcionarios);



        // 3.12 Imprimir quantos salários mínimos cada funcionário ganha
        funcionarioService.imprimirSalariosMinimos(funcionarios, new BigDecimal("1212.00"));


    }
}