package com.company;


/* Декоратор - это оболочка над конкретным компанентом(в нащем случае - интерфейс PrinterInterface).
*  Позволяет не менять клиентский код, а изменения вносить в декораторе, после чего клиенский код покажет изменеия.
*  Аналогия со сценой. Сцена одна, а декорации меняются.*/

public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface printer = new QuotesDecorator(new LeftBraketDecorator(new Printer("Привет")));
        printer.print();
    }

interface PrinterInterface{
        void print();
}

static class Printer implements PrinterInterface{
    String value;
    public Printer(String value){
        this.value = value;
    }
    public void print() {
        System.out.println(value);
        }
    }

abstract static class Decorator implements PrinterInterface{
    PrinterInterface component;
    public Decorator(PrinterInterface component) {
        this.component = component;
    }
}

static class QuotesDecorator extends Decorator{
    public QuotesDecorator(PrinterInterface component){
        super(component);
    }
    public void print() {
        System.out.print("\"");
        component.print();
    }
}
static class LeftBraketDecorator extends Decorator{
    public LeftBraketDecorator(PrinterInterface component){
        super(component);
    }
    public void print(){
        component.print();
        System.out.println("]");
        }
    }
}


