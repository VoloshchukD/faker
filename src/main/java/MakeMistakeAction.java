import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.sun.xml.internal.ws.server.provider.SyncProviderInvokerTube;

import java.util.Locale;
import java.util.Random;

public class MakeMistakeAction {
    private String region;
    private Random random = new Random();
    private FakeValuesService fakeValuesService;

    public MakeMistakeAction(String region) {
        this.region = region;
        RandomService r = new RandomService();
        if (region.equals("en-US") ) {
            fakeValuesService = new FakeValuesService(new Locale(region), r);
        } else
            fakeValuesService = new MyFakeValuesService(new Locale(region), r);
    }

    public int countProbability(){
        return ( random.nextInt(3)+1 );
    }

    public String removeChar(String record){
        if (record.length() == 0) throw new RuntimeException();
        int t = random.nextInt(record.length())+1;
        return new StringBuffer(record).delete(t-1, t).toString();
    }

    public String permuteChar(String record){
        int t = random.nextInt(record.length());
        int t2 = t+1;
        if(record.length() - t == 1) t2 = 0;
        StringBuilder s = new StringBuilder(record);
        s.setCharAt(t, record.charAt(t2));
        s.setCharAt(t2, record.charAt(t));
        return s.toString();
    }

    public String addChar(String record){
        int t = random.nextInt(record.length());
        String c = fakeValuesService.letterify("?");
        StringBuilder s = new StringBuilder(record);
        return s.insert(t, c).toString();
    }

    public String run(String userData){
        userData = countProbability() == 1
                ? removeChar(userData) : countProbability() == 2
                ? permuteChar(userData) : addChar(userData);
        return userData;
    }

    public String run(String userData, int errorNumber){
        int l = userData.length();
        for (int i = 0; i < errorNumber; i++) {
            if( userData.length() > (int) (l*1.2) ) {
                userData = removeChar(userData);
                continue;
            }
            if( userData.length() < (int) (l*0.2 ) ) {
                userData = addChar(userData);
                continue;
            }
            userData = run(userData);
        }
        return userData;
    }

}
