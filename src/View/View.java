package View;
import Classes.Bestellung;
import Controller.Controllerr;
import Classes.Produkt;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class View {
    private Controllerr controller;
    public View(Controllerr controller) {
        this.controller = controller;
    }

    public void Run() {
        Scanner scanner = new Scanner(System.in);
        int continueLoop =1;
        while(continueLoop==1){
            System.out.println("1.Add Produkt\n2.Delete Produkt\n3.Update Produkt\n" +
                    "4.Add Bestellung\n5.Delete Bestellung\n6.Update Bestellung\n" +
                    "7.Sort Bestellung\n8.Filter Bestellung\n9.Exit\n");
            String prName;
            Float pPreis;
            Long pId;
            Long bId = null;
            Long bnr = null;
            String badr = null;
            List<Produkt> bprodukte = null;
            String input =scanner.next();
            System.out.println(input);

            switch (input) {
                case "1":
                    System.out.println("Neues Produkt Name : ");
                    prName = scanner.next();
                    System.out.println("Neues Produkt Id : ");
                    pId = Long.parseLong(scanner.next());
                    System.out.println("Neues Produkt Preis : ");
                    pPreis = Float.parseFloat(scanner.next());
                    Produkt newProdukt = new Produkt(pId, prName, pPreis);
                    controller.addProdukt(newProdukt);
                    break;

               case "2":
                    System.out.println("Produkt Id zum loschen : ");
                    pId = Long.parseLong(scanner.next());

                   controller.deleteProdukt(pId);
                   break;

                case "3":
                    System.out.println("Produkt Id fur update : ");
                    pId = Long.parseLong(scanner.next());
                    System.out.println("Neues Produkt Name : ");
                    prName = scanner.next();
                    System.out.println("Neues Produkt Preis : ");
                    pPreis = Float.parseFloat(scanner.next());
                    Produkt updateProdukt = new Produkt(pId, prName, pPreis);
                    controller.updateProdukt(updateProdukt);
                    break;


                case "4":
                    System.out.println("Bestellung Nummer : ");
                    prName = scanner.next();
                    System.out.println("Adresse: ");
                    pId = Long.parseLong(scanner.next());
                    System.out.println("Liste von Produkten : ");
                    pPreis = Float.parseFloat(scanner.next());
                    Bestellung newBestellung = new Bestellung(bnr, badr, bprodukte);
                    controller.addBestellung(newBestellung);
                    break;

                case "5":
                    System.out.println("Bestellung zum loschen : ");
                    pId = Long.parseLong(scanner.next());

                    controller.deleteBestellung(bId);
                    break;

                case "6":
                    System.out.println("Bestellung Nummer fur update : ");
                    pId = Long.parseLong(scanner.next());
                    System.out.println("Neue Adresse : ");
                    prName = scanner.next();
                    System.out.println("Neu Produktliste : ");
                    pPreis = Float.parseFloat(scanner.next());
                    Bestellung updateBestellung = new Bestellung(bnr, badr, bprodukte);
                    controller.updateBestellung(updateBestellung);
                    break;

                case "7":
                    System.out.println("Sort Bestellungen");
                    System.out.println(controller.sortBestellungenBYGTotal());
                    break;

                case "8":
                    System.out.println("Give Produkt Id zu Filter nach: ");
                    pId=Long.parseLong(scanner.next());
                    System.out.println(controller.filterBestellungenBYProdukt(pId));
                    break;

                case "9":
                    continueLoop=0;
                    break;
                default:
            }
            System.out.println("Success");

        }
    }
}
