package os;

public class Pcb {
    //���̺�
    private int id;
    //״̬��'W','F','R'
    private char state;
    //����ʱ��
    private int arrivalTime;
    //��Ҫ���е�ʱ��
    private int serveTime;
    //�����е�ʱ��
    private int servedTime;
    //���н�����ʱ��
    private int overTime;
    //������ڴ���ʼ��ַ
    private int memstartlocation;
    //��Ҫ���ڴ��С
    private int memsize;
    //��Ҫ�ĴŴ���
    private int tapeDrive;

    public Pcb(int id, int arrivalTime, int serveTime, int servedTime, int overTime, int memstartlocation, int memsize, int tapeDrive) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serveTime = serveTime;
        this.servedTime = servedTime;
        this.overTime = overTime;
        this.memstartlocation = memstartlocation;
        this.memsize = memsize;
        this.tapeDrive = tapeDrive;
    }
    //������ɽ���
    public Pcb(int id) {
        this.id = id;
        this.arrivalTime=0;
        this.serveTime=(int)(Math.random()*100)%20+1;
        this.memsize = 0;
        this.memstartlocation = 0;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getServeTime() {
        return serveTime;
    }

    public void setServeTime(int serveTimeTime) {
        this.serveTime = serveTime;
    }

    public int getservedTime() {
        return servedTime;
    }

    public void setservedTime(int servedTime) {
        this.servedTime = servedTime;
    }
    public int getOverTimeTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }
    public int gettapeDrive() {
        return tapeDrive;
    }

    public void setTapeDrive(int tapeDrive) {
        this.tapeDrive = tapeDrive;
    }
    public int getMemsize() {
        return memsize;
    }

    public void setMemsize(int memsize) {
        this.memsize = memsize;
    }

    public int getMemstartlocation() {
        return memstartlocation;
    }

    public void setMemstartlocation(int memstartlocation) {
        this.memstartlocation = memstartlocation;

    }
    public char getState(){
        return state;
    }
    public void setState(char state){
        this.state=state;
    }

    @Override
    public String toString() {
//        return "JCB{" +
//                "id=" + id +
//                ", arrivalTime=" + arrivalTime +
//                ", serveTime=" + serveTime +
//                ", memsize=" + memsize +
//                ", tapeDrive=" + tapeDrive+
//                ", flag=" + flag +
//                '}';
        return "PCB{"+
                "id="+id+
                ",arriveTime="+toTime(arrivalTime)+
                ",servedTime="+servedTime+
                ",state="+state+
                (overTime==0?" ":",overTime=")+toTime(overTime)+
                "}";
    }
    public String toTime(int x){
        if(x<60)return "10:"+x;
        else return "11:"+(x-60);
    }
}
