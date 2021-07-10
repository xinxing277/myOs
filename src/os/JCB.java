package os;

public class JCB {
    //��ҵ��
    private int id;
    //����ʱ��
    private double arrivalTime;
    //��Ҫ���е�ʱ��
    private double serveTime;
    //��Ҫ���ڴ��С
    private int memsize;
    //�Ƿ��Ѿ�����
    private int tapeDrive;
    //��Ҫ�ĴŴ���
    private double responRatio;

    public JCB(int id, double arrivalTime, double serveTime, int memsize,int tapeDrive) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serveTime = serveTime;
        this.memsize=memsize;
        this.tapeDrive=tapeDrive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getserveTime() {
        return serveTime;
    }

    public void setServeTimeTime(double serveTime) {
        this.serveTime = serveTime;
    }

    public int getMemsize() {
        return memsize;
    }

    public void setMemsize(int memsize) {
        this.memsize = memsize;
    }

    public int  getTapeDrive(){return this.tapeDrive;}

    public void  setTapeDrive(int tapeDrive){this.tapeDrive=tapeDrive;}
    @Override
    public String toString() {
        return "JCB{" +
                "id=" + id +
                ", arrivalTime=" + arrivalTime +
                ", serveTime=" + serveTime +
                ", memsize=" + memsize +
                ", tapeDrive=" + tapeDrive+
                ", responRatio=" + responRatio +
                '}';
    }

    public double getresponRatio() {
        return responRatio;
    }

    public void setResponRatio(double flag) {
        this.responRatio = responRatio;
    }
}
