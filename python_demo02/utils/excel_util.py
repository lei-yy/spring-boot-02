import openpyxl

def create_excel(header,body,file_path):
    workbook = openpyxl.Workbook();
    # 获取active_sheet对象
    active_sheet = workbook.get_active_sheet();
    active_sheet.append(header)
    for item in body:
        active_sheet.append(item)
    workbook.save(filename=file_path)