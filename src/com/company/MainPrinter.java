package com.company;

public class MainPrinter {

    public static void main(String[] args) {

        Printer printer = new Printer("Epson",90,55,true);

        System.out.println(printer.printPages(56));
        printer.setTonerLevel(40);
        System.out.println(printer.printPages(25));


        Printer printer1 = new Printer("Panasonik",20,0,false);
        System.out.println( printer1.printPages(30));
        printer1.setTotalPaper(30);
        System.out.println(printer1.printPages(10));


    }
}
