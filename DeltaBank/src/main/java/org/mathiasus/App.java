package org.mathiasus;

import com.google.inject.Inject;
import org.mathiasus.accounts.*;
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
import org.mathiasus.services.manageInterest.InterestCronService;

import javax.naming.OperationNotSupportedException;

public class App {
    @Inject
    BankAccountFactory bankAccountFactory;

    @Inject
    BalanceManagementService balanceManagementService;

    @Inject
    BankAccountSerializationFactory bankAccountSerializationFactory;

    @Inject
    CardManagementService cardManagementService;

    @Inject
    PaymentCardFactory paymentCardFactory;

    @Inject
    CardPaymentService cardPaymentService;

    @Inject
    InterestCronService interestCronService;

    public App(){

    }
    public void run()
    {
        Customer customer = new Customer("c-222", "John", "", "Middleman");
        School school = new School("6332340273", "Gymnazium jana capka", "Praha 8", "janacapka@example.com", FaciltityType.School);


        BankAccount account0 = bankAccountFactory.createRegularAccount(customer, 123);
        BankAccount account1 = bankAccountFactory.createSaveAccount(customer, 123, -0.1f);
        BankAccount account2 = bankAccountFactory.createStudentAccount(customer, 123, school);


        try{
            testAccount(account0);
            testAccount(account1);
            testAccount(account2);


        }catch (Exception e) {
            System.err.println(e.getMessage());
        }

        interestCronService.run();

    }

    private void testAccount(BankAccount account) throws OperationNotSupportedException {


        printAccount(account);

//        BalanceManagementService balanceManagementService = container.getBalanceManagementService();



        balanceManagementService.deposit( account,250);

        printAccount(account);

        balanceManagementService.withdraw(account,250);

        printAccount(account);



//        BankAccountSerializationFactory bankAccountSerializationFactory = container.getBankAccountSerializationFactory();
        String json;
        String xml;

        if(account instanceof BankAccountWithPaymentCard){

//            CardManagementService cardManagementService = new CardManagementService();

            PaymentCard card = paymentCardFactory.createDebitPaymentCard(new Customer("c-222", "John", "", "Middleman"), 0 );

            cardManagementService.addPaymentCard(card, ((BankAccountWithPaymentCard)account));

            String cardNum = ((BankAccountWithPaymentCard) account).getPaymentCards().entrySet().iterator().next().getValue().getCardNumber();

            System.out.println("Printing the card number of newly created payment card");
            System.out.println(cardNum);



            cardPaymentService.deposit(card, 30);
            cardPaymentService.withdraw(card, 100);

            cardManagementService.removePaymentCard(cardNum, ((BankAccountWithPaymentCard)account));
        }


        switch (account){
            case  RegularAccount BankAccount:

                System.out.println("Serialization of the account");

                RegularAccountSerialization regularAccountSerializable = bankAccountSerializationFactory.createRegularAccountSerialization(BankAccount);
                RegularAccountJsonSerializationService regularAccountJsonSerializationService = new RegularAccountJsonSerializationService();
                RegularAccountXmlSerializationService regularAccountXmlSerializationService = new RegularAccountXmlSerializationService();
                json = regularAccountJsonSerializationService.serialize(regularAccountSerializable);
                xml = regularAccountXmlSerializationService.serialize(regularAccountSerializable);



                System.out.println("Deserialization of the account");
                RegularAccount deserializedJson = (RegularAccount) regularAccountJsonSerializationService.deserialize(json);
                RegularAccount deserializedXml = (RegularAccount) regularAccountXmlSerializationService.deserialize(xml);


                // Writing the contents of deserialized objects into console
                System.out.println(deserializedJson.getCustomer().getFirstName());
                System.out.println(deserializedXml.getCustomer().getLastName());


                break;
            case  SaveAccount BankAccount:

                System.out.println("Serialization of the account");
                SaveAccountSerialization saveAccountSerializable = bankAccountSerializationFactory.createSaveAccountSerialization(BankAccount);
                SaveAccountJsonSerializationService saveAccountJsonSerializationService = new SaveAccountJsonSerializationService();
                SaveAccountXmlSerializationService saveAccountXmlSerializationService = new SaveAccountXmlSerializationService();
                json = saveAccountJsonSerializationService.serialize(saveAccountSerializable);
                xml = saveAccountXmlSerializationService.serialize(saveAccountSerializable);

                System.out.println(json);

                System.out.println("Deserialization of the account");
                SaveAccount deserializedJsonSaveAccount = (SaveAccount) saveAccountJsonSerializationService.deserialize(json);
                SaveAccount deserializedXmlSaveAccount = (SaveAccount) saveAccountXmlSerializationService.deserialize(xml);


                // Writing the contents of deserialized objects into console
                System.out.println(deserializedJsonSaveAccount.getCustomer().getFirstName());
                System.out.println(deserializedXmlSaveAccount.getCustomer().getFirstName());
                System.out.println(String.format("Next month increase will be approximately %f", deserializedJsonSaveAccount.getBalance() * deserializedJsonSaveAccount.getInterestRate()));


                break;
            case  StudentAccount BankAccount:

                System.out.println("Serialization of the account");
                StudentAccountSerialization studentAccountSerializable = bankAccountSerializationFactory.createStudentAccountSerialization(BankAccount);
                StudentAccountJsonSerializationService studentAccountJsonSerializationService = new StudentAccountJsonSerializationService();
                StudentAccountXmlSerializationService studentAccountXmlSerializationService = new StudentAccountXmlSerializationService();
                json = studentAccountJsonSerializationService.serialize(studentAccountSerializable);
                xml =  studentAccountXmlSerializationService.serialize(studentAccountSerializable);



                System.out.println("Deserialization of the account");
                StudentAccount deserializedJsonStudent = (StudentAccount) studentAccountJsonSerializationService.deserialize(json);
                StudentAccount deserializedXmlStudent = (StudentAccount) studentAccountXmlSerializationService.deserialize(xml);
                System.out.println(deserializedJsonStudent.getCustomer().getFirstName());
                System.out.println(deserializedXmlStudent.getCustomer().getFirstName());


                // Writing the contents of deserialized objects into console
                System.out.println("Owner of this bank account named " + deserializedJsonStudent.getCustomer().getFirstName()+ " " + deserializedJsonStudent.getCustomer().getLastName() + " is a student of " + deserializedJsonStudent.getSchool().getFacilityName());

                break;
            default:
                throw new OperationNotSupportedException("Account type not implemented yet!");
        }
        System.out.println(json);
        System.out.println(xml);
    }


    private void printAccount(BankAccount account){
        Customer customer = account.getCustomer();
        System.out.println(customer.getFirstName() + " " + customer.getLastName() + ": " +  account.getBalance());
    }

}
