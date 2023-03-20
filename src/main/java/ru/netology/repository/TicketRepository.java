package ru.netology.repository;

import ru.netology.service.Ticket;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];


    public void save(Ticket item) {
        int index = items.length + 1;
        Ticket[] tmp = new Ticket[index];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int indexInd = tmp.length - 1;
        tmp[indexInd] = item;
        items = tmp;
    }

    public Ticket[] findAll() {
        return items;
    }

    public Ticket findById(int id) {
        for (Ticket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        int index = items.length - 1;
        Ticket[] tmp = new Ticket[index];
        int copyToIndex = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }
}
