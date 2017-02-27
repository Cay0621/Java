package reflect.demo;

public class EveningParty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EveningParty().process();
	}
	
	public void process(){
		//定义晚会流程，演出歌唱，跳舞，表演
		System.out.println("晚会正式开始...");
		
		Singable singer = Factory.getSinger();
		singer.sing();
		
		Danceable dancer = Factory.getDancer();
		dancer.dance();
		
		Performable performer = Factory.getPerformer();
		performer.perform();
		
		System.out.println("晚会正式结束...");
	}

}
