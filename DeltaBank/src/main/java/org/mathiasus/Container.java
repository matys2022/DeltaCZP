//package org.mathiasus;
//
//import org.mathiasus.factories.BankAccountFactory;
//import org.mathiasus.factories.BankLogFactory;
//import org.mathiasus.serialization.accounts.BankAccountSerializationFactory;
//import org.mathiasus.services.balanceManagement.BalanceManagementService;
//import org.mathiasus.services.logging.BankLogService;
//import org.mathiasus.utilities.generation.*;
//
//public class Container {
//    private final CardGenerationAccNumber cardGenerationAccNumber = new CardGenerationAccNumber();
//    private final CardGenerationCVV cardGenerationCVV = new CardGenerationCVV();
//    private final CardGenerationExpDate cardGenerationExpDate = new CardGenerationExpDate();
//    private final CardGenerationCrdPin cardGenerationCrdPin = new CardGenerationCrdPin();
//    private final CardGenerationUUID cardGenerationUUID = new CardGenerationUUID();
//    private final BalanceManagementService balanceService = new BalanceManagementService();
//    private final BankLogService logService = new BankLogService();
//    private final BankLogFactory bankLogFactory = new BankLogFactory();
//    private final BankAccountSerializationFactory bankAccountSerializationFactory = new BankAccountSerializationFactory();
//    private final BalanceManagementService balanceManagementService = new BalanceManagementService();
//    private final BankAccountFactory bankAccountFactory = new BankAccountFactory();
//
//    public Container() {
//    }
//
//    public CardGenerationAccNumber getCardGenerationAccNumber() {
//        return cardGenerationAccNumber;
//    }
//
//    public CardGenerationCVV getCardGenerationCVV() {
//        return cardGenerationCVV;
//    }
//
//    public CardGenerationExpDate getCardGenerationExpDate() {
//        return cardGenerationExpDate;
//    }
//
//    public CardGenerationCrdPin getCardGenerationCrdPin() {
//        return cardGenerationCrdPin;
//    }
//
//    public CardGenerationUUID getCardGenerationUUID() {
//        return cardGenerationUUID;
//    }
//
//
//
//    public BalanceManagementService getBalanceService() {
//        return balanceService;
//    }
//
//    public BankLogService getLogService() {
//        return logService;
//    }
//
//    public BankLogFactory getBankLogFactory() {
//        return bankLogFactory;
//    }
//
//
//    public BankAccountSerializationFactory getBankAccountSerializationFactory() {
//        return bankAccountSerializationFactory;
//    }
//
//    public BalanceManagementService getBalanceManagementService() {
//        return balanceManagementService;
//    }
//
//    public BankAccountFactory getBankAccountFactory() {
//        return bankAccountFactory;
//    }
//}
//
