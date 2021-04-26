package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Main {
    private static final Logger logger = LogManager.getLogger(GUI.class);

    public static void main(String[] args){
        GUI gui = new GUI();
        String [] list_valut ={"RUB","USD","EUR","VND","JPY"};

        if(args.length ==3){
            logger.info("Введены 3 аргумента");
            if(Arrays.asList(list_valut).contains(args[0]) && Arrays.asList(list_valut).contains(args[1])){
                try {
                    Double.parseDouble(args[2]);
                    System.out.println("Perevod "+gui.proverka_money(args[0],args[1],Double.parseDouble(args[2]))+ " "+ args[1]);
                }
                catch (NumberFormatException e) {
                    logger.error("Неверынй формат третьего аргумента");
                    e.printStackTrace();
                }

            }
            else {
                logger.error("Ошибка в названии валют");
            }
        }
        else if(args.length > 0){
            logger.error("Проверьте аргументы");
        }
        else
        {
            logger.info("Агрументы не ввеедны, запуск интерефейса");
            gui.GUI_create();
        }
    }
}
