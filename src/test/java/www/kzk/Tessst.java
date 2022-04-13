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
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    static Stream<Arguments> TestWithMethodSours() {
        return Stream.of(
                Arguments.of("Vladislav", "Privet", List.of(1234567890)),
                Arguments.of("Privet", "Poka", List.of(1111111111))

        );
    }

    @MethodSource("TestWithMethodSours")
    @ParameterizedTest(name = "С Методом сложным")
    void TestWithMethodSours(String TestDataName, String TestDataLastN, List<Long> TestDataPhone) {
        String firstName = (TestDataName);
        String lastName = (TestDataLastN);
        String email = ("foooo@mail.ru");
        // String tel = "8800200060";
        String subjectsInput = "Hindi";
        String gender = "Male";
        String hobby = "Reading";
        String currentAddress = "Eto to4no Java?";
        String state = "Uttar Pradesh";
        String city = "Merrut";
        // String dataBirth

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(String.valueOf(TestDataPhone));
        $("#dateOfBirthInput").click();
        //$(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--004:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#genterWrapper").$(byText(gender)).click();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("input#uploadPicture").uploadFromClasspath("123");
        //  $("#uploadPicture").uploadFromClasspath(imgPath);  альтернатива,
        //  задать переменную String imgPath = "img/Pushkin.jpg";
        $("#submit").click();

        // $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        // $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName+" "+lastName));
        $("#userNumber").shouldHave(Condition.attribute(String.valueOf(TestDataPhone)));
        //   $("#closeLargeModal").click();

    }
}
