package org.example.controller;

import org.example.container.ComponentContainer;
import org.example.dto.Profile;
import org.example.service.AuthService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Scanner;
@Component
@Controller
public class AuthController {
    @Autowired
    private AuthService authServ;

    public void start() {
        boolean game = true;
        while (game) {
            menu();
            int action = ScannerUtil.getAction();
            switch (action) {
                case 1->login();
                case 2-> registration();
                case 0-> game = false;
                default-> System.out.println("Mazgi nima bu");
            }
        }
    }

    public void menu() {
        System.out.println("********************Menu***********************");
        System.out.println("1. Login > ");
        System.out.println("2. Registration > ");
        System.out.println("0. Exit > ");
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter phone:");
        String phone = scanner.nextLine();
        System.out.print("Enter pswd:");
        String password = scanner.next();
        authServ.login(phone, password);
    }

    private void registration() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name:");
        String name = scanner.next();

        System.out.print("Enter surname:");
        String surname = scanner.next();

        System.out.print("Enter phone:");
        String phone = scanner.next();

        System.out.print("Enter pswd:");
        String password = scanner.next();

        Profile profile = new Profile();
        profile.setName(name);
        profile.setSurname(surname);
        profile.setPhone(phone);
        profile.setPassword(password);
        authServ.registration(profile);
    }

    public void init(){
        System.out.println("AuthController is get ready");
    }
}
