package www.kzk;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@DisplayName("Не работает, не отображается")  // Подписывать тесты, понятное отображение
public class Tessst {


    static Stream<Arguments> Test2MethodSource() {
        return Stream.of(
                Arguments.of("Vladislav", "Privet", List.of(12)),
                Arguments.of("Privet", "Poka", List.of(23))

        );
    }
    @MethodSource("Test2MethodSource")
    @ParameterizedTest(name = "С Методом сложным Попытка 2")
    void Test2MethodSource (String value1, String value2, List <Long> value3){
        System.out.println(value1 + value2 + value3);

    }

}
