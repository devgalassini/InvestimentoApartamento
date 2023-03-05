package aplicacao;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import java.util.InputMismatchException;
import java.util.Scanner;

import entidades.Banco;
import entidades.Bitcoin;
import entidades.Contrato;
import entidades.UNA;
import personalizada.Erro;
import servicos.ServicoBanco;
import servicos.ServicoBitCoin;
import servicos.ServicoFaculdade;

public class Programa {
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws ParseException {
		System.out.println("Digite quantos meses você tem de Contrato : ");
	    
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\rl1galaspr\\Documents\\AcademiaJavaQintessProjeto01\\Contrato.doc"))) {
		int month = sc.nextInt();
		
        ServicoBitCoin bitcoin = new Bitcoin(month);
        ServicoBanco banco = new Banco();
        ServicoFaculdade faculdade = new UNA();
        Contrato contrato = new Contrato(bitcoin,banco,faculdade);

        System.out.println(contrato.formated());
    
        	bw.write(contrato.formated());
        	bw.newLine();
        bw.close();	
        }
        
        catch(IOException e) {
        	System.out.println("Error : " + e.getMessage());
        }
        catch(InputMismatchException f) {
        	System.out.println("Error : Digite apenas números");
        }
        catch(Erro g) {
        	System.out.println("Error : " + g.getMessage());
        }
        finally {
        	sc.close();
        	System.out.println("Programa Finalizado");
        }
        
        }

}
