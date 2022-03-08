import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class LocaldateTimeTest {
    public static void main(String[] args) {
        String time = LocalDateTime.now().atOffset(ZoneOffset.UTC).toString();
        // yyyy-MM-dd'T'HH:mm:ss.SSSz
        // yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz");
        DateTimeFormatter customFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateTimeFormatter customFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        System.out.println(LocalDateTime.now().atZone(ZoneOffset.UTC).format(customFormatter));
        System.out.println(LocalDateTime.now().atZone(ZoneOffset.UTC).format(customFormatter2));
        System.out.println(LocalDateTime.now().atZone(ZoneOffset.UTC).format(customFormatter3));

//        System.out.println((int)Double.parseDouble("999.0"));
    }
}
