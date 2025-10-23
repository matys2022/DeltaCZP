package org.mathiasus;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.mathiasus.accounts.*;
import org.mathiasus.cards.CreditCard;
import org.mathiasus.cards.PaymentCard;
import org.mathiasus.factories.BankAccountFactory;
import org.mathiasus.factories.PaymentCardFactory;
import org.mathiasus.models.facilities.education.School;
import org.mathiasus.models.facilities.enums.FaciltityType;
import org.mathiasus.persons.customers.Customer;
import org.mathiasus.serialization.accounts.*;
import org.mathiasus.services.balanceManagement.BalanceManagementService;
import org.mathiasus.services.cardManagement.CardManagementService;
import org.mathiasus.services.cardManagement.CardPaymentService;

import javax.naming.OperationNotSupportedException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new BankInjector());
        App app = injector.getInstance(App.class);
        app.run();


    }


}