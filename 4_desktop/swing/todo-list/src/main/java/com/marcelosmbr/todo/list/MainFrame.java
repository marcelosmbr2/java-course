/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.marcelosmbr.todo.list;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author marce
 */
// App simples de lista de tarefas com dados salvos em memória
public class MainFrame extends JFrame {

    // Painel que vai conter as linhas de tarefas, uma embaixo da outra
    private final JPanel itemsPanel;
    private final JTextField inputField;

    public MainFrame() {
        setTitle("Simple To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        // Layout principal da janela: divide em topo (input) e centro (lista)
        setLayout(new BorderLayout(10, 10));

        // Painel de topo: campo de texto + botão "Add"
        inputField = new JTextField();
        JButton addButton = new JButton("Add");

        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        topPanel.add(inputField, BorderLayout.CENTER); // campo ocupa o espaço que sobrar
        topPanel.add(addButton, BorderLayout.EAST);     // botão fica fixo na direita

        // Painel central: lista de itens, empilhados verticalmente 
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // JScrollPane permite rolar a lista se ela crescer mais que a altura da janela
        JScrollPane scrollPane = new JScrollPane(itemsPanel);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Evento do botão "Add": adiciona um novo item à lista
        addButton.addActionListener(e -> addItem());

        // Permite também apertar Enter no campo de texto para adicionar, sem precisar clicar no botão
        inputField.addActionListener(e -> addItem());
    }

    // Cria uma nova "linha" de tarefa e adiciona ao painel de itens
    private void addItem() {
        String text = inputField.getText().trim();

        // Validação simples: não adiciona se estiver vazio
        if (text.isEmpty()) {
            return;
        }

        JLabel label = new JLabel(text);
        JButton deleteButton = new JButton("Delete");

        // Cada linha é um painel próprio, com o texto à esquerda e o botão à direita
        JPanel rowPanel = new JPanel(new BorderLayout(10, 0));
        rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35)); // limita a altura da linha
        rowPanel.add(label, BorderLayout.CENTER);
        rowPanel.add(deleteButton, BorderLayout.EAST);

        // Evento do botão "Delete" dessa linha específica
        // Cada botão "lembra" da sua própria rowPanel, por causa da lambda (closure)
        deleteButton.addActionListener(e -> {
            itemsPanel.remove(rowPanel);
            itemsPanel.revalidate(); // recalcula o layout depois de remover
            itemsPanel.repaint();    // redesenha a tela
        });

        itemsPanel.add(rowPanel);
        itemsPanel.revalidate(); // necessário sempre que adicionamos componente dinamicamente
        itemsPanel.repaint();

        inputField.setText(""); // limpa o campo depois de adicionar
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame app = new MainFrame();
            app.setVisible(true);
        });
    }
}