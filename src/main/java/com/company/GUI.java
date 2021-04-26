package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private static final Logger logger = LogManager.getLogger(GUI.class);
    public final Valuta valuta = new Valuta();
    JFrame window;
    JTextField text_first, text_end;
    JButton voodoo;
    private String start_valuta;
    private String end_valuta;

    public void button (int x_axis, int y_axis, String curr_vlaue){
        JButton button_curr = new JButton(curr_vlaue);
        button_curr.setBounds(x_axis, y_axis, 65, 50);
        button_curr.addActionListener(e -> {
            if (y_axis == 40)
                start_valuta = curr_vlaue;
            else
                end_valuta = curr_vlaue;
        });
        window.add(button_curr);
    }

    public double proverka_money(String start_currency, String end_currency, double money){
        logger.info("Проверка названий валют");

        switch (start_currency){
            case "USD":{valuta.setStart_valut(valuta.getUSD());
                break;}
            case "EUR":{valuta.setStart_valut(valuta.getEUR());
                break;}
            case "RUB":{valuta.setStart_valut(valuta.getRUB());
                break;}
            case "VND":{valuta.setStart_valut(valuta.getVND());
                break;}
            case "JPY":{valuta.setStart_valut(valuta.getJPY());
                break;}
            default:
                return 0;
        }
        switch (end_currency){
            case "USD":{valuta.setEnd_valut(valuta.getUSD());
                break;}
            case "EUR":{valuta.setEnd_valut(valuta.getEUR());
                break;}
            case "RUB":{valuta.setEnd_valut(valuta.getRUB());
                break;}
            case "VND":{valuta.setEnd_valut(valuta.getVND());
                break;}
            case "JPY":{valuta.setEnd_valut(valuta.getJPY());
                break;}
            default:
                return 0;
        }
        return valuta.change_currency(money);
    }

    public  GUI() {
        window = new JFrame("Karkulator");
        text_first = new JTextField();
        text_end = new JTextField();
        text_end.setEditable(false);
        voodoo = new JButton("Enter");
        window.add(text_first);
        window.add(text_end);
        window.add(voodoo);
        logger.info("Создны тексовые поля");

        text_first.setBounds(40, 40, 200, 50);
        text_end.setBounds(40, 215, 200, 50);
        voodoo.setBounds(40, 100, 200, 100);
        button(250, 40, "RUB");
        button(320, 40, "USD");
        button(390, 40, "EUR");
        button(460, 40, "VND");
        button(530, 40, "JPY");

        button(250, 215, "RUB");
        button(320, 215, "USD");
        button(390, 215, "EUR");
        button(460, 215, "VND");
        button(530, 215, "JPY");
        logger.info("Созадны кнопки валют");

        voodoo.addActionListener(e -> {
            logger.info("Создана копка перевда");
            if (text_first.getText().isEmpty()){
                JOptionPane.showMessageDialog(window,"Не введено начальное количесвто валюты","Enter error",JOptionPane.ERROR_MESSAGE);
                logger.error("Не введено начальное количесвто валюты");
            }
            else if (start_valuta == null){
                JOptionPane.showMessageDialog(window, "Не выбрана начальная валюта", "Select error", JOptionPane.ERROR_MESSAGE);
                logger.error("Не выбрана начальная валюта");
            }
            else if (end_valuta == null){
                JOptionPane.showMessageDialog(window, "Не выбрана конечная валюта", "Select error", JOptionPane.ERROR_MESSAGE);
                logger.error("Не выбрана конечная валюта");
            }
            else
            try {
                Double.parseDouble(text_first.getText());
                logger.info("Данные прошли валидацию");
                text_end.setText("" + proverka_money(start_valuta, end_valuta, Double.parseDouble(text_first.getText())));
                logger.info("Запрос на перевод выполнен");


            }
            catch(NumberFormatException numberFormatException)
            {
                JOptionPane.showMessageDialog(window, "В введеных данных присутсвуют недопустимые симвлоы", "Double error", JOptionPane.ERROR_MESSAGE);
                logger.error("В введеных данных присутсвуют недопустимые симвлоы");
            }
        });
        JLabel label53 = new JLabel();
        label53.setBounds(10, 140, 200, 40);
        window.getContentPane().add(label53);

        window.setLayout(null);
        window.setPreferredSize(new Dimension(650, 350));
        window.pack();
        window.setExtendedState(JFrame.NORMAL);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}







