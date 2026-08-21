package gov.epa.ccte.api.exposure;

public class TestHelper {

    private TestHelper() {
        throw new UnsupportedOperationException("static helper class");
    }

    public static String[] generateRandomStrings(int count) {
        String[] strings = new String[count];
        for (int i = 0; i < count; i++) {
            strings[i] = String.format("RNDSTRING%06d", count);
        }
        return strings;
    }
    
    
}
