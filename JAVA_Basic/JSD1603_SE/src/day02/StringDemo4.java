package day02;
/**
 * 和谐用语
 * @author Administrator
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
		String regex = "(wqnmlgdsb|cnm|213|tmd|r|nc|djb)";
		String message = "r!你个djb!你怎么这么的nc!cnm!tmd!wqnmlgdsb!";
		message = message.replaceAll(regex, "***");
		System.out.println(message);
	}
}




