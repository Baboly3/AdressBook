package com.babaktamjidi.adressbook;

import com.babaktamjidi.adressbook.Person;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author Babak Tamjidi (baboly@msn.com)
 */
public class MainController implements Initializable {

    @FXML
    private Pane infoField;
    @FXML
    private Button btnDel, btnNew, btnEdit, btnSave;
    @FXML
    private TableColumn<Person, Integer> id;
    @FXML
    private TableColumn<Person, String> contact;
    @FXML
    private TableView<Person> tableID;
    @FXML
    private ImageView photo;
    @FXML
    private Label person, saved, wrongInput;
    @FXML
    private TextField txtFName, txtFSurname, txtFPhone, txtFAdress, txtFZip;
    @FXML
    private FadeTransition fadetransition;
    @FXML
    private Circle phoneDot, zipDot, nameDot, surnameDot, adressDot;

    private boolean edit = false;
    private boolean newc = false;
    private boolean IdChoosen = false;
    private boolean passed = true;
    private int count = 1;
    ObservableList<Person> data = FXCollections.observableArrayList(
            new Person(count++, "Babak", "Tamjidi", "Växthusgatan 3", 768606952L, 43160),
            new Person(count++, "Gunnar", "Fredrikkson", "Achebergsgatan 23", 0702345125L, 41140),
            new Person(count++, "Kug", "Svensson", "Musikvägen 2", 0707563446L, 42123),
            new Person(count++, "Martin", "Andersson", "Achebergsgatan 23", 0702345125L, 41140),
            new Person(count++, "Kuy", "Guyonha", "Musikvägen 2", 0707563446L, 42123),
            new Person(count++, "Per", "Stenström,", "Achebergsgatan 23", 0702345125L, 41140),
            new Person(count++, "Kun", "Svensson", "Musikvägen 2", 0707563446L, 42123),
            new Person(count++, "Fredrick", "Johansson", "Achebergsgatan 23", 0702345125L, 41140),
            new Person(count++, "Ken", "Svensson", "Musikvägen 2", 0707563446L, 42123),
            new Person(count++, "Anders", "Karlsson", "Achebergsgatan 23", 0702345125L, 41140),
            new Person(count++, "Kebbab", "Vitlöksås", "Musikvägen 2", 0707563446L, 42123),
            new Person(count++, "Stefan", "Nilsson", "Achebergsgatan 23", 0702345125L, 41140),
            new Person(count++, "Kurt", "Svensson", "Musikvägen 2", 0707563446L, 42123),
            new Person(count++, "Lisa", "Karlsson", "Achebergsgatan 23", 0702345125L, 41140),
            new Person(count++, "Veronica", "Strängby", "Musikvägen 2", 0707563446L, 42123)
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        contact.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableID.setItems(data);
        saved.setVisible(false);

        delContact();
        newContact();

        getInfo();

        saveContact();

        editContact();

    }

    private void showTextField() {
        txtFAdress.setVisible(true);
        txtFName.setVisible(true);
        txtFPhone.setVisible(true);
        txtFSurname.setVisible(true);
        txtFZip.setVisible(true);
    }

    private void hideTextField() {
        txtFAdress.setVisible(false);
        txtFName.setVisible(false);
        txtFPhone.setVisible(false);
        txtFSurname.setVisible(false);
        txtFZip.setVisible(false);
    }

    private void editContact() {
        btnEdit.setOnAction((ActionEvent event) -> {

            if (newc != true && IdChoosen != false) {

                displayTextBorder();

                btnEdit.setStyle("-fx-background-color:\n"
                        + "        linear-gradient(#686868 0%, #1DB063 50%, #373837 75%, #1DB063 100%),\n"
                        + "        linear-gradient(#1DB063, #3a3a3a),\n"
                        + "        linear-gradient(#1DB063 0%, #6b6a6b 50%, #343534 80%, #242424 100%),\n"
                        + "        linear-gradient(#1DB063 0%, #6b6a6b 50%, #343534 80%, #262626 100%),\n"
                        + "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);");
                btnDel.setOpacity(0.5);
                btnNew.setOpacity(0.5);
                btnSave.setBlendMode(BlendMode.ADD);
                btnEdit.setBlendMode(BlendMode.ADD);
                edit = true;

            }
        });
    }

