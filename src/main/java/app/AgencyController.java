package app;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Route;
import spark.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class AgencyController {


 public AgencyController(){ }

    public static Route getAgency = (Request request, Response response) -> {

       response.type("application/json");

       String site = request.params(":site");
       String payment = request.params(":payment");
       String lat = request.params(":lat");
       String lon = request.params(":lon");
       String limit = (request.queryParams("limit")!=null) ? request.queryParams("limit") : "";
       String offset = (request.queryParams("offset")!=null) ? request.queryParams("offset") : "";
       String sortBy = (request.queryParams("sort")!=null) ? request.queryParams("sort") : "";

       Agency[] agencies = null;
       OrderEnum orderEnum = OrderEnum.DISTANCE;


        String urlString = "https://api.mercadolibre.com/sites/"+site+"/payment_methods/"+payment+
               "/agencies?near_to="+lat+","+lon+",300&limit="+limit+"&offset="+offset;

        try {

            String data = readUrl(urlString);
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(data).getAsJsonObject();
            agencies = new Gson().fromJson(jsonObject.get("results"), Agency[].class);

        } catch (IOException e) {
           System.out.println("Ocurrió un error");
           e.printStackTrace();
       }


       switch(sortBy){
           case "address":
               orderEnum = OrderEnum.ADDRESS;
               break;
           case "agency_code":
               orderEnum = OrderEnum.AGENCY_CODE;
               break;
           case "distance":
               orderEnum = OrderEnum.DISTANCE;
               break;
        }

       for(Agency a : agencies){
           a.setOrderEnum(orderEnum);
       }

       Sort.sortBy(agencies);


       return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
               new Gson().toJsonTree(agencies)));

   };

    private static String readUrl(String urlString) throws IOException {

        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        int read = 0;
        char[] chars = new char[1024];

        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            bufferedReader = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream(), "UTF-8"));

            while((read = bufferedReader.read(chars)) != -1){
                stringBuffer.append(chars, 0, read);
            }

            return stringBuffer.toString();

        } finally {
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }
    }


}
