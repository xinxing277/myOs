package os;
//���ݣ�������mainstart
//������main
import java.util.ArrayList;
import java.util.List;


public class mainStart {
    public static int h;                                    //ʱ��
    public static List<JCB> jcbs = new ArrayList();         //����ҵ����
    public static ArrayList<Node> list = new ArrayList();   //���нڵ�����
    public static List<Pcb> pcbs=new ArrayList();           //���̶���
    public static List<Pcb> done_pcbs=new ArrayList();      //����ɽ��̶���

//    public static ArrayBlockingQueue<Integer> neicunnum = new ArrayBlockingQueue(5);
    public static final int mem_size = 100;                 //����ռ�100KB
    public static final int tapeDrive=4;                    //�Ŵ�������4̨
    public static int tape_Used;                            //�ѷ���Ŵ�����Ŀ
    public static int pcbs_num = 5;//�ڴ�ֻ�ܷ�2����ҵ
    public static int jcbs_num = 5;//����5����ҵ
    public static int timeSlide=5;//ÿ�����ˢ��һ��pcb��jcb
    public static int tasknum;                              //�ѽ����ڴ����ҵ��
    public static int JcbKind;                              //ѡ�����ҵ�����㷨
    public static int PcbKind;                              //ѡ��Ľ��̵����㷨
    public static Pcb runningPcb;                           //��������״̬�Ľ���

    public static void init_jcbs() {
        //��ʼ������ҵ���У����Ұ���ҵ����ʱ������
        //����ʱ�ȶ��ã����Ժú���д���뺯��
        JCB jcb1 = new JCB(1, 0, 25, 15,2);//����ʱ����10��Ϊ��㣬����Ϊ��λ���ڴ���KΪ��λ
        //jcb1.setFlag(false);
        jcbs.add(jcb1);
        JCB jcb2 = new JCB(2, 20, 30, 60,1);//����ʱ����10��Ϊ��㣬����Ϊ��λ���ڴ���KΪ��λ
        //jcb2.setFlag(false);
        jcbs.add(jcb2);
        JCB jcb3 = new JCB(3, 30, 10, 50,3);//����ʱ����10��Ϊ��㣬����Ϊ��λ���ڴ���KΪ��λ
        //jcb3.setFlag(false);
        jcbs.add(jcb3);
        JCB jcb4 = new JCB(4, 35,20,10,2);//����ʱ����10��Ϊ��㣬����Ϊ��λ���ڴ���KΪ��λ
        //jcb4.setFlag(false);
        jcbs.add(jcb4);
        JCB jcb5 = new JCB(5, 40, 15, 30,2);//����ʱ����10��Ϊ��㣬����Ϊ��λ���ڴ���KΪ��λ
        //jcb5.setFlag(false);
        jcbs.add(jcb5);
    }

//    public static List<Pcb> creatPcbfromJcb() {
//        int temnum = false;
//        List<Pcb> pcbs = new ArrayList();
//        int temnum;
//        if (jcbs.size() <= 5) {
//            temnum = jcbs.size();
//        } else {
//            temnum = 5;
//        }
//
//        for(int i = 0; i < temnum; ++i) {
//            JCB jcb = (JCB)jcbs.get(i);
//            Pcb pcb = new Pcb(jcb.getId(), jcb.getArrivalTime(), jcb.getRequiredTime(), 0, jcb.getMemsize());
//            pcbs.add(pcb);
//            RR_pcbs.add(pcb);
//            jcbs.remove(i);
//        }
//
//        return pcbs;
//    }

    public static void init_mem() {
        Node first = new Node();
        first.start = 0;
        first.size = 100;
        list.add(first);
    }

//    public static void main(String[] args) {
//
//
////        FCFS_J.startAlloc();
////        FCFS_P.pro_FCFS();
//        init_jcbs();
//        init_mem();
//        while (checkIsNULL()==false){
//            if(h%timeSlide==0)flush();
//           // FCFS_Pcbscheduling();
//            //SJF_Pcbscheduling();
//            RR_P.RR_Pcbscheduling();
//        }
//    }
    public static boolean checkIsNULL(){
        return (jcbs.isEmpty()&&pcbs.isEmpty());
    }

    static {
        tasknum = 0;
        tape_Used=0;
        h=0;
    }


}
