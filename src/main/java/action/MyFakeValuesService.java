package action;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class MyFakeValuesService extends FakeValuesService {
    private Locale locale;
    private RandomService randomService;
    private StringBuffer sb;

    public MyFakeValuesService(Locale locale, RandomService randomService) {
        super(locale, randomService);
        this.randomService = randomService;
        this.locale = locale;
        sb = new StringBuffer();
    }

    @Override
    public String letterify(String letterString) {
            return this.letterify(letterString, false);
    }

    @Override
    public String letterify(String letterString, boolean isUpper) {
        return this.letterHelper(isUpper ? 1040 : 1072, letterString);
    }

    private String letterHelper(int baseChar, String letterString) {
        sb.setLength(0);

        int t = 0;
        if (locale.toString().equals("ru-ru")) t = generateCharRU();
        if (locale.toString().equals("by-by")) {
            t = generateCharBY(baseChar == 1072);
        }

        for(int i = 0; i < letterString.length(); ++i) {
            if (letterString.charAt(i) == '?') {
                sb.append((char)(baseChar + t));
            } else {
                sb.append(letterString.charAt(i));
            }
        }

        return sb.toString();
    }

    private int generateCharRU() {
        int t = this.randomService.nextInt(33);
        if(t == 32) t = 33;
        return t;
    }

    private int generateCharBY(boolean isUpper){
        int t = this.randomService.nextInt(32);
        if(t==26) t=31;
        if(t == 8){
            t = -967;
            if(isUpper) t = 38;
        } else if(t == 25){
            t = -2;
            if(isUpper) t = 46;
        }
        return t;
    }

}
