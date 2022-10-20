package string;


import java.util.HashSet;

/**
 * Question: LeetCode #929 (Easy)
 * @author binqibang
 * @date 2022/6/4
 */
public class UniqueEmailAddresses {
    /**
     * 遍历字符串
     */
    public static int numUniqueEmails1(String[] emails) {
        HashSet<String> resSet = new HashSet<>();
        for (String email: emails) {
            String local = email.substring(0, email.indexOf('@'));
            String domain = email.substring(email.indexOf('@'));
            StringBuilder curEmailBuilder = new StringBuilder();
            char[] localAr = local.toCharArray();
            for (char elem: localAr) {
                if (elem != '+' && elem != '.') {
                    curEmailBuilder.append(elem);
                } else if (elem == '.') {
                    continue;
                } else {
                    break;
                }
            }
            curEmailBuilder.append(domain);
            resSet.add(curEmailBuilder.toString());
        }
        return resSet.size();
    }

    /**
     * 利用正则表达式
     */
    public static int numUniqueEmails2(String[] emails) {
        HashSet<String> resSet = new HashSet<>();
        for (String email : emails) {
            int i = email.indexOf('@');
            // 去掉本地名第一个加号之后的部分
            String local = email.substring(0, i).split("\\+")[0];
            // 去掉本地名中所有的句点
            local = local.replace(".", "");
            resSet.add(local + email.substring(i));
        }
        return resSet.size();
    }

    public static void main(String[] args) {
        String[] emails = {"fg.r.u.uzj+o.pw@kziczvh.com","r.cyo.g+d.h+b.ja@tgsg.z.com","fg.r.u.uzj+o.f.d@kziczvh.com","r.cyo.g+ng.r.iq@tgsg.z.com","fg.r.u.uzj+lp.k@kziczvh.com","r.cyo.g+n.h.e+n.g@tgsg.z.com","fg.r.u.uzj+k+p.j@kziczvh.com","fg.r.u.uzj+w.y+b@kziczvh.com","r.cyo.g+x+d.c+f.t@tgsg.z.com","r.cyo.g+x+t.y.l.i@tgsg.z.com","r.cyo.g+brxxi@tgsg.z.com","r.cyo.g+z+dr.k.u@tgsg.z.com","r.cyo.g+d+l.c.n+g@tgsg.z.com","fg.r.u.uzj+vq.o@kziczvh.com","fg.r.u.uzj+uzq@kziczvh.com","fg.r.u.uzj+mvz@kziczvh.com","fg.r.u.uzj+taj@kziczvh.com","fg.r.u.uzj+fek@kziczvh.com"};
        System.out.println(numUniqueEmails1(emails));
        System.out.println(numUniqueEmails2(emails));
    }
}
