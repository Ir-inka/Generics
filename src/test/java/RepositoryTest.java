import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;
import ru.netology.service.Ticket;

public class RepositoryTest {
    TicketRepository repository = new TicketRepository();
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

        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
        repository.save(ticket7);
        repository.save(ticket8);
        repository.save(ticket9);
        repository.save(ticket10);

    }

    @Test
    public void deleteById() {                              // удаляем по Id

        repository.deleteById(1256);
        repository.deleteById(569);
        repository.deleteById(5048);
        repository.deleteById(987);
        repository.deleteById(369);

        Ticket[] expected = {ticket3, ticket4, ticket5, ticket7, ticket8};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test                                           // вывод всего списка
    public void listingTickets() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchById() {                              // проверяем ищет ли по Id?

        Ticket[] expected = {ticket1, ticket7};
        Ticket[] actual = new Ticket[]{repository.findById(1256), repository.findById(78)};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByIdNull() {                              // проверяем поиск если Id не существует

        Ticket[] expected = {null};
        Ticket[] actual = new Ticket[]{repository.findById(1253)};

        Assertions.assertArrayEquals(expected, actual);


    }
}
