package os;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.awt.event.MouseEvent;

import static os.Commons.*;
import static os.mainStart.*;

public class userController {
    @FXML
    private Text freeTapeDriveNum;

    @FXML
    private ListView<Node> listGridPane;

    @FXML
    private ToggleGroup JcbToggleGroup;

    @FXML
    private TitledPane PcbTitlePane;

    @FXML
    private RadioButton FCFS_Pcbscheduling;

    @FXML
    private ToggleGroup PcbToggleGroup;

    @FXML
    private RadioButton SJF_Jobscheduling;

    @FXML
    private RadioButton HRN_Jobscheduling;

    @FXML
    private RadioButton RR_Pcbscheduling;

    @FXML
    private TextField timeTextField;

    @FXML
    private Text avegPcbTime;

    @FXML
    private Button continueButton;

    @FXML
    private Button beginButton;

    @FXML
    private Button overButton;

    @FXML
    private RadioButton FCFS_Jobscheduling;

    @FXML
    private RadioButton SJF_Pcbscheduling;

    @FXML
    private TextField Pcb_Now;

    @FXML
    private ListView<Pcb> donePcbGridPane;

    @FXML
    private TitledPane JcbTitlePane;

    public userController() {
    }

    @FXML
    void beginAction(ActionEvent event) {

        init_jcbs();
        init_mem();
        init();
        //System.out.println(PcbToggleGroup.getSelectedToggle().getUserData().toString());
        flush();
        schedual();
        PcbTitlePane.setDisable(true);
        JcbTitlePane.setDisable(true);
        show();
        beginButton.setDisable(true);
    }

    @FXML
    void continueAction(ActionEvent event) {
        if(checkIsNULL()==false){
            //�����ҵ���л��߽��̶��в��������������ֹͣ
            if(h%timeSlide==0)flush();
            // FCFS_Pcbscheduling();
            //SJF_Pcbscheduling();
           // RR_P.RR_Pcbscheduling();
            schedual();
            show();
        }
        else {
            continueButton.setDisable(true);
            overAction( new ActionEvent());
        }
    }

    @FXML
    void overAction(ActionEvent event) {
        //չʾ�������
        show();
        Pcb_Now.setText("������ִ�����");
        continueButton.setDisable(true);
        overButton.setDisable(true);
        System.out.println("ϵͳƽ����Ȩ��תʱ�䣺"+avegPcbTime.getText());
    }

    public void show(){

        timeTextField.setText(String.valueOf(h));
        freeTapeDriveNum.setText(String.valueOf(tapeDrive-tape_Used));
        Pcb_Now.setText("�������еĽ��̺ţ�"+String.valueOf(runningPcb.getId())+", ���� "+String.valueOf(runningPcb.getServeTime()-runningPcb.getservedTime())+" ����");
        listGridPane.setItems(null);
        //listGridPane.getChildrenUnmodifiable().clear();
        ObservableList<Node> items= FXCollections.observableArrayList();
        for(Node n:list){
            items.add(n);
        }
        listGridPane.setItems(items);

        donePcbGridPane.setItems(null);
        if(done_pcbs.size()!=0){
            ObservableList<Pcb> item= FXCollections.observableArrayList();
            for(Pcb p:done_pcbs){
                item.add(p);
            }
            donePcbGridPane.setItems(item);
        }
        //չʾƽ����תʱ��
        if(done_pcbs.size()==jcbs_num)
            avegPcbTime.setText(String.format("%.2f",estimate()));

    }
    public void init(){

        donePcbGridPane.setItems(null);
        listGridPane.setItems(null);
        timeTextField.setText("0");
        freeTapeDriveNum.setText(String.valueOf(tapeDrive));
        avegPcbTime.setText("0");
        FCFS_Pcbscheduling.setUserData(1);
        FCFS_Jobscheduling.setUserData(1);
        SJF_Pcbscheduling.setUserData(2);
        SJF_Jobscheduling.setUserData(2);
        RR_Pcbscheduling.setUserData(3);
        HRN_Jobscheduling.setUserData(3);
        PcbKind=Integer.parseInt(PcbToggleGroup.getSelectedToggle().getUserData().toString());
        JcbKind=Integer.parseInt(JcbToggleGroup.getSelectedToggle().getUserData().toString());
    }

}

