package com.meli;

import java.util.LinkedList;

public class ListaParticipantes {

    private LinkedList<Participante> participantes = new LinkedList<>();

    private int getLastParticipanteIndex() {
        if (participantes.size() > 0)
            return participantes.getLast().getNumber();
        else
            return 0;
    }

    public void insertParticipante(Participante participante) {

        if (participante.getIdade() < 18 && participante.getCategoria().equals(Categoria.avancado)) {
            System.out.println("\nParticipant is under 18 and has subscribed for advanced track!");
            return;
        }

        int lastNumber = getLastParticipanteIndex();

        participante.setNumber(++lastNumber);
        participantes.addLast(participante);
    }

    public void printAllParticipants(Categoria categoria) {
        System.out.println("");
        if (participantes.size() < 1)
            return;

        for (Participante participant : participantes) {
            if (!categoria.equals(participant.getCategoria()))
                continue;

            System.out.println();
            System.out.println("Subscription Number: " + participant.getNumber() +
                    " - Nome: " + participant.getNome() + " - sobrenome: " + participant.getSobrenome() +
                    " - numero Celular: " + participant.getNumeroCelular() + " - numero Emergencia: " + participant.getNumeroEmergencia()+
                    " - RG: " + participant.getRG() + " - grupo sanguineo: " + participant.getGrupoSanguineo() +
                    " - idade: " + participant.getIdade() + " - valor: " + participant.getValue() +
                    " - categoria: " + participant.getCategoria());
        }

    }

    private int searchParticipantIndexById(int id) {
        for (int i = 0; i < participantes.size(); i++) {
            if (participantes.get(i).getNumber() == id)
                return i;
        }

        return -1;
    }

    public void cancelParticipant(int id) {
        int participanteIndex = searchParticipantIndexById(id);
        if (participanteIndex != -1)
            participantes.remove(participanteIndex);
        else
            System.out.println("\nId Not found!");
    }

}
