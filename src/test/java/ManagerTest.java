import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketManager;
import ru.netology.repository.TicketRepository;
import ru.netology.service.Ticket;

public class ManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    Ticket ticket1 = new Ticket(1256, 4499, "DME", "AER", 225);
    Ticket ticket2 = new Ticket(569, 5206, "VKO", "LED", 100);
    Ticket ticket3 = new Ticket(257, 15_420, "UUS", "SVO", 520);
    Ticket ticket4 = new Ticket(23, 9099, "AER", "GSV", 170);
    Ticket ticket5 = new Ticket(1986, 9499, "VKO", "KGD", 130);
    Ticket ticket6 = new Ticket(369, 4267, "SVO", "MSQ", 90);
    Ticket ticket7 = new Ticket(78, 3599, "VKO", "SVX", 145);
    Ticket ticket8 = new Ticket(2369, 12_749, "DME", "ABA", 275);
    Ticket ticket9 = new Ticket(5048, 4036, "VKO", "LED", 155);
    Ticket ticket10 = new Ticket(987, 19_452, "NSK", "DME", 270);

    @BeforeEach
    public void SetUp() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

    }

    @Test
    public void findATicket() {                             // найти билет по аэропорту

        Ticket[] expected = {ticket8};
        Ticket[] actual = manager.findAll("DME", "ABA");

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findAirportDuplicatesFromTo() {                        // найти билеты одинакового маршрута из-в отсортированные по цене

        Ticket[] expected = {ticket9, ticket2};
        Ticket[] actual = manager.findAll("VKO", "LED");

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test                                                               // сортируем билеты по цене по возрастанию
    public void sortingTicketsAscending() {

        Ticket[] expected = {ticket7, ticket9, ticket6, ticket1, ticket2, ticket4, ticket5, ticket8, ticket3, ticket10};
        Ticket[] actual = manager.findAll("", "");

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test                                                    // ищем дублированный аэропорт вылета, сортируем по цене
    public void sortingTicketsDepartureAirport() {

        Ticket[] expected = {ticket1, ticket8};
        Ticket[] actual = manager.findAll("DME", "");

        Assertions.assertArrayEquals(actual, expected);


    }

    @Test                                                                   //  ищем дублированный аэропорт прилёта, сортируем по цене
    public void sortingTicketsAirportOfArrival() {

        Ticket[] expected = {ticket9, ticket2};
        Ticket[] actual = manager.findAll("", "LED");

        Assertions.assertArrayEquals(actual, expected);


    }

    @Test
    public void wrongAirportOfArrival() {                              // неверно указан аэропорт прибытия

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("VKO", "DME");

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void wrongAirportOfDeparture() {                                 // неверно указан аэропорт вылета

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("ZIA", "NSK");

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void ticketForNon_ExistentRoute() {                              // прямого маршрута нет

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("NSK", "GSV");

        Assertions.assertArrayEquals(actual, expected);
    }


}
