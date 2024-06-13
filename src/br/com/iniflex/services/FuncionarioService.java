package br.com.iniflex.services;

import br.com.iniflex.model.Funcionario;
import br.com.iniflex.util.DateUtils;
import br.com.iniflex.util.NumberUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {

    public List<Funcionario> removerFuncionario(List<Funcionario> funcionarios, String nome) {
        return funcionarios.stream()
                .filter(funcionario -> !funcionario.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(funcionario -> System.out.println(formatarFuncionario(funcionario)));
    }

    private String formatarFuncionario(Funcionario funcionario) {
        return String.format("Nome: %s, Data de Nascimento: %s, Salário: %s, Função: %s",
                funcionario.getNome(),
                DateUtils.formatarData(funcionario.getDataNascimento()),
                NumberUtils.formatarNumero(funcionario.getSalario()),
                funcionario.getFuncao());
    }

    public List<Funcionario> aumentarSalario(List<Funcionario> funcionarios, BigDecimal percentual) {
        return funcionarios.stream()
                .map(funcionario -> {
                    BigDecimal novoSalario = funcionario.getSalario()
                            .multiply(BigDecimal.ONE.add(percentual))
                            .setScale(2, BigDecimal.ROUND_HALF_UP);
                    funcionario.setSalario(novoSalario);
                    return funcionario;
                })
                .collect(Collectors.toList());
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void imprimirPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        funcionariosPorFuncao.forEach((funcao, funcionarios) -> {
            System.out.println("Função: " + funcao);
            funcionarios.forEach(funcionario -> System.out.println(formatarFuncionario(funcionario)));
        });
    }

    public void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
        List<Integer> listaMeses = Arrays.stream(meses).boxed().collect(Collectors.toList());
        funcionarios.stream()
                .filter(funcionario -> listaMeses.contains(funcionario.getDataNascimento().getMonthValue()))
                .forEach(funcionario -> System.out.println(formatarFuncionario(funcionario)));
    }

    public void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow(() -> new NoSuchElementException("Lista de funcionários está vazia"));
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println(String.format("Nome: %s, Idade: %d", maisVelho.getNome(), idade));
    }

    public List<Funcionario> ordenarFuncionariosPorNome(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());

    }

    public BigDecimal imprimirTotalSalarios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, BigDecimal.ROUND_HALF_DOWN);
            System.out.println(String.format("Nome: %s, Salários Mínimos: %s",
                    funcionario.getNome(), NumberUtils.formatarNumero(salariosMinimos)));
        });
    }

    public BigDecimal calcularTotalSalarios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}