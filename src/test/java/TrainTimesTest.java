/**
 * @author: 冀陆涛
 * @create: 2019-01-25 10:41
 **/
public enum TrainTimesTest {
    G1922("G1922","12:38","17:38","05:00"),
    G1958("G1958","12:49","17:44","04:55"),
    G1820("G1820","13:25","18:12","04:47"),
    G1824("G1824","13:28","18:50","05:22"),
    G1828("G1828","14:15","19:09","04:54"),
    G1868("G1868","14:29","19:13","04:44"),
    G1926("G1926","14:52","19:47","04:55"),
    G1972("G1972","16:22","21:26","05:04"),
    G1954("G1954","16:33","21:17","04:44"),
    G1938("G1938","17:14","21:46","04:32"),
    G1976("G1976","17:20","22:25","05:05");

    private String id;
    private String fromTime;
    private String toTime;
    private String fromToTime;

    private TrainTimesTest(String id,String fromTime,String toTime,String fromToTime){
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.fromToTime = fromToTime;
    }

    public String toString(){
        return "车次："+id+" 出发时间：" + fromTime + " 到达时间：" + toTime + " 历时：" + fromToTime ;
    }

    public static void main(String[] args) {
        //TrainTimesTest.valueOf("G1938").ordinal() + 2;
        //TrainTimesTest.valueOf("G1938");
        System.out.println(TrainTimesTest.valueOf("G1938").ordinal() + 2);
        System.out.println(TrainTimesTest.valueOf("G1938"));
    }
}
