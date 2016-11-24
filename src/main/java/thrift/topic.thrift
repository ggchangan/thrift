namespace java thrift.topic.service

struct Topic
{
    1: i32 uid,
    2: string name,
    3: string content
}

service TopicService
{
    void store(1: Topic topic),
    Topic retrieve(1: i32 uid)
}
