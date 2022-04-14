package www.kzk;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ParametrizeTestsUsers {

    @BeforeAll
    static void setUp() {
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    //DataProvider or ArgumentSource - источник аргументов(данных) для тестов
    @ValueSource(strings = {
            "Aren",
            "Mikhail",
            "Alena",
            "Mri Ivanna"
    })

    // @Disabled(" Причина дизейбла, ссылаясь на баг-репорт")
    @DisplayName("Simple Test Form with Value Source")  // Подписывать тесты, понятное отображение
    @ParameterizedTest(name = "Simple Test Form with Value Source")
    void Test1(String testData) {
        String firstName = (testData);
        String lastName = "Karapetyan";
        String email = "romashka@mail.ru";
        String tel = "8800200060";
        String subjectsInput = "Hindi";
        String gender = "Male";
        String hobby = "Reading";
        String currentAddress = "Eto to4no Java?";
        String state = "Uttar Pradesh";
        String city = "Merrut";


        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(tel);
        $("#dateOfBirthInput").click();
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
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(tel),
                text("04 May,1991"),
                text(subjectsInput),
                text(hobby),
                text("123"),
                text(currentAddress),
                text(state + " " + city)
        );
    }


    @CsvSource(value = {
            "Vlad, Vlad | Kornev | ghy@jjh.ua",
            "Valentin | Bugaga, Privet| hgf@dff.ru",
            "Dodo | Pizza | vkusno@dodo.com"
    },
            delimiter = '|')  // - если в тестовх данных где то есть запятая, то необходимл установить делиметр,
    // для того чтобы машина знала, что разделитель другой символ, так как ЗАПЯТАЯ по дефолту является разделителем!!!
// Если запятых в данных нет, то в качетсве разделителя нужно использовать дефолтную ЗАПЯТУЮ

    @ParameterizedTest(name = "Csv Source")
    void TestWithCsvSours(String testDataName, String testDataLastN, String testDataMail) {
        String firstName = (testDataName);
        String lastName = (testDataLastN);
        String email = (testDataMail);
        String tel = "8800200060";
        String subjectsInput = "Hindi";
        String gender = "Male";
        String hobby = "Reading";
        String currentAddress = "Eto to4no Java?";
        String state = "Uttar Pradesh";
        String city = "Merrut";


        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(tel);
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
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(tel),
                text("04 May,1991"),
                text(subjectsInput),
                text(hobby),
                text("123"),
                text(currentAddress),
                text(state + " " + city)
        );
    }


}
