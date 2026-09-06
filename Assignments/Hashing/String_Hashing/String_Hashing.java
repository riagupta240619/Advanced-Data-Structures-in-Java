package Hashing.String_Hashing;

public class String_Hashing {

    public static long getHash(String str) {

        long hash = 0;

        int base = 31;
        int mod = 1_000_000_007;

        for (int i = 0; i < str.length(); i++) {

            hash =
                    (hash * base + str.charAt(i))
                            % mod;
        }

        return hash;
    }

    public static void main(String[] args) {

        String str1 = "hello";
        String str2 = "world";
        String str3 = "hello";

        long hash1 = getHash(str1);
        long hash2 = getHash(str2);
        long hash3 = getHash(str3);

        System.out.println(
                str1 + " -> " + hash1);

        System.out.println(
                str2 + " -> " + hash2);

        System.out.println(
                str3 + " -> " + hash3);

        if (hash1 == hash3) {
            System.out.println(
                    "\nStrings have the same hash."
            );
        }
    }
}