package instructions;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.ResponseSpecBuilder;
import org.apache.http.HttpStatus;


public final class Instructions {

    //ставим настройки запроса и ответа
    public void setProperty(RequestSpecification requestSpec, ResponseSpecification responseSpec){
        RestAssured.requestSpecification=requestSpec;
        RestAssured.responseSpecification=responseSpec;
    }

    //запрос на сайт с типом JSON
    public RequestSpecification requestInstructions(String address){
        return new RequestSpecBuilder().setBaseUri(address).setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON).build();
    }

    //ответ с логом и со статусом кода 200
    public ResponseSpecification responseSpecification(){
        return new ResponseSpecBuilder().log(LogDetail.ALL).expectStatusCode(HttpStatus.SC_OK).build();
    }

}
