import pymysql;
import mysql_util;

def insert_user():
    conn,cur=mysql_util.get_connect_cursor();
    sql="insert into user (user_name) value ('aaa')"
    mysql_util.execute_insert_update_delete(cur,sql)
    mysql_util.commit_(conn);
    mysql_util.close_connect_cursor(conn,cur);


def connect_mysql():
    connection = pymysql.connect(host='localhost',user='root',password='123456',db='word',charset='utf8');
    cursor=connection.cursor();
    cursor.execute("insert into user (user_name) value ('aaa')")
    cursor.connection.commit();
    cursor.close();
    connection.close();
    return connection,cursor;
def query_user():
    conn, cur = mysql_util.get_connect_cursor();
    sql = "select * from user "
    result=mysql_util.execute_query(cur, sql)
    print(result)
    mysql_util.commit_(conn);
    mysql_util.close_connect_cursor(conn, cur);

if __name__=="__main__":
    #insert_user()
    # connect_mysql();
    query_user()