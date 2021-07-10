package os;

public class Pcb {
    //进程号
    private int id;
    //状态：'W','F','R'
    private char state;
    //到达时间
    private int arrivalTime;
    //需要运行的时间
    private int serveTime;
    //已运行的时间
    private int servedTime;
    //运行结束的时间
    private int overTime;
    //分配的内存起始地址
    private int memstartlocation;
    //需要的内存大小
    private int memsize;
    //需要的磁带机
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
    //随机生成进程
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
