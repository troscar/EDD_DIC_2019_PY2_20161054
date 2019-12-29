/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyecto2_edd.*;

/**
 *
 * @author tracs
 */
public class VentanaInicio {
    
    JFrame ventana;
    JTextField campotexto1;
    JTextField campotexto2;
    JButton boton1;
    JButton boton2;
    JLabel titulo;
    
    
    public VentanaInicio(){
        ventana = new JFrame();
        ventana.setLayout(null);
        ventana.setTitle("Inicio de sesion - Biblioteca");
        ventana.setSize(500, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        titulo = new JLabel();
        titulo.setText("Inicia Sesion");
        titulo.setFont(new java.awt.Font("Tahoma", 0, 24));
        titulo.setBounds(180, 50, 200, 50);
        ventana.add(titulo);
        
        campotexto1 = new JTextField("User Name");
        campotexto1.setBounds(100, 150 , 300, 35);
        campotexto1.setHorizontalAlignment(campotexto1.CENTER);        
        ventana.add(campotexto1);
        
        campotexto2 = new JTextField("Password");
        campotexto2.setBounds(100, 200 , 300, 35);
        campotexto2.setHorizontalAlignment(campotexto1.CENTER);
        ventana.add(campotexto2);
        
        boton1 = new JButton("Entrar");
        boton1.setBounds(140,250,100, 40);
        boton1.addActionListener(new Entrada(campotexto1,campotexto2) );
        ventana.add(boton1);
        
        boton2 = new JButton("Registro");
        boton2.setBounds(260,250,100, 40);
        boton2.addActionListener(new Regis());
        ventana.add(boton2);
        
        
        ventana.setVisible(true);
    }       


    class Entrada implements ActionListener{
        private JTextField campotext1;
        private JTextField campotext2;
        private JFrame mensaje;
        private JLabel titulo;

        public Entrada (JTextField user,JTextField pass){
            campotext1 = user;
            campotext2 = pass;
        }

        public void actionPerformed(ActionEvent ae) {
            String Username = campotext1.getText();
            String Pass = campotext2.getText();
            ventana.dispose();
        }

    }

    class Regis implements ActionListener{

        public void actionPerformed(ActionEvent ae) {
            //Ventanaregistro Vreg = new Ventanaregistro();
            ventana.dispose();
        }

    }
    
}
