package thrift.topic.service;

import org.apache.thrift.TException;

/**
 * Created by magneto on 16-11-24.
 */
public class TopicImpl implements TopicService.Iface {
    @Override public void store(Topic topic) throws TException {
        System.out.println("the input topic: ");
        System.out.println("id:"+topic.getUid());
        System.out.println("name:"+topic.getName());
        System.out.println("content:"+topic.getContent());
    }

    @Override public Topic retrieve(int uid) throws TException {
        System.out.println("the input uid: "+uid);
        return new Topic(uid,"test","test");
    }
}
