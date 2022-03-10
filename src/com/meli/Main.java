package com.meli;

import java.util.Scanner;

public class Main {


    public static void insertParticipant(ListaParticipantes listaParticipantes) {
        Participante participante = new Participante();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Idade");
        int idade = scanner.nextInt();
        System.out.println("RG");
        String RG = scanner.next();
        System.out.println("nome");
        String nome = scanner.next();
        System.out.println("sobrenome");
        String sobrenome = scanner.next();
        System.out.println("numero celular");
        String numeroCelular = scanner.next();
        System.out.println("numero emergencia");
        String numeroEmergencia = scanner.next();
        System.out.println("grupo sanguineo");
        String grupoSanguineo = scanner.next();
        System.out.println("categoria");
        String categoria = scanner.next();

        participante.setIdade(idade);
        participante.setRG(RG);
        participante.setNome(nome);
        participante.setSobrenome(sobrenome);
        participante.setNumeroCelular(numeroCelular);
        participante.setNumeroEmergencia(numeroEmergencia);
        participante.setGrupoSanguineo(grupoSanguineo);
        participante.setCategoria(Categoria.valueOf(categoria));

        listaParticipantes.insertParticipante(participante);
    }

    public static void cancela(ListaParticipantes listaParticipantes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o Id");
        int id = scanner.nextInt();

        listaParticipantes.cancelParticipant(id);
    }


    public static void main(String[] args) {


        ListaParticipantes listaParticipantes = new ListaParticipantes();

        String repeat;
        int UserInpVal;


        Scanner keyboard = new Scanner(System.in);

        System.out.println("1-Inscrever\n2-Mostrar todos\n3-Cancelar inscrição");
        repeat = keyboard.nextLine();

        while (repeat.equals("1") || repeat.equals("2") || repeat.equals("3")) {
            //UserInpVal = repeat;

            if (repeat.equals("1")) {
                System.out.println(repeat);
                insertParticipant(listaParticipantes);
            }
            if (repeat.equals("2"))
                listaParticipantes.printAllParticipants();

            if (repeat.equals("3"))
                cancela(listaParticipantes);

            System.out.println("1-Inscrever\n2-Mostrar todos\n3-Cancelar inscrição");
            repeat = keyboard.nextLine();
        }

    }
}
