namespace java thrift.user.service

struct User
{
    1: i32 uid,
    2: string name,
    3: string blurb
}

service UserService
{
    void store1(1: User user),
    User retrieve1(1: i32 uid)
}
