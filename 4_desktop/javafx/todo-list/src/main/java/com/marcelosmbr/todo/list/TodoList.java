package com.marcelosmbr.todo.list;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Priority;

// Em JavaFX, a classe principal estende Application
// O framework chama automaticamente o método start() quando a aplicação inicia
public class TodoList extends Application {

    // VBox que vai conter as linhas de tarefas, empilhadas verticalmente
    private final VBox itemsBox = new VBox(8);
    private TextField inputField;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Simple To-Do List (JavaFX)");

        // Topo: campo de texto + botão "Add" --
        inputField = new TextField();
        inputField.setPromptText("Digite uma tarefa..."); // texto "fantasma" exibido quando vazio
        Button addButton = new Button("Add");

        // HBox.setHgrow faz o campo de texto crescer e ocupar o espaço sobrando
        HBox.setHgrow(inputField, Priority.ALWAYS);

        HBox topBox = new HBox(10, inputField, addButton);
        topBox.setPadding(new Insets(10));

        // Centro: lista de itens, dentro de um ScrollPane pra permitir rolagem 
        itemsBox.setPadding(new Insets(10));
        ScrollPane scrollPane = new ScrollPane(itemsBox);
        scrollPane.setFitToWidth(true); // faz o conteúdo esticar na largura disponível

        // BorderPane: layout com 5 regiões, equivalente ao BorderLayout do Swing
        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(scrollPane);

        // Eventos: clicar no botão ou apertar Enter no campo adicionam o item
        addButton.setOnAction(e -> addItem());
        inputField.setOnAction(e -> addItem());

        // Scene é o "conteúdo" da janela; Stage é a janela em si
        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.show();
    }

    // Cria uma nova linha de tarefa e adiciona à lista
    private void addItem() {
        String text = inputField.getText().trim();

        if (text.isEmpty()) {
            return;
        }

        Label label = new Label(text);
        Button deleteButton = new Button("Delete");

        // HBox.setHgrow faz o label crescer, empurrando o botão pra direita
        HBox.setHgrow(label, Priority.ALWAYS);

        HBox rowBox = new HBox(10, label, deleteButton);
        rowBox.setPadding(new Insets(5));

        // Evento do botão Delete - igual ao Swing, a lambda "lembra" da rowBox específica
        deleteButton.setOnAction(e -> itemsBox.getChildren().remove(rowBox));

        itemsBox.getChildren().add(rowBox);
        inputField.setText(""); // limpa o campo
    }

    public static void main(String[] args) {
        // launch() inicia o ciclo de vida do JavaFX e eventualmente chama start()
        launch(args);
    }
}