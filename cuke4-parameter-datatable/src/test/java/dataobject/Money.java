package dataobject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Money {

	public String currency = "";
	
	public int main = 0;
	
	public int sec = 0;

	public Money(String currency, int main, int sec) {
		this.currency = currency;
		this.main = main;
		this.sec = sec;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getMain() {
		return main;
	}

	public void setMain(int main) {
		this.main = main;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}
	
	public static Money parseMoneyDetails(String value) {
		Matcher matcher = Pattern.compile("^([\\D]*)([\\d]+)\\.([\\d][\\d])$").matcher(value);
		matcher.find();		
		return new Money(matcher.group(1), Integer.parseInt(matcher.group(2)),
				Integer.parseInt(matcher.group(3)));
	}

	@Override
	public int hashCode() {
		return Objects.hash(currency, main, sec);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this, obj);
	}

	@Override
	public String toString() {
		return "Money [currency=" + currency + ", main=" + main + ", sec=" + sec + "]";
	}
	
	
}
