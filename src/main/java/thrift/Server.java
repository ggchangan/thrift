package thrift;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.topic.service.TopicImpl;
import thrift.topic.service.TopicService;
import thrift.user.service.UserImpl;
import thrift.user.service.UserService;

/**
 * Created by magneto on 16-11-24.
 */
public class Server {
    public static void main(String[] args) throws TTransportException {
        TMultiplexedProcessor processor = new TMultiplexedProcessor();
        TServerTransport t = new TServerSocket(9090);
        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(t).processor(processor));
        processor.registerProcessor("TopicService", new TopicService.Processor<TopicService.Iface>(new TopicImpl()));
        processor.registerProcessor("UserService", new UserService.Processor<UserService.Iface>(new UserImpl()));
        //         TSimpleServer server = new TSimpleServer(new Args(t).processor(processor));
        System.out.println("the serveris started and is listening at 9090...");

        server.serve();
    }

}
