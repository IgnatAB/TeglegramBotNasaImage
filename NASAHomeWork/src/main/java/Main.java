import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileOutputStream;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, TelegramApiException {
       new MyNasaBot( "NasaFotoOfTheDay_bot" , "7815608745:AAEE3fft9x-JCC5-4U2MWLKx2iEpWYTHFS8" );
                }



 /*       String url = "https://api.nasa.gov/planetary/apod" +
                "?api_key=PlBwupr36pDhD31oXdScZrnh43yxCEpf5J3TtlC3" +
                "&date=2024-11-10";

        CloseableHttpClient httpclient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();


        HttpGet request = new  HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(request);
     /*   Scanner scanner = new Scanner(response.getEntity().getContent()); // в рамках метода сканер обращаемся в ответ сервера и запрашиваем тело ответа (getEntity) и то, что в этом теле лежит getContent
        // читаем документацию к методу сканер и там описаны эти команды.
        String answer = scanner.nextLine();
        System.out.println(answer);*/
/*        NasaAnswer answer = mapper.readValue(response.getEntity().getContent(), NasaAnswer.class);  // Этой командой сохраняем данные в переменную answer из файла json в программу с помощью класса NasaAnswer.
        System.out.println(answer.url);
        System.out.println(answer.explanation);

        String imageUrl = answer.url;
        String[] splitedAnswer = imageUrl.split("/");           //создаем массив для разбиения пути к файлу на части между слешами.
        String fileName = "Image/" + splitedAnswer[splitedAnswer.length-1];      // для имени файла выбираем последний элемент массива - там сохраняется имя файла как на сервере. Теперь файлы будут сохраняться с разными именами.

        HttpGet imageRequest = new HttpGet(imageUrl);   //Чтобы скачать картинку на ПК надо послать GET запрос на сервер
        CloseableHttpResponse image = httpclient.execute(imageRequest);  //наш клиент выполняет такой запрос.
        FileOutputStream fos = new FileOutputStream(fileName); // встроенный класс java - дискриптор, который позволяет сохранять файл в указанный путь.
        image.getEntity().writeTo(fos);                                  // собственно сохраняем содержимое в файл.
*/
    }
