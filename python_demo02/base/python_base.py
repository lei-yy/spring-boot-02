import math,re;

print("hello world")
print("hello","world")
print("hello","world","ssad",sep="--")
num=10
a=20
print(10)
print("%s %s"%(num,a),type("%s"%num))
b=3.1415926
print(b)
print("%10.3f"%b)
a="asd"
print(a)
list=[1,2,"a"]
print(list)
tuple=(1,2,"a")
print(tuple)
dict={"a":1,"b":"a"}
print(dict)

print("98-->%s;a-->%s"%(chr(98),ord('a')))
print(r'ddd')
print(u'aa')
print(b'qwer')
print(len("aaa"))
print(len("是说"))

a="abcnadsasdaf"
print(a.replace("a","*"))
print(a.find("a"))
print(a.rfind("a"))

print("{0},{1:.1f}".format("lyy",1.264))
print("{0},{1}".format("lyy","%.1f"%1.234))

email_re="^[\w]+(\.[\w]+)*@[\w]+(\.[\w]+)+$"
if re.match(email_re,"lei_yyy@163.com"):
    print("ok")
else:
    print("error")
print("a b c".split(" "))
print(re.split(r"\s+","a b c"))
print(re.split(r"[\s\,\;]+","a b;;;,,      c"))

new_text="截至9月2日0时，全省累计报告新型冠状病毒肺炎确诊病例653例(其中境外输入112例)，" \
         "累计治愈出院626例，死亡3例，目前在院隔离治疗24例，964人尚在接受医学观察"
re_str_1=re.compile(r"截至9月2日0时，全省累计报告新型冠状病毒肺炎确诊病例(\d+)例\(其中境外输入(\d+)例\)，"
                    r"累计治愈出院(\d+)例，死亡(\d+)例，目前在院隔离治疗(\d+)例，(\d+)人尚在接受医学观察")
print(re.search(re_str_1,new_text).group(1))
print(re.search(re_str_1,new_text).group(2))
print(re.search(re_str_1,new_text).group(3))
print(re.search(re_str_1,new_text).group(4))
print(re.search(re_str_1,new_text).group(5))
print(re.search(re_str_1,new_text).group(6))

list=[*range(10)]
list.append([10,11])
print(list+[12,13])

tuple=(1,2,3,list)
print(tuple)


for x in range(1,10):
    print(x,end=",")
print("\n")
print("age={},name{}".format(20,"lyy"))
print("age={1},name{0}".format(20,"lyy"))
print("age={age},name{name}".format(name="lyy",age=20))


def test_3(*num):
    count=0
    for i in num:
        count+=i;
        return count;
def test_4(name,**kv):
    if "city" in kv:
        print("name:%s,city:%s"%(name,kv.get("city")))
    else:
        print("name:%s,city:%s"%(name,"chengdu"))
def  test_5(name,*,city):
    if not isinstance(name,(str,)):
        raise TabError("bad Type")
    print("name:%s,city:%s"%(name,city))


if __name__ == "__main__":
    print(test_3(1,2,3,4,5))
    # print(test_3(*list(range(1,9))))
    test_4("lyy",**{"age":33})
    test_4("lyy",**{"age":33,"city":"cd"})
    test_5("lyy",city="chengdu")