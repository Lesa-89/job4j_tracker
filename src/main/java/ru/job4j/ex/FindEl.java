package ru.job4j.ex;

import java.util.Arrays;
import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(value[i], key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("ElementNotFound");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementNotFoundException {
        if (Arrays.asList(abuses).contains(value)) {
            throw new ElementAbuseException("ElementAbuse");
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (ElementAbuseException ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] testFirst = new String[]{"A", "B"};
        String[] testSecond = new String[0];
        String msg = "A";
        process(testFirst, msg, testSecond);
        String[] testFirstEx = new String[0];
        String[] testSecondEx = new String[0];
        String msgEx = "";
        process(testFirstEx, msgEx, testSecondEx);

    }
}
