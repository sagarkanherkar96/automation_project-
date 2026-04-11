package com.flipkart.test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.devtools.v140.fetch.model.AuthChallengeResponse;
import org.testng.annotations.Test;
import pojo.OrderRequest;
import pojo.OrderResponse;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.*;

public class ApiAutomation {

    public void getResponse(){
 Response response =given()
                .baseUri("https://master-data.jsw1msme.in/master_data_service")
                .basePath("/api/v2/bulk/search/vendor")
                .queryParam("vendor_key","V2052-2720-JOPL")
                .header("authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2X3NhZ2FyLmthbmhlcmthckBqc3cuaW4iLCJhdXRoIjoiUk9MRV9VU0VSIiwidXNlcl9rZXkiOiI3ZjUyNmE4Yi1iMzBmLTRhZjgtYjg4Ni1iOWJjMTRmYWJiYTEiLCJpYXQiOjE3Njc5Mzk0MzMsImV4cCI6MTc2ODAyNTgzM30.OhjBHEHJiMwc_hlBODEvS8PCQsyDY-1uRXwp27DQV2-yum3slEb-G1pPVjMNzc74AIjxhHyI0HIfTH9BnekJrg")
       .when()
                .get()
       .then()
                .statusCode(401)
         .body("error.message",equalTo("Invalid token! Did you bring a fake ID?"))
         .extract().response();
        System.out.println(response.asPrettyString());

    }


    public void inlineResponseValidation(){
        Response response =given()
                .baseUri("https://master-data.jsw1msme.in/master_data_service")
                .basePath("/api/v2/bulk/search/vendor")
                .queryParam("vendor_key","V2052-2720-JOPL")
                .header("authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2X3NhZ2FyLmthbmhlcmthckBqc3cuaW4iLCJhdXRoIjoiUk9MRV9VU0VSIiwidXNlcl9rZXkiOiI3ZjUyNmE4Yi1iMzBmLTRhZjgtYjg4Ni1iOWJjMTRmYWJiYTEiLCJpYXQiOjE3Njg1NjEzMDQsImV4cCI6MTc3MTE1MzMwNH0.T9ZeLgzZ9L_0115PkxM1W43XkxGerTdFp7YtUZdcQOQ4J-ZhUKZFDBhYUU7l-4fRRjhTF_jEFxqNdpjfZoBJNg")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("data[0].gst.find{it.gst_key==2720}.locations.find {it.is_registered_billing_address==true}.location_display_name",equalTo("ARCELORMITTAL NIPPON STEEL INDIA LIMITED"))
               // .body("data.find { it.pan_key == 'V2828' }.pan_name", equalTo("UAT BankQANew"))
                .extract().response();
        System.out.println(response.asPrettyString());

    }

    public void postApiWithRequestBody() throws IOException {
        //convert  json to pojo
        ObjectMapper objectMapper = new ObjectMapper();
        OrderRequest orderRequest = objectMapper.readValue(new File("src/test/resources/testdata/orderRequest.json"),  OrderRequest.class);
        //value adding in pojo
//        OrderRequest orderRequest = new OrderRequest();
//        orderRequest.setId(0);
//        orderRequest.setPetId(0);
//        orderRequest.setQuantity(0);
//        orderRequest.setShipDate("2026-01-17T15:26:24.951Z");
//        orderRequest.setStatus("delivered");
//        orderRequest.setComplete(true);

        //json to string body
//        String orderRequest = "{\n" +
//                "  \"id\": 0,\n" +
//                "  \"petId\": 0,\n" +
//                "  \"quantity\": 0,\n" +
//                "  \"shipDate\": \"2026-01-17T15:26:24.951Z\",\n" +
//                "  \"status\": \"stopped\",\n" +
//                "  \"complete\": true\n" +
//                "}";
        OrderResponse orderResponse=given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/store/order")
                .contentType(ContentType.JSON)
                .body(orderRequest)         // --> pojo request,convert json to pojo ,convert json to string
                  .when()
                .post()
                .then()
                .extract().as(OrderResponse.class);
        System.out.println(orderResponse.getStatus());

    }
    @Test
    public void responseValidationUsingResponse(){
        RequestSpecification req =given()
                .baseUri("https://master-data.jsw1msme.in/master_data_service")
                .basePath("/api/v2/bulk/search/vendor")
                .queryParam("vendor_key","V2052-2720-JOPL")
                .header("authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2X3NhZ2FyLmthbmhlcmthckBqc3cuaW4iLCJhdXRoIjoiUk9MRV9VU0VSIiwidXNlcl9rZXkiOiI3ZjUyNmE4Yi1iMzBmLTRhZjgtYjg4Ni1iOWJjMTRmYWJiYTEiLCJpYXQiOjE3Njg1NjEzMDQsImV4cCI6MTc3MTE1MzMwNH0.T9ZeLgzZ9L_0115PkxM1W43XkxGerTdFp7YtUZdcQOQ4J-ZhUKZFDBhYUU7l-4fRRjhTF_jEFxqNdpjfZoBJNg");
        Response res = req.get();
                res.then()
                .statusCode(200);
               // .body("data[0].gst.find{it.gst_key==2720}.locations.find {it.is_registered_billing_address==true}.location_display_name",equalTo("ARCELORMITTAL NIPPON STEEL INDIA LIMITED"))
                // .body("data.find { it.pan_key == 'V2828' }.pan_name", equalTo("UAT BankQANew"))
                //.extract().response();
        System.out.println( res.jsonPath().getString("data[0].pan_key"));
        System.out.println(res.asPrettyString());


    }
}

/*
RequestSpecification req =
        given()
                .header("Content-Type","application/json")
                .body(payload);

Response res = req.post("/createUser");

res.then()
   .statusCode(201)
   .body("id", notNullValue());
*/