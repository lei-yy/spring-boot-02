import pymysql;




def get_connect_cursor():
    connection = pymysql.connect(host='localhost',user='root',password='123456',db='word',charset='utf8');
    return connection,connection.cursor();

def execute_insert_update_delete(cursor,sql):
    return cursor.execute(sql);

def execute_query(cursor,sql):
    cursor.execute(sql);
    return cursor.fetchall();

def commit_(conn):
    conn.commit();
def close_connect_cursor(conn,cursor):
    conn.close();
    cursor.close();

