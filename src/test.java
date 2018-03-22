import com.eny.dao.BookDAO;
import com.eny.dao.Impl.BookDaoImpl;
import com.eny.domain.Book;
import com.eny.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by MoMo on 2018/1/17.
 */
public class test {
    public static void main(String[] args) throws Exception {
        QueryRunner qr = new QueryRunner();
        Connection conn = JdbcUtil.getConnection();
        String sql = "INSERT INTO `book_user` VALUES (?, ?);";
        for(int i=4;i<10;i++){
            Object[] paraValues = {"3", new Integer(i)};
            qr.update(conn,sql,paraValues);
        }

     /*   String bookName = "测试图书";
        for(int i=0; i<500;i++){
            Object[] paraValues = {i+570,bookName+(i+570),5,"陈业业","皮条出版社","2018-1-17","55.5","50"};
            qr.update(conn,sql,paraValues);
        }*/
/*
        BookDAO bookDao = new BookDaoImpl();
        List<Book> stackRoomBookListByUserId = bookDao.findStackRoomBookListByUserId(3);
        System.out.println(stackRoomBookListByUserId);*/

    }
}
