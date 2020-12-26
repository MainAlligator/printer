package com.company;

public class Printer {
    private String name;
    private double tonerLevel = 100;
    private int totalPaper;
    private int numberOfPagesPrinted;
    private boolean isDoubleSided;

    public Printer(String name, double tonerLevel, int ammountOfPaper, boolean isDoubleSided) {
        this.name = name;
        if(tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }
        this.totalPaper = ammountOfPaper;
        this.isDoubleSided = isDoubleSided;
    }

    private boolean isOutOfToner(double numberToPrint) {
        return tonerLevel - (numberToPrint / 2) < 0;
    }



    private boolean isOutOfPaper(double numberToPrint) {
        return (totalPaper - numberToPrint) < 0;
    }

    private boolean twoSideNoPaperEven(double numberToPrint) {
        return (totalPaper - ((int) numberToPrint / 2)) < 0;
    }

    private boolean twoSideNoPaperOdd(double numberToPrint) {
        return ((totalPaper - ((int) numberToPrint / 2)) - 1) < 0;
    }

    public double printPages(double numberToPrint) {

        if(isDoubleSided == false) {
            if(tonerLevel == 0) {
                System.out.println("Закончился тонер");
            }
            if(totalPaper == 0) {
                System.out.println("Закончилась бумага");
            }
            if(isOutOfToner(numberToPrint) && (tonerLevel != 0)) {
                double difference = tonerLevel * 2;
                numberToPrint = difference;
                totalPaper -= numberToPrint;
                System.out.println("После этой печати закончится тонер, можно печатать " + (int) numberToPrint +
                        " Страницы");
                tonerLevel = 0;
            }
            if(isOutOfPaper(numberToPrint) && (totalPaper != 0)) {
                double different = totalPaper - numberToPrint;
                numberToPrint = numberToPrint + different;
                System.out.println("После этой печати закончится тонер, можно печатать " + (int) numberToPrint + " страницы");
                totalPaper = 0;
            }
            else if(!isOutOfToner(numberToPrint) && (!isOutOfPaper(numberToPrint))) {
                totalPaper -= numberToPrint;
                tonerLevel = tonerLevel - (numberToPrint / 2);
                showPages(numberToPrint);
            }

        }
        else if(isDoubleSided = true) {
            if (numberToPrint % 2 == 0) {
                if(tonerLevel == 0) {
                    System.out.println("Закончился тонер");
                }
                if(totalPaper == 0) {
                    System.out.println("Закончилась бумага");
                }
                if(twoSideNoPaperEven(numberToPrint) && (totalPaper != 0)) {
                    totalPaper -= numberToPrint / 2;
                    System.out.println("Нет бумаги");
                }
                else if(!twoSideNoPaperEven(numberToPrint)) {
                    tonerLevel = tonerLevel - (numberToPrint / 2);
                    totalPaper -= numberToPrint / 2;
                    showPages(numberToPrint);
                }
            } else {
                if(tonerLevel == 0) {
                    System.out.println("Закончился тонер");
                }
                if(totalPaper == 0) {
                    System.out.println("Закончилась бумага");
                }
                if(twoSideNoPaperOdd(numberToPrint) && (totalPaper != 0)) {
                    System.out.println("Нет бумаги");
                    totalPaper = (totalPaper - ((int) numberToPrint / 2)) - 1;
                    totalPaper = 0;
                }
                else if(!twoSideNoPaperOdd(numberToPrint)) {
                    tonerLevel = tonerLevel - (numberToPrint / 2);
                    totalPaper = (totalPaper - ((int) numberToPrint / 2)) - 1;
                    showPages(numberToPrint);
                }
            }
        }

        return numberToPrint;
    }

    public int showPages(double numberToPrint) {
        System.out.println("Печать " + (int) numberToPrint + " Осталось страниц бумаги: " + this.totalPaper
                + " Уровень тонера " + this.tonerLevel);
        return 0;
    }

    public void refillToner() {
        tonerLevel = 100;
    }
    public void refillPaper(int paper) {
        if(paper > 50) {
            System.out.println("Не могу вставить больше бумаги");
        }
        else {
            this.totalPaper += paper;
        }
    }

    public int getTotalPaper() {
        return totalPaper;
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public void setTonerLevel(double tonerLevel) {
        this.tonerLevel = tonerLevel;
    }

    public void setTotalPaper(int totalPaper) {
        this.totalPaper = totalPaper;
    }
}
