package thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;
import thrift.topic.service.Topic;
import thrift.topic.service.TopicService;
import thrift.user.service.User;
import thrift.user.service.UserService;

/**
 * Created by magneto on 16-11-24.
 */
public class Client {
    public static void main(String[] args) throws TException {
        TSocket transport = new TSocket("localhost",9090);


        TBinaryProtocol protocol = new TBinaryProtocol(transport);
        TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"TopicService");
        TopicService.Client service1 = new TopicService.Client(mp1);
        TMultiplexedProtocol mp2 = new TMultiplexedProtocol(protocol,"UserService");
        UserService.Client service2 = new UserService.Client(mp2);
        transport.open();
        service1.store(new Topic(668,"test topic","just a test!"));
        service2.store1(new User(888,"tom","haha"));
        System.out.println(service1.retrieve(168));
        System.out.println(service2.retrieve1(999));
        transport.close();
    }
}
