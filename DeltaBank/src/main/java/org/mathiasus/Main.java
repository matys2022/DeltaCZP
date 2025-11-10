package org.mathiasus;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.mathiasus.accounts.*;
import org.mathiasus.serialization.accounts.*;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new BankInjector());
        App app = injector.getInstance(App.class);
        app.run();


    }


}