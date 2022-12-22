import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocaldateTimeTest {
    public static void main(String[] args) {
        String time = LocalDateTime.now().toString();
        // yyyy-MM-dd'T'HH:mm:ss.SSSz
        // yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz").withZone(ZoneOffset.UTC);
        DateTimeFormatter customFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateTimeFormatter customFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

//        System.out.println(LocalDateTime.now().atZone(ZoneOffset.UTC).format(customFormatter));
//        System.out.println(LocalDateTime.now().atZone(ZoneOffset.UTC).format(customFormatter2));
//        System.out.println(LocalDateTime.now().atZone(ZoneOffset.UTC).format(customFormatter3));
//        System.out.println(ZonedDateTime.parse(LocalDateTime.now().toString()).withZoneSameLocal(ZoneOffset.UTC).format(customFormatter));
//        System.out.println(ZonedDateTime.ofInstant(LocalDateTime.now().toInstant(ZoneOffset.UTC), ZoneId.systemDefault()).format(customFormatter));
//        System.out.println((int)Double.parseDouble("999.0"));
        System.out.println(OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")));
    }
}
