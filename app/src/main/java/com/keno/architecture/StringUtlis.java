package com.keno.architecture;


import java.util.Random;

/**** @ProjectName: NewestArchitecture
 * @Package: com.keno.architecture
 * @ClassName: StringUtlis
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/8/29 20:15
 * @UpdateUser: 更新者： 
 * @UpdateDate: 2019/8/29 20:15
 * @UpdateRemark: 更新说明： 
 * @Version: 1.0
 */

public class StringUtlis {

    public static String getRandomeStr() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int length = random.nextInt(10) + 10;
        for (int i = 0; i < length; i++) {
            long result = Math.round(Math.random() * 25 + 97);
            sb.append(String.valueOf((char) result));
        }
        return sb.toString();
    }
}
