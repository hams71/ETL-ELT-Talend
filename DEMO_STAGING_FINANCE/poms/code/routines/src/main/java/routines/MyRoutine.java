package routines;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class MyRoutine {
    public static String decrypt(String encryptedPassword) {
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < encryptedPassword.length(); i++) {
            char c = encryptedPassword.charAt(i);
            if (c >= 'a' && c <= 'm')
                c += 13;
            else if (c >= 'A' && c <= 'M')
                c += 13;
            else if (c >= 'n' && c <= 'z')
                c -= 13;
            else if (c >= 'N' && c <= 'Z')
                c -= 13;
            output.append(c);
        }
        return output.toString();
    }
    
//    public static String encrypt(String encryptedPassword) {
//        StringBuffer output = new StringBuffer();
//        for (int i = 0; i < encryptedPassword.length(); i++) {
//            char c = encryptedPassword.charAt(i);
//            if (c <= 'a' && c >= 'm')
//                c += 13;
//            else if (c <= 'A' && c >= 'M')
//                c += 13;
//            else if (c <= 'n' && c >= 'z')
//                c -= 13;
//            else if (c <= 'N' && c >= 'Z')
//                c -= 13;
//            output.append(c);
//        }
//        return output.toString();
//    }
}