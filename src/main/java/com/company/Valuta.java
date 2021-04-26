package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Valuta {
    private static final Logger logger = LogManager.getLogger(Valuta.class);
    private Double RUB;
    private Double USD;
    private Double EUR;
    private Double VND;
    private Double JPY;
    public double start_valut;
    public double end_valut;

    public double getRUB() {
        return Double.parseDouble(String.valueOf(RUB));
    }

    public double getUSD() {
        return Double.parseDouble(String.valueOf(USD));
    }

    public double getEUR() {
        return Double.parseDouble(String.valueOf(EUR));
    }

    public double getVND() {
        return Double.parseDouble(String.valueOf(VND));
    }

    public double getJPY() {
        return Double.parseDouble(String.valueOf(JPY));
    }

    public void setEnd_valut(double end_valut_value) {end_valut = end_valut_value;}

    public void setStart_valut(double start_valut_value) {start_valut = start_valut_value;}

    public double change_currency(Double money_count){return (start_valut/end_valut)*money_count;}




    public Valuta() {
        try (BufferedReader reader = new BufferedReader(new FileReader("kursvalut.txt"))) {
            String  line;
            ArrayList<String> list = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    line = line.replaceAll("RUB=", "");
                    line = line.replaceAll("USD=", "");
                    line = line.replaceAll("EUR=", "");
                    line = line.replaceAll("VND=", "");
                    line = line.replaceAll("JPY=", "");
                    list.add(line);
                }
            }
            RUB = Double.parseDouble(list.get(0));
            USD = Double.parseDouble(list.get(1));
            EUR = Double.parseDouble(list.get(2));
            VND = Double.parseDouble(list.get(3));
            JPY = Double.parseDouble(list.get(4));
            logger.info("Данные с файла успешно считаны");

        } catch (FileNotFoundException e) {
            logger.error("Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("Файл не читается");
            e.printStackTrace();
        }
    }
}
