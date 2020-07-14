package chapter6.company;

import java.util.Scanner;

public class Company {

	public static void main(String[] args) {
		// 異쒕젰�븷 �븣 �궗�슜�븷 �엫�떆蹂��닔
		String result = " ";
		//Employee�� Manager 媛앹껜�쓽 李몄“瑜� ���옣�븷 蹂��닔
		Employee emp = null;
		Manager man = null;
		
		//3媛�吏� �젙蹂대�� �엯�젰諛쏆븘 ���옣�븷 �엫�떆 蹂��닔
		String name = "";
		String part = "";
		String position = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�씠由꾩쓣 �엯�젰�븯�꽭�슂 : ");
		name = sc.next();
		System.out.print("遺��꽌瑜� �엯�젰�븯�꽭�슂 : ");
		part = sc.next();
		System.out.print("吏곸콉�쓣 �엯�젰�븯�꽭�슂(1.�궗�썝 2.愿�由ъ옄) : ");
		position = sc.next();
		
		//position 1�씠硫� Employee 媛앹껜瑜� 留뚮뱾�뼱�꽌 異쒕젰
		//position 2�씠硫� Manager 媛앹껜瑜� 留뚮뱾�뼱�꽌 異쒕젰
		if(position.equals("1")) {
			emp = new Employee(name, part);
			result = emp.resultStr();
		}else {
			man = new Manager(name, part, "愿�由ъ옄");
			result = man.resultStr() + man.addStr();
		}
		System.out.println(result);
		sc.close();

	}

}
