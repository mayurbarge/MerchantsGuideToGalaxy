package com.galaxyguide.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class MerchantsConversionGuide {

	public static void main(String[] args) throws Exception {
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(new FileInputStream(args[0]));
			out = new PrintWriter(
					new FileOutputStream("result.txt"));

			while (in.hasNextLine()) {
				String line = in.nextLine();
				
				String outputLine = LineParser.processLine(line);
				if (outputLine != null) {
					out.print(outputLine);
				}
			}
		} catch (Exception e) {
			throw new Exception("Error while processing files: ");
		} finally {
			in.close();
			out.close();
		}
	}
}
