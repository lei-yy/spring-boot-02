import requests;
import re
from bs4 import BeautifulSoup;

__sc_wjw_regin = "四川"
__sc_wjw_domain = "http://wsjkw.sc.gov.cn"


def requests_test(url):
    new_dict = {}
    r = requests.get(url)
    r.encoding = r.apparent_encoding;

    bs = BeautifulSoup(r.text, "html.parser")
    span_list = bs.find_all(name="span", attrs={"style": "font-size: 12pt;"})
    line = span_list[1].get_text().replace("    ", "")

    # line_re = r"截至9月3日0时，全省累计报告新型冠状病毒肺炎确诊病例(\d+)例\(其中境外输入(\d+)例\），累计治愈出院(\d+)例，死亡(\d+)例，目前在院隔离治疗(\d+)例，(\d+)人尚在接受医学观察。"
    line_re = r"，全省累计报告新型冠状病毒肺炎确诊病例(\d+)例\(其中境外输入(\d+)例\），累计治愈出院(\d+)例，死亡(\d+)例，目前在院隔离治疗(\d+)例，(\d+)人尚在接受医学观察。"
    line_compiler = re.compile(line_re)
    if re.search(line_compiler,line):
        new_dict["确诊病例"] = re.search(line_compiler, line).group(1)
        new_dict["境外输入"] = re.search(line_compiler, line).group(2)
        new_dict["治愈出院"] = re.search(line_compiler, line).group(3)
        new_dict["死亡"] = re.search(line_compiler, line).group(4)
        new_dict["隔离治疗"] = re.search(line_compiler, line).group(5)
        new_dict["医学观察"] = re.search(line_compiler, line).group(6)

    return new_dict


def news_page_data(url):
    news_list = []

    r = requests.get(url)
    r.encoding = r.apparent_encoding;
    bs = BeautifulSoup(r.text, "html.parser")
    li_list = bs.find(name="div", attrs={"class": "wy_contMain fontSt"}).find_all(name='li')

    for li in li_list:
        new_dict = {}
        child_span = li.findChildren("span", recursive=False)[0]
        child_a = li.findChildren("a", recursive=False)[0]
        news_page_url = __sc_wjw_domain + child_a.get("href")

        new_dict["url"] = news_page_url
        new_dict["日期"] = child_span.get_text()

        new_dict["地区"] = __sc_wjw_regin
        news_list.append(new_dict)

    return news_list


if __name__ == "__main__":
    # url = "http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/2020/9/3/fe0eb6e3101d4709a9bbd27f5a12ae78.shtml"
    #       # "http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/2020/8/21/7d77cb1f2f8a486cbb621072cf566e85.shtml"
    # r = requests_test("http://wsjkw.sc.gov.cn/scwsjkw/gzbd01/2020/8/21/7d77cb1f2f8a486cbb621072cf566e85.shtml")
    list_gzbd = news_page_data("http://wsjkw.sc.gov.cn/scwsjkw/gggs/tygl.shtml")

    for i in list_gzbd:
        i.update(requests_test(i.get('url')))
        print(i)