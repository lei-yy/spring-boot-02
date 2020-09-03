import openpyxl;
import random;
import excel_util;


def create_excel1():
    #获取workbook对象
    wb=openpyxl.Workbook();
    #获取active_sheet对象
    active_sheet=wb.get_active_sheet();
    #数据操作
    active_sheet.append(["1","2","3","4"])
    for i in range(1,10):
        active_sheet.append([i*random.randint(1, 10), i*random.randint(1, 10),
                             i*random.randint(1, 10), i*random.randint(1, 10)])
    #文件保存
    wb.save(filename="D:/1/upload/excel_test.xlsx")

def create_excel2():
    header=["一","二","三","四"]
    file_path="D:/1/upload/excel_test.xlsx";
    body=list();
    for i in range(1,10):
        line = list();
        for item in range(1,len(header)+1):
            line.append(item*random.randint(1,10));
        body.append(line)
    excel_util.create_excel(header,body,file_path)

if __name__=="__main__":
#   create_excel1();
    create_excel2();

