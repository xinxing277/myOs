package os;

public class Node {
    //�̵������Ǻ��������ձ�����˳����ϵģ�������Ҫ�޸ĵĴ���
    //public int id;  //-1��������  0�������, ���������̺߳�(�ѷ���)
    public int start;   //��ʼ��ַ
    public int size;    //������С

    public Node() {
    }
    //ֻ��д�����̵߳�id�ţ���size
    public Node(int start,int size) {
        this.start=start;
        this.size = size;
    }
    @Override
    public String toString() {
        return String.format("[%6d%6d]",start,size);
    }
}