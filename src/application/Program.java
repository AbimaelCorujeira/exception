package application;

import model.entities.Reserva;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int numero = sc.nextInt();
            System.out.print("Data de check-in (dd/mm/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Insira os dados para atualizar a reserva:");
            System.out.print("Data de check-in (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserva.atualizarData(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
        } catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado!");
        }
        sc.close();
    }
}
