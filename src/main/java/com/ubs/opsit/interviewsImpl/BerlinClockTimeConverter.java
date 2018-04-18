package com.ubs.opsit.interviewsImpl;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.interviews.TimeConverter;

public class BerlinClockTimeConverter implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		// TODO Auto-generated method stub
		List<Integer> parts = new ArrayList<Integer>();
        for (String part : aTime.split(":")) {
            parts.add(Integer.parseInt(part));
        }
       /* return new String[] {
                getSeconds(parts.get(2)),
                getTopHours(parts.get(0)),
                getBottomHours(parts.get(0)),
                getTopMinutes(parts.get(1)),
                getBottomMinutes(parts.get(1))
        };*/
        
        return String.format(  getSeconds(parts.get(2)) + "%n"
        					+  getTopHours(parts.get(0)) + "%n"
        					+  getBottomHours(parts.get(0)) + "%n"
        					+  getTopMinutes(parts.get(1)) + "%n"
        					+ getBottomMinutes(parts.get(1)));

	}
	
	
	
	
	
	protected String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
    }

    protected String getTopHours(int number) {
        return getOnOff(4, getTopNumberOfOnSigns(number));
    }

    protected String getBottomHours(int number) {
        return getOnOff(4, number % 5);
    }

    protected String getTopMinutes(int number) {
        return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
    }

    protected String getBottomMinutes(int number) {
        return getOnOff(4, number % 5, "Y");
    }

    // Default value for onSign would be useful
    private String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, "R");
    }
    private String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";
        // String multiplication would be useful
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += "O";
        }
        return out;
    }

    private int getTopNumberOfOnSigns(int number) {
        return (number - (number % 5)) / 5;
}
	
	
	public static void main(String args[]){
		BerlinClockTimeConverter b=new BerlinClockTimeConverter();
		String res=b.convertTime("23:59:59");
		System.out.println(res);
	}
	

}
