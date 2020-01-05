package ru.gera.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import ru.gera.model.Dote;

public class MainController {
    ObservableList<Dote> list = FXCollections.observableArrayList(new Dote());
    @FXML
    private Button addSize;
    @FXML
    private Button addDote;
    @FXML
    private VBox sizeVBox;
    @FXML
    private TableView<Dote> doteTable;
    @FXML
    private TableColumn<Dote, String> indexColumn;
    @FXML
    private TableColumn<Dote, String> xColumn;
    @FXML
    private TableColumn<Dote, String> yColumn;
    @FXML
    private TableColumn<Dote, String> zColumn;
    @FXML
    private TableColumn<Dote, String> removeRecord;
    @FXML
    public void initialize() {

        indexColumn.setCellValueFactory(new PropertyValueFactory<>("index"));
        xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
        zColumn.setCellValueFactory(new PropertyValueFactory<>("z"));

        indexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        xColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        yColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        zColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        doteTable.setItems(list);

        addSize.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            sizeVBox.getChildren().add(0, new SizePane(sizeVBox, "1"));
        });

        addDote.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> list.add(new Dote()));
    }
}
