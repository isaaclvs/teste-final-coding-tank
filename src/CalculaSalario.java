import java.util.Scanner;

public class CalculaSalario {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salariosBrutos = new double[5];
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o salário bruto do funcionário " + (i + 1) + ": ");
            salariosBrutos[i] = scanner.nextDouble();
        }
        
        for (double salarioBruto : salariosBrutos) {
            double descontoINSS = calcularINSS(salarioBruto);
            double descontoIR = calcularIR(salarioBruto - descontoINSS);
            double salarioLiquido = salarioBruto - descontoINSS - descontoIR;
            
            for (int i = 0; i < 5; i++) {
            	System.out.println("\nMês " + i);
            	System.out.println("Salário Bruto: R$ " + salarioBruto);
            	System.out.println("Desconto INSS: R$ " + descontoINSS);
            	System.out.println("Desconto Imposto de Renda: R$ " + descontoIR);
            	System.out.println("Salário Líquido: R$ " + salarioLiquido);
            	
            	System.out.println("---------------------------------------");
            }
        }
        
        scanner.close();
    }
    
    public static double calcularINSS(double salario) {
        double desconto;
        if (salario <= 1212.00) {
            desconto = salario * 0.075;
        } 
        else if (salario <= 2427.35) {
            desconto = salario * 0.09;
        } 
        else if (salario <= 3641.03) {
            desconto = salario * 0.12;
        } 
        else if (salario <= 7087.22) {
            desconto = salario * 0.14;
        } 
        else {
            desconto = 7087.22 * 0.14;
        }
        return desconto;
    }
    
    public static double calcularIR(double salario) {
        double desconto;
        if (salario <= 1903.98) {
            desconto = 0.0;
        } else if (salario <= 2826.65) {
            desconto = (salario - 1903.98) * 0.075;
        } else if (salario <= 3751.05) {
            desconto = (salario - 2826.65) * 0.15 + 922.675 * 0.075;
        } else if (salario <= 4664.68) {
            desconto = (salario - 3751.05) * 0.225 + 924.4 * 0.15 + 922.675 * 0.075;
        } else {
            desconto = (salario - 4664.68) * 0.275 + 913.63 * 0.225 + 924.4 * 0.15 + 922.675 * 0.075;
        }
        return desconto;
    }
}
