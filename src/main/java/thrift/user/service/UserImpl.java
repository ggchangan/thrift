package thrift.user.service;

import org.apache.thrift.TException;

/**
 * Created by magneto on 16-11-24.
 */
public class UserImpl implements UserService.Iface {
    @Override public void store1(User user) throws TException {
        System.out.println("the input user: ");
        System.out.println("uid:"+user.getUid());
        System.out.println("name:"+user.getName());
        System.out.println("blur:"+user.getBlurb());
    }

    @Override public User retrieve1(int uid) throws TException {
        System.out.println("the input uid: "+uid);
        return new User(uid,"tom","123");
    }
}