    private void removeTextBorder() {
        txtFName.setStyle("-fx-border-color:none;");
        txtFSurname.setStyle("-fx-border-color:none;");
        txtFPhone.setStyle("-fx-border-color:none;");
        txtFAdress.setStyle("-fx-border-color:none;");
        txtFZip.setStyle("-fx-border-color:none;");

        txtFAdress.editableProperty().set(false);
        txtFName.editableProperty().set(false);
        txtFPhone.editableProperty().set(false);
        txtFSurname.editableProperty().set(false);
        txtFZip.editableProperty().set(false);
    }

    private void displayTextBorder() {

        txtFName.setStyle("-fx-border-color:#7f98e2");
        txtFSurname.setStyle("-fx-border-color:#7f98e2");
        txtFPhone.setStyle("-fx-border-color:#7f98e2");
        txtFAdress.setStyle("-fx-border-color:#7f98e2");
        txtFZip.setStyle("-fx-border-color:#7f98e2");

        txtFAdress.editableProperty().set(true);
        txtFName.editableProperty().set(true);
        txtFPhone.editableProperty().set(true);
        txtFSurname.editableProperty().set(true);
        txtFZip.editableProperty().set(true);
    }

    private void updateTable() {
        for (int i = 0; i < tableID.getColumns().size(); i++) {
            ((TableColumn) (tableID.getColumns().get(i))).setVisible(false);
            ((TableColumn) (tableID.getColumns().get(i))).setVisible(true);
        }
    }

    private void saveContact() {
        btnSave.setOnAction((ActionEvent event) -> {

            hideDots();
            passed = true;
            long phone = 0;
            int zip = 0;
            if (newc == true) {

                checkTextNotEmpty();

                try {

                    phone = Long.parseLong(txtFPhone.getText());

                } catch (NumberFormatException e) {
                    inputWrong();
                    phoneDot.setVisible(true);
                    passed = false;
                }
                try {

                    zip = Integer.parseInt(txtFZip.getText());

                } catch (NumberFormatException e) {
                    inputWrong();
                    zipDot.setVisible(true);
                    passed = false;
                }

                if (passed == true) {

                    btnNew.setStyle("-fx-button-border-color: ;");

                    data.add(new Person(count++, txtFName.getText(), 
                                              txtFSurname.getText(), 
                                               txtFAdress.getText(), 
                                                       phone, zip));

                    btnDel.setOpacity(1);
                    btnEdit.setOpacity(1);
                    btnNew.setBlendMode(BlendMode.SRC_OVER);
                    btnSave.setBlendMode(BlendMode.SRC_OVER);

                    phoneDot.setVisible(false);
                    zipDot.setVisible(false);
                    clearTxtField();
                    removeTextBorder();
                    hideTextField();
                    saved.setVisible(true);
                    saved();

                    wrongInput.setVisible(false);
                    updateTable();
                    person.setText(null);
                    newc = false;
                    edit = false;
                    passed = false;

                }
            }

            if (edit == true && IdChoosen == true) {

                int i = tableID.getSelectionModel().getSelectedIndex();

                checkTextNotEmpty();

                try {

                    phone = Long.parseLong(txtFPhone.getText());

                } catch (NumberFormatException e) {
                    inputWrong();
                    phoneDot.setVisible(true);
                    passed = false;
                }
                try {

                    zip = Integer.parseInt(txtFZip.getText());

                } catch (NumberFormatException e) {
                    inputWrong();
                    zipDot.setVisible(true);
                    passed = false;
                }

                if (passed == true) {
                    btnEdit.setStyle("-fx-button-border-color: ;");
                    phoneDot.setVisible(false);
                    zipDot.setVisible(false);
                    data.get(i).setName(txtFName.getText());
                    data.get(i).setSurname(txtFSurname.getText());
                    data.get(i).setAdress(txtFAdress.getText());
                    data.get(i).setPhone(phone);
                    data.get(i).setZip(zip);
                    tableID.setItems(data);
                    IdChoosen = false;
                    btnDel.setOpacity(1);
                    btnNew.setOpacity(1);
                    btnSave.setBlendMode(BlendMode.SRC_OVER);
                    btnEdit.setBlendMode(BlendMode.SRC_OVER);
                    wrongInput.setVisible(false);
                    saved.setVisible(false);
                    removeTextBorder();
                    clearTxtField();
                    hideTextField();
                    saved();
                    updateTable();
                    person.setText(null);
                    edit = false;
                    newc = false;
                    passed = false;
                }
            }
        });
    }

