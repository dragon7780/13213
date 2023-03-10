package org.example.controller;


import org.example.container.ComponentContainer;
import org.example.dto.Profile;
import org.example.service.CardService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ProfileController {
    @Autowired
    private CardService cardService;
    public void start() {
        boolean b = true;
        while (b) {
            menu();
            int operation = ScannerUtil.getAction();
            switch (operation) {
                case 1-> addCard();
                case 2-> cardList();
                case 3-> changeCardStatus();
                case 4-> deleteCard();
                case 5-> refill();
                case 6-> transactionList();
                case 7-> payment();
                case 0-> b = false;
                default-> {
                    b = false;
                    System.out.println("Wrong operation number");
                }
            }
        }
    }


    public void menu() {
        System.out.println("1. Add Card");
        System.out.println("2. Card List ");
        System.out.println("3. Card Change Status");
        System.out.println("4. Delete Card");
        System.out.println("5. ReFill ");
        System.out.println("6. Transaction List");
        System.out.println("7. Make Payment");
        System.out.println("0. Log out");
    }

    /**
     * Card
     */

    private void addCard() {
        System.out.print("Enter card number: ");
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        Profile profile = ComponentContainer.currentProfile;
        cardService.addCardToProfile(profile.getPhone(), cardNumber);
    }

    private void cardList() {
        System.out.print("--- Card List ---");
        Profile profile = ComponentContainer.currentProfile;
        cardService.profileCardList(profile.getPhone());
    }

    private void changeCardStatus() {
        System.out.print("Enter card number: ");
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        Profile profile = ComponentContainer.currentProfile;
        cardService.userChangeCardStatus(profile.getPhone(), cardNumber);
    }

    private void deleteCard() {
        System.out.print("Enter card number: ");
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        Profile profile = ComponentContainer.currentProfile;
        cardService.userDeleteCard(profile.getPhone(), cardNumber);
    }

    private void refill() {
        System.out.print("Enter card number: ");
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        System.out.print("Enter amount: ");
        Double amount = scanner.nextDouble();
        Profile profile = ComponentContainer.currentProfile;
        cardService.userRefillCard(profile.getPhone(), cardNumber, amount);
    }


    /**
     * Transaction
     */
    private void transactionList() {

    }

    private void payment() {
    }

}
