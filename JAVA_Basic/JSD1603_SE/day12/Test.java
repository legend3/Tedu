package day12;

public class Test {
	public boolean getMoney(int money){
		//查看余额
		int count = getAccount();
		if(count >= money){
			count = count - money;
			saveAccount(count);
			return true;
		}
		return false;
		
	}
	public void saveAccount(int account){
		
	}
	
	public int getAccount(){
		return 0;
	}
}
