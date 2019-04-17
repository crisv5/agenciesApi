package app;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) throws IOException {

        get("/agencias/:site/:payment/:lat/:lon", AgencyController.getAgency);

    }

}
