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

        int lastNumber = getLastParticipanteIndex();

        participante.setNumber(++lastNumber);
        participantes.addLast(participante);
    }

    public void printAllParticipants() {
        System.out.println("");

        if (participantes.size() > 0) {
            for (Participante participant : participantes) {
                System.out.println(participant.getNumber() + " " + participant.getNome() + " " + participant.getIdade());
            }
            System.out.println("\n");
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
            System.out.println("\nId Not found");
    }

}
