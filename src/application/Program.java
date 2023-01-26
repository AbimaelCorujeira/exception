package application;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int numero = sc.nextInt();
        System.out.print("Data de check-in (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data de check-out (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: A data de check-out deve " +
                    "ser posterior à data de check-in");
        } else {
            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Insira os dados para atualizar a reserva:");
            System.out.print("Data de check-in (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date agora = new Date();
            if(checkIn.before(agora) || checkOut.before(agora)) {
                System.out.println("Erro na reserva: As datas da reserva para atualização devem ser datas futuras");
            } else {
                if(!checkOut.after(checkIn)) {
                    System.out.println("Erro na reserva: A data de check-out deve " +
                            "ser posterior à data de check-in");
                } else {
                    reserva.atualizarData(checkIn, checkOut);
                    System.out.println("Reserva: " + reserva);
                }
            }
        }
        sc.close();
    }
}
