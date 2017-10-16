package com.example.ptbac2;

import java.util.Scanner;

public class BaiGiai {

	public static void main(String[] Strings) {

		Scanner input = new Scanner(System.in);

		System.out.print("Nhập a: ");
		double a = input.nextDouble();
		System.out.print("Nhập b: ");
		double b = input.nextDouble();
		System.out.print("Nhập c: ");
		double c = input.nextDouble();

		double result = b * b - 4.0 * a * c;
		System.out.println(a + "x^2 " + ((b > 0)?"+ ":"- ") + Math.abs(b) + "x " + ((c > 0)?"+ ":"- ") +Math.abs(c) + " = 0");
		if (result > 0.0) {
			double r1 = (-b + Math.pow(result, 0.5)) / (2.0 * a);
			double r2 = (-b - Math.pow(result, 0.5)) / (2.0 * a);
			System.out.println("Phương trình 2 có nghiệm: " + r1 + " và " + r2);
		} else if (result == 0.0) {
			double r1 = -b / (2.0 * a);
			System.out.println("Phương trình có nghiệm: " + r1);
		} else {
			System.out.println("Phương trình vô nghiệm.");
		}
		input.close();
	}
}
