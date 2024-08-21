package helloworld;

import javax.swing.*;

public class Main extends JFrame {
    public Main(){

    JLabel lblHola = new JLabel("Hola");
    add(lblHola);
    this.setSize(200, 200);
    this.setTitle("JFrame");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);


    }
    public static void main(String[] args){
    new Main();
    }
}