    private void hideDots() {
        adressDot.setVisible(false);
        phoneDot.setVisible(false);
        zipDot.setVisible(false);
        adressDot.setVisible(false);
        surnameDot.setVisible(false);
        nameDot.setVisible(false);
    }

    private void checkTextNotEmpty() {
        if (txtFAdress.textProperty().isEmpty().get()) {
            inputWrong();
            passed = false;
            adressDot.setVisible(true);
        }
        if (txtFName.textProperty().isEmpty().get()) {
            inputWrong();
            passed = false;
            nameDot.setVisible(true);
        }
        if (txtFSurname.textProperty().isEmpty().get()) {
            inputWrong();
            passed = false;
            surnameDot.setVisible(true);
        }
    }

    private void saved() {

        saved.setVisible(true);
        FadeTransition fade = new FadeTransition(Duration.seconds(2), saved);
        fade.setFromValue(1.0);
        fade.setToValue(-1.0);
        fade.setRate(1.0);
        fade.play();
        saved.setText("Contact Saved");
    }

    private void getInfo() {

        tableID.setOnMousePressed((MouseEvent event) -> {
            IdChoosen = true;
            showTextField();
            if (newc != true) {
                int i = tableID.getSelectionModel().getFocusedIndex();
                txtFName.setText(data.get(i).getName());
                txtFAdress.setText(data.get(i).getAdress());
                txtFSurname.setText(data.get(i).getSurname());
                int zip = data.get(i).getZip();
                long phone = data.get(i).getPhone();
                txtFPhone.setText(String.valueOf(phone));
                txtFZip.setText(String.valueOf(zip));
                person.setText(data.get(i).getName() + " " + data.get(i).getSurname());
            }
        });
    }

    private void newContact() {

        btnNew.setOnAction((ActionEvent event) -> {

            if (edit != true && newc != true) {
                btnNew.setStyle("-fx-background-color:\n"
                        + "        linear-gradient(#686868 0%, #1DB063 50%, #373837 75%, #1DB063 100%),\n"
                        + "        linear-gradient(#1DB063, #3a3a3a),\n"
                        + "        linear-gradient(#1DB063 0%, #6b6a6b 50%, #343534 80%, #242424 100%),\n"
                        + "        linear-gradient(#1DB063 0%, #6b6a6b 50%, #343534 80%, #262626 100%),\n"
                        + "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);");

                txtFName.setPromptText("Type in name");
                txtFSurname.setPromptText("Type in surname");
                txtFPhone.setPromptText("0707XXXXXX");
                txtFZip.setPromptText("431XX");
                txtFAdress.setPromptText("Type in Adress");
                showTextField();
                displayTextBorder();

                btnDel.setOpacity(0.5);
                btnEdit.setOpacity(0.5);

                btnNew.setBlendMode(BlendMode.SCREEN);
                btnSave.setBlendMode(BlendMode.SCREEN);
                IdChoosen = false;
                newc = true;
                person.setText("Type in new Contact info");
                clearTxtField();
            }

        });
    }

    private void clearTxtField() {
        txtFName.clear();
        txtFAdress.clear();
        txtFPhone.clear();
        txtFSurname.clear();
        txtFZip.clear();
    }

    private void delContact() {

        btnDel.setOnMouseClicked((MouseEvent event) -> {
            if (edit != true && newc != true) {

                int i = tableID.getSelectionModel().getSelectedIndex();
                data.remove(i);
                count--;

                clearTxtField();
                hideTextField();
                person.setText(null);

                delContactMsg();
            }

        });
    }

    private void inputWrong() {
        wrongInput.setVisible(true);
        FadeTransition fade = new FadeTransition(Duration.seconds(2), wrongInput);
        fade.setFromValue(1.0);
        fade.setToValue(-1.0);
        fade.setRate(1.0);
        fade.play();
        wrongInput.setText("Input Wrong");

    }

    private void delContactMsg() {

        hideTextField();
        saved.setVisible(true);
        FadeTransition fade = new FadeTransition(Duration.seconds(2), saved);
        fade.setFromValue(1.0);
        fade.setToValue(-1.0);
        fade.setRate(1.0);
        fade.play();
        saved.setText("Contact removed");

    }

}
