package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Table View
    @FXML
    private TableView<UserInput> tableView;

    //Columns
    @FXML private TableColumn<UserInput, String> descriptionColumn;
    @FXML private TableColumn<UserInput, String> sizeColumn;
    @FXML private TableColumn<UserInput, Double> pcsColumn;
    @FXML private TableColumn<UserInput, Double> presyoColumn;

    //Labels
    @FXML private Text pricetotal;
    @FXML private JFXTextField deskripsyon, sukat, piraso, prays;



    //Code Starts Here

    // Connection to Object and Classes
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<UserInput, String>("description"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<UserInput, String>("size"));
        pcsColumn.setCellValueFactory(new PropertyValueFactory<UserInput, Double>("pieces"));
        presyoColumn.setCellValueFactory(new PropertyValueFactory<UserInput, Double>("price"));
    }

    //Submit button MAGIC HAPPENS HERE!!!
    @FXML
    void submit(ActionEvent event) {

        UserInput userInput = new UserInput(
                deskripsyon.getText(),
                sukat.getText(),
                Double.parseDouble(piraso.getText()),
                Double.parseDouble(prays.getText())
        );

        ObservableList<UserInput> userInputs = tableView.getItems();
        userInputs.add(userInput);
        tableView.setItems(userInputs);


    }

    @FXML
    void delete(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }
}
